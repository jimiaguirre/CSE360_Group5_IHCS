package edu.asu.se.group5.business;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Member;
import edu.asu.se.group5.beans.Patient;
import java.util.Arrays;

public class HealthCareManagementSystem 
{		
	private  HashMap<Integer,ArrayList<Object>> patientList = new HashMap<Integer,ArrayList<Object>>();
	private  HashMap<Integer,ArrayList<Object>> doctorList = new HashMap<Integer,ArrayList<Object>>();		
	private  String facility;
	private  int referenceNumberGenerator = 1001;  	
	private int patients, healthcareProviders, logins, transactions, submissions, samples;
        private  ArrayList<Integer> patientKeys = new ArrayList();
        private double standardDeviation, populationMean, populationVariance, minStdDev, maxStdDev;
        

	public HealthCareManagementSystem(){this("Unspecified");}	
	public HealthCareManagementSystem(String facilityName)
	{
		this.facility = facilityName;
		this.patients = this.healthcareProviders = 0;
		this.registerDoctor("Bishop, Walter",new char[]{'i','m','N','o','t','C','r','a','z','y'},"Neuro Surgeon", "0","docBishop@fringe.com", "(555) 555-1512");
		this.registerDoctor("Jekyll, Henry", new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, "Plastic Surgeon","0","biPolar@ontheedge.com", "(555) 531-3357");
		this.registerDoctor("Dre, Doctor", new char[]{'g','i','n','N','J','u','i','c','e'}, "Orthopedics","0", "dreDay@beats.com", "(234) 333-9382");
		this.registerDoctor("Lecter, Hannibal", new char[]{'f','a','c','e','S','t','e','a','k','!'}, "Cardiology","0", "hungry@humans.com", "(223) 543-0929");
		this.registerDoctor("Evil, Doctor", new char[]{'m','i','n','i','m','e'}, "Surgeon","0","evil@doctor.com", "(325) 943-1264");		
	}
        public String printKeys()
        {
            String result = "";
            for(int i = 0; i < this.patientKeys.size(); i++)
                result = result.concat(String.format("%s%n", this.patientKeys.get(i)));
            
            return result;
        }
	
	public boolean passwordsMatch(char[] password, char[] passwordConfirmation)
	{
		boolean valid = true;
		boolean active = true;
				
		char[] t = password;					
		if(password.length == passwordConfirmation.length)
		{
			while(valid && active)
			{
				for(int index = 0; index < password.length; index++)
				{
					if(password[index] != passwordConfirmation[index])
					{
						valid = false;					
						break;
					}
				//System.out.format("%s, %s --> %b%n", this.password[index], input.charAt(index), valid);
				}
				active = false;
			}	
		}
		else
			valid = false;
		
		return valid;
	}
		
	public String register(String memberType, String userName, char[] password, char[] passwordConfirmation, String otherInfo ,String info, String emailId, String phone)
	{
		String result = "Processing";
		
		if(!this.isUniqueEmailId(memberType, emailId))
		{
			result = "Email aleady in use.";
		}
		if (!passwordsMatch(password, passwordConfirmation))
		{
			result = "Passwords do not match.";
			//System.out.println(result);
		}
                
		
		if(result.equals("Processing"))
		{		
			if(memberType.equals("Patient"))
			{
				registerPatient(userName, password, otherInfo, info, emailId, phone);
			}
			else
			{
				registerDoctor(userName, password, otherInfo, info, emailId, phone);
			}
			
			//result = String.format("Registration Complete!");	
			result = String.format("Registration Complete!%n[Reference Number: %s]%n - %s has been added to \"%s Healthcare Management System\"%n%n", referenceNumberGenerator, userName, this.facility);	
			referenceNumberGenerator++;
		}
		
		
		return result;
	}
	
	private void registerPatient(String userName, char[] password, String otherInfo, String info, String emailId, String phone)
	{
		HealthserviceProvider temp = (HealthserviceProvider)doctorList.get(Integer.parseInt(otherInfo)).get(1);					
		//create arrayList for multiple values per single key of hashmap entry
		ArrayList<Object> patientValues = new ArrayList<Object>();
		patientValues.add(emailId);
		patientValues.add(new Patient(userName, Integer.parseInt(otherInfo), temp.getName(), emailId, password, phone, "Condition", this.referenceNumberGenerator));				
		//add patient to hash map
		this.patientList.put(referenceNumberGenerator, patientValues);
                this.patientKeys.add(referenceNumberGenerator);
                

		this.patients++;
	}
	
	private void registerDoctor(String userName, char[] password, String otherInfo, String info, String emailId, String phone) 
	{
		HealthserviceProvider h1 = new HealthserviceProvider();
		ArrayList<Object> doctorValues = new ArrayList<Object>();		
		doctorValues.add(emailId);
		doctorValues.add(new HealthserviceProvider(userName, emailId, password, phone, referenceNumberGenerator, otherInfo, info));
		
		doctorList.put(referenceNumberGenerator, doctorValues);		
				
		System.out.format("[Reference Number: %s]%n - %s has been added to \"%s Healthcare Management System\"%n%n", referenceNumberGenerator, userName, this.facility);		
		
		this.healthcareProviders++;
		referenceNumberGenerator++;
	}
	
	//update patient medical condition status
	//assuming already logged in, the reference number is provided from the caller
	
	private String memberDetail(String memberType, int referenceNumber)
	{
		String result;
		
		if(memberType.equals("Patient"))
			result = patientDetails(referenceNumber);
		else
			result = healthcareProviderDetails(referenceNumber);
		
		return result;
	}
	
	private String patientDetails(int referenceNumber) 
	{				
		String result = String.format("<Reference Number [%s]: Invalid>%n", referenceNumber);				
		
		if(patientList.containsKey(referenceNumber))
			result = String.format("<Reference Number [%s] : Retrieved>%n%s%n", referenceNumber, patientList.get(referenceNumber).get(1).toString());		
		
		return result;
	}
	
	private String healthcareProviderDetails(int referenceNumber) 
	{				
		String result = String.format("<Reference Number [%s]: Invalid>%n", referenceNumber);				
		
		if(doctorList.containsKey(referenceNumber));
			result = String.format("<Reference Number [%s]: Found>%n%s%n", referenceNumber, doctorList.get(referenceNumber).get(1).toString());		
		
		return result;
	}


	//update patient medical condition status
		//assuming already logged in, the reference number is provided from the caller
        public String updatePatientStatus(int referenceNumber, int[] condition)
        {
                String result="";
                Patient p;

                if(patientList.containsKey(referenceNumber))
                {
                        p = (Patient)patientList.get(referenceNumber).get(1);
                        if(p.isActiveSession())
                        {
                            result = String.format("%s%n",p.setCurrentCondition(condition));
                            result = String.format("%s%s",result, p.printHistory());

                            ArrayList<int[]> ph = p.getConditionHistory();
                            result = String.format("%s%s", result, evaluate(p));
                            calculateStdDev();
                        }
                }
                p = null;
                return result;	
        }
	
	public String evaluate(Patient patient)
	{
		//Array of int[] containing data needed for assessment evaluation
		int[] evaluationData[] = {patient.getCurrentCondition(), patient.getAssessmentEvaluationThreshold(), new int[]{0,0,0,0,0}};
                
                double patientScore = 0;
                
                final int[] shift = {0,1};
                int pickShift = 0;
                
                String result="";
                
                patientScore =  calculateAverage(patient.getCurrentCondition());
                
                result = String.format("%nPatient[%s] - SCORE: %s%n<", patient.getReferenceNumber() ,patientScore);
                
                    if(patientScore >= evaluationData[1][4])
                    {
                        result = String.format("%sLevel %s Reached -> 5[%s] <= s[%s]%n", result, 5 ,patientScore, evaluationData[1][4]);
                    }
                    if(patientScore >= evaluationData[1][3] && patientScore < evaluationData[1][4])
                    {
                        result = String.format("%sLevel %s Reached> (5[%s] > s[%s] >= 3[%s]", result, 4, evaluationData[1][4] ,patientScore, evaluationData[1][2]);
                    }
                    if(patientScore >= evaluationData[1][2] && patientScore < evaluationData[1][3])
                    {
                        result = String.format("%sLevel %s Reached> (4[%s] > s[%s] >= 2[%s]", result, 3 ,evaluationData[1][3] ,patientScore, evaluationData[1][1]);

                    }
                    if(patientScore >= evaluationData[1][1] && patientScore < evaluationData[1][2])
                    {
                        result = String.format("%sLevel %s Reached> (3[%s] > s[%s] >= 1[%s]", result, 2 ,evaluationData[1][2] ,patientScore, evaluationData[1][0]);
                    }
                    if(patientScore < evaluationData[1][1])
                    {
                        result = String.format("%sLevel %s Reached> (s[%s] < 1[%s]", result, 1 ,patientScore, evaluationData[1][1]);
                    }
                    
                result = String.format("%s)", result);

		return  result;
	}
	
	//std dev calculator
	//uses each element of the current condition array to calculate std dev. based on all severity ratings
	//provided by the patient
	public String calculateStdDev()
	{
		double result = 0;
                Patient patient;
                ArrayList<int[]> patientHistory;
                ArrayList<double[]> patientCalculation = new ArrayList();
                ArrayList<double[]> systemCalculation = new ArrayList();
                double average;
		
                System.out.println("***STARTING STD DEV. CAlCULATION***");
                
                for(int key = 0; key < this.patientKeys.size(); key++)
                {
                    patient = (Patient)this.patientList.get(this.patientKeys.get(key)).get(1);
                    
                    if(patient.hasHistory())
                    {
                        
                        patientHistory = patient.getConditionHistory();
                        patientCalculation = toDoubleArrayList(patientHistory);
                        average = calculateAverage(patientCalculation);
                        this.populationMean = average;
                    
                    
                        for(int listIndex = 0; listIndex < patientHistory.size(); listIndex++)
                        {   
                            this.submissions++;
                            for(int arrayIndex = 0; arrayIndex < patientHistory.get(listIndex).length; arrayIndex++)
                            {
                                patientCalculation.get(listIndex)[arrayIndex] = Math.pow(patientHistory.get(listIndex)[arrayIndex] - average,2);
                                this.samples++;
                            }
                            systemCalculation.add(patientCalculation.get(listIndex));
                        }

                    }
                }
                
                this.populationVariance = calculateAverage(systemCalculation);
                this.standardDeviation = Math.sqrt(this.populationVariance);
		
                System.out.println("***ENDING STD DEV. CAlCULATION***");
                
		return String.format("MEAN: %s, VAR: %s, STD DEV:%s, Submissions: %s, Samples: %s", this.populationMean, this.populationVariance, this.standardDeviation, this.submissions, this.samples);
	}
	//helper function for calculating average
	private double calculateAverage(ArrayList<double[]> input)
	{
                int count=0;
                String values="";
		double result = 0;
                
                for(int listIndex = 0; listIndex < input.size(); listIndex++)
                {
                    for(int arrayIndex = 0; arrayIndex < input.get(listIndex).length; arrayIndex++)
                    {
                            result += input.get(listIndex)[arrayIndex];
                            values = values.concat(input.get(listIndex)[arrayIndex]+ ",");
                            count++;
                    }
                }
		result /= (input.size() * input.get(0).length);
		return result;
	}
        
        private int calculateAverage(int[] input)
        {
            int result = 0;
            
            for(int i = 0; i < input.length; i++)
                result += input[i];
            
            result /= input.length;
            
            return result;
        }
	
	//if patient exists, retrieve patient object from database
//	private Patient getPatient(String referenceNumber) 
//	{				
//		Patient p = (Patient)patientList.get(referenceNumber).get(1);
//		
//		if(p == null)
//		{
//			System.out.println("Patient with this id is not present in the system");				
//		}
//		else
//			System.out.println(p.getName());
//		return p;
//	}
	
	//helper method to convert int[] double []
	private ArrayList<double[]> toDoubleArrayList(ArrayList<int[]> arrayList)
	{
            ArrayList<double[]> result = new ArrayList<double[]>(arrayList.size());
            double[] temp;
            
		for(int listIndex = 0; listIndex < arrayList.size(); listIndex++)
                    {
                        temp = new double[arrayList.get(listIndex).length];
                        for(int arrayIndex = 0; arrayIndex < arrayList.get(listIndex).length; arrayIndex++)
                        {
                            temp[arrayIndex] = arrayList.get(listIndex)[arrayIndex];
                        }
                        result.add(temp);
                    } 
		return result;
	}
	
	//Patient login method
	public String[] login(String memberType, String emailId, char[] password)
	{		
		String report[] = {"",""};
		int key;
               
		
                if(password.length != 0)
                {
                    if(!emailId.isEmpty())
                    {

                        if(memberType.equals("Patient")) key = verifyEmail(this.patientList ,emailId);
                        else key = verifyEmail(this.doctorList ,emailId); 

                        if(key != 0)
                        {
                                Member user;

                                if(memberType.equals("Patient")){user = (Member)patientList.get(key).get(1);}
                                else {user = (Member)doctorList.get(key).get(1);}

                                if(user.authenticate(password))
                                { 
                                	report[0] = "Logged In."; 
                                	report[1] = this.patientDetails(emailToReferenceNumber(memberType, emailId));
                            	}
                                else report[0] = "Invalid Password.";
                        }

                        else report[0] = "Invalid Email";

                        }
                    else 
                        report[0] = "No Email Entered";
                }
                        else
                            report[0] = "No Password Entered";

                        return report;
	}	
	
	public int verifyEmail(HashMap<Integer, ArrayList<Object>> memberList, String emailId)
	{
		int result = 0;
		//search for email. if found, return reference Number
		for(Integer key: memberList.keySet())
			if(memberList.get(key).get(0).equals(emailId))
				result = key;		
		
		return result;
	}
	
	
	
	public boolean isUniqueEmailId(String memberType, String emailId)
	{
		boolean result = false;
		
		if(memberType.equals("Patient"))
		{
			if(verifyEmail(this.patientList, emailId) == 0)
				result = true;
		}
		else
			if(verifyEmail(this.doctorList, emailId) == 0)
				result = true;
		
		return result;
		
	}
	
	public int emailToReferenceNumber(String memberType, String emailId)
	{
		int result = 0;		
		
		if(memberType.equals("Patient"))
			result = verifyEmail(this.patientList,emailId);								
		else
			result = verifyEmail(this.doctorList,emailId);	
						
		return result;
	}

	public String getFacilityName(){return this.facility;}
	
	public String toString()
	{
		return String.format("Name: [%s]%nHealthcare Providers: [%s]%nPatiens: [%s]", this.facility,this.healthcareProviders,this.patients);
	}

}
