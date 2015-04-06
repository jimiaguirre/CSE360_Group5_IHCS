package edu.asu.se.group5.business;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Member;
import edu.asu.se.group5.beans.Patient;

public class HealthCareManagementSystem 
{		
	private  HashMap<Integer,ArrayList<Object>> patientList = new HashMap<Integer,ArrayList<Object>>();
	private  HashMap<Integer,ArrayList<Object>> doctorList = new HashMap<Integer,ArrayList<Object>>();		
	private  String facility;
	private  int referenceNumberGenerator = 1001;  	
	private int patients, healthcareProviders, logins, transactions;

	public HealthCareManagementSystem(){this("Unspecified");}	
	public HealthCareManagementSystem(String facilityName)
	{
		this.facility = facilityName;
		this.patients = this.healthcareProviders = 0;
		this.registerDoctor("Bishop, Walter", "docBishop@fringe.com", new char[]{'i','m','N','o','t','C','r','a','z','y'}, new char[]{'i','m','N','o','t','C','r','a','z','y'}, "(555) 555-1512");
		this.registerDoctor("Jekyll, Henry", "biPolar@ontheedge.com", new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, "(555) 531-3357");
		this.registerDoctor("Dre, Doctor", "dreDay@beats.com", new char[]{'g','i','n','N','J','u','i','c','e'}, new char[]{'g','i','n','N','J','u','i','c','e'}, "(234) 333-9382");
		this.registerDoctor("Lecter, Hannibal", "hungry@humans.com", new char[]{'f','a','c','e','S','t','e','a','k','!'}, new char[]{'f','a','c','e','S','t','e','a','k','!'}, "(223) 543-0929");
		this.registerDoctor("Evil, Doctor", "evil@doctor.com", new char[]{'m','i','n','i','m','e'}, new char[]{'m','i','n','i','m','e'}, "(325) 943-1264");		
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
		
	public String registerPatient(String userName, char[] password, char[] passwordConfirmation, String doctorReferenceNumber, String emailId, String phone)
	{
		String result = "Processing";
		
		//Scanner scan = new Scanner(System.in);
		//verify matching password
		//while(!password.equals(passwordConfirmation))
		//{
			//result = String.format("\nERROR!\nPasswords do not match!, Please try again");
			//System.out.print("Enter Password:");
			//password = scan.nextLine();
			//System.out.print("Re-Enter Password:");
			//passwordConfirmation = scan.nextLine();
		//}
		
		if(!this.isUniqueEmailId("Patient", emailId))
		{
			result = "Email aleady in use.";
		}
		if (!passwordsMatch(password, passwordConfirmation))
		{
			result = "Passwords do not match.";
			System.out.println(result);
		}
		
		//check that doctor ID exists
		//Set<Integer> presentDoctorIds = doctorList.keySet();
//		while(!presentDoctorIds.contains(Integer.parseInt(doctorReferenceNumber)))
//		{						
//			System.out.format("%nERROR!%nMedical Doctor [Reference #: %s]%nNot Found, Please re-enter Reference Number:", doctorReferenceNumber);	
//			doctorReferenceNumber = scan.nextLine();
//		}
				  
		if(result.equals("Processing"))
		{
			//retrieve HealthserviceProvider object to retrieve name
			HealthserviceProvider temp = (HealthserviceProvider)doctorList.get(Integer.parseInt(doctorReferenceNumber)).get(1);				
			
			//create arrayList for multiple values per single key of hashmap entry
			ArrayList<Object> patientValues = new ArrayList<Object>();
			patientValues.add(emailId);
			patientValues.add(new Patient(userName, Integer.parseInt(doctorReferenceNumber), temp.getName(), emailId, password, phone, "Condition", referenceNumberGenerator));				
			
			//add patient to hash map
			patientList.put(referenceNumberGenerator, patientValues);
			
			//report success of operation
			result = String.format("Registration Complete!");	
			referenceNumberGenerator++;
			this.patients++;
		}
		
		return result;
	}
	
	public void registerDoctor(String userName, String emailId, char[] password, char[] passwordConfirmation, String phone) 
	{

		if(!passwordsMatch(password, passwordConfirmation))
		{
			System.out.println("passwords not matching");
			System.exit(0);
		}
		
		HealthserviceProvider h1 = new HealthserviceProvider();

		ArrayList<Object> doctorValues = new ArrayList<Object>();		
		doctorValues.add(emailId);
		doctorValues.add(new HealthserviceProvider(userName, emailId, password, phone, referenceNumberGenerator, "defualt field"));
		
		doctorList.put(referenceNumberGenerator, doctorValues);		
				
		System.out.format("[Reference Number: %s]%n - %s has been added to \"%s Healthcare Management System\"%n%n", referenceNumberGenerator, userName, this.facility);		
		
		this.healthcareProviders++;
		referenceNumberGenerator++;
	}
	
	//update patient medical condition status
	//assuming already logged in, the reference number is provided from the caller
	public void updatePatientStatus(int referenceNumber, int[] condition)
	{
		if(patientList.containsKey(referenceNumber))
		{
			Patient p = (Patient)patientList.get(referenceNumber).get(1);
			System.out.println(p.setCurrentCondition(condition));
		}
		
	}
	
	private String patientDetails(int referenceNumber) 
	{				
		String result = String.format("<Reference Number [%s]: Invalid>%n", referenceNumber);				
		
		if(patientList.containsKey(referenceNumber))
			result = String.format("<Reference Number [%s]: Found>%n%s%n", referenceNumber, patientList.get(referenceNumber).get(1).toString());		
		
		return result;
	}
	
	private String healthcareProviderDetails(int referenceNumber) 
	{				
		String result = String.format("<Reference Number [%s]: Invalid>%n", referenceNumber);				
		
		if(doctorList.containsKey(referenceNumber));
			result = String.format("<Reference Number [%s]: Found>%n%s%n", referenceNumber, doctorList.get(referenceNumber).get(1).toString());		
		
		return result;
	}


	private int[] evaluate(Patient patient)
	{
		//Array of int[] containing data needed for assessment evaluation
		int[] evaluationData[] = {patient.getCurrentCondition(), patient.getAssessmentEvaluationThreshold(), new int[]{0,0,0,0,0}};		
				
		for(int arrayIndex = 0; arrayIndex < Array.getLength(evaluationData[0]); arrayIndex++)
		{	
			//if threshold exceeded, then place 1 to signify specified action must be taken.
			if(evaluationData[0][arrayIndex] >= evaluationData[1][arrayIndex])
				evaluationData[2][arrayIndex] = 1;
			
			//may need to implement average for further evaluation.
			if(evaluationData[0][arrayIndex] < evaluationData[1][arrayIndex])
				evaluationData[2][arrayIndex] = 0;
		}
		
		
		//testing std.dev method to verify results, can be used in threshold eval. above to
		//trigger appropriate course of action
		System.out.println(calculateStdDev(patient.getCurrentCondition()));
		
		return  evaluationData[2];
	}
	
	//std dev calculator
	//uses each element of the current condition array to calculate std dev. based on all severity ratings
	//provided by the patient
	private double calculateStdDev(int[] patientData)
	{
		double result = 0;
		double[] calc = new double[patientData.length];		
		double average = calculateAverage(toDoubleArray(patientData));
		double test = 0;
		
		System.out.println("AVG:"+average);

		for(int index = 0; index < patientData.length; index++)
		{		
			calc[index] = Math.pow(patientData[index]-average, 2); 
			System.out.format("diff[%s]: %s%n ",index,calc[index]);
		}		
		result = Math.sqrt(calculateAverage(calc));						
		return result;
	}
	//helper function for calculating average
	private double calculateAverage(double[] input)
	{
		double result = 0;
		for(int index = 0; index < input.length; index++)
			result += input[index];
		result /= (input.length);
		
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
	private double[] toDoubleArray(int[] array)
	{
		double[] result = new double[array.length];
		
		for(int index=0; index < array.length; index++)
			result[index] = array[index];
		
		return result;
	}
	
	//Patient login method
	public String login(String memberType,String emailId, char[] password)
	{		
		String report = "";
		int key;
		
		if(memberType.equals("Patient")) key = verifyEmail(this.patientList ,emailId);
		else key = verifyEmail(this.doctorList ,emailId); 
		
		if(key != 0)
		{
			Member user;
			
			if(memberType.equals("Patient")){user = (Member)patientList.get(key).get(1);}
			else {user = (Member)doctorList.get(key).get(1);}
			
			if(user.authenticate(password)) report = "Logged In.";
			else report = "Invalid Password.";
		}
		
		else report = "Invalid Email";
		
		
		
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
