package edu.asu.se.group5.business;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Member;
import edu.asu.se.group5.beans.Patient;

public class HealthCareManagementSystem 
{		
	private  HashMap<Integer,ArrayList<Object>> patientList = new HashMap<Integer,ArrayList<Object>>();
	private  HashMap<Integer,ArrayList<Object>> doctorList = new HashMap<Integer,ArrayList<Object>>();
	private ArrayList<Object> vals = new ArrayList<Object>();
	
	private  String facility;
	private  int referenceNumberGenerator = 1001;  	

	public HealthCareManagementSystem(){this("Unspecified");}
	
	public HealthCareManagementSystem(String facilityName){this.facility = facilityName;}
	
	public void registerPatient(String userName, String password, String passwordConfirmation, String doctorReferenceNumber, String emailId, String phone)
	{
		
		Scanner scan = new Scanner(System.in);
		//verify matching password
		while(!password.equals(passwordConfirmation))
		{
			System.out.println("\nERROR!\nPasswords do not match!, Please try again");
			System.out.print("Enter Password:");
			password = scan.nextLine();
			System.out.print("Re-Enter Password:");
			passwordConfirmation = scan.nextLine();
		}
		
		//check that doctor ID exists
		Set<Integer> presentDoctorIds = doctorList.keySet();
		while(!presentDoctorIds.contains(Integer.parseInt(doctorReferenceNumber)))
		{						
			System.out.format("%nERROR!%nMedical Doctor [Reference #: %s]%nNot Found, Please re-enter Reference Number:", doctorReferenceNumber);	
			doctorReferenceNumber = scan.nextLine();
		}
				  
		//retrieve HealthserviceProvider object to retrieve name
		HealthserviceProvider temp = (HealthserviceProvider)doctorList.get(Integer.parseInt(doctorReferenceNumber)).get(1);				
		
		//create arrayList for multiple values per single key of hashmap entry
		ArrayList<Object> patientValues = new ArrayList<Object>();
		patientValues.add(emailId);
		patientValues.add(new Patient(userName, Integer.parseInt(doctorReferenceNumber), temp.getName(), emailId, password, phone, "Condition", referenceNumberGenerator));				
		
		//add patient to hash map
		patientList.put(referenceNumberGenerator, patientValues);
		
		//report success of operation
		System.out.format("[Reference Number: %s]%n - %s has been added to \"%s Healthcare Management System\"%n%n", referenceNumberGenerator, userName, this.facility);	
		referenceNumberGenerator++;
	}
	
	public void registerDoctor(String userName, String emailId, String password, String passwordConfirmation, String phone) {

		if(!password.equals(passwordConfirmation))
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
		referenceNumberGenerator++;
	}
	
	public String patientDetails(int referenceNumber) 
	{				
		String result = String.format("<Reference Number [%s]: Invalid>%n", referenceNumber);				
		
		if(patientList.containsKey(referenceNumber));
			result = String.format("<Reference Number [%s]: Found>%n%s%n", referenceNumber, patientList.get(referenceNumber).get(1).toString());		
		
		return result;
	}
	
	public String healthcareProviderDetails(int referenceNumber) 
	{				
		String result = String.format("<Reference Number [%s]: Invalid>%n", referenceNumber);				
		
		if(doctorList.containsKey(referenceNumber));
			result = String.format("<Reference Number [%s]: Found>%n%s%n", referenceNumber, doctorList.get(referenceNumber).get(1).toString());		
		
		return result;
	}


	public int[] evaluate(Patient patient)
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
	public double calculateStdDev(int[] patientData)
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
	public double calculateAverage(double[] input)
	{
		double result = 0;
		for(int index = 0; index < input.length; index++)
			result += input[index];
		result /= (input.length);
		
		return result;
	}
	
	//if patient exists, retrieve patient object from database
	public Patient getPatient(String referenceNumber) 
	{				
		Patient p = (Patient)patientList.get(referenceNumber).get(1);
		
		if(p == null)
		{
			System.out.println("Patient with this id is not present in the system");				
		}
		else
			System.out.println(p.getName());
		return p;
	}
	
	//helper method to convert int[] double []
	public double[] toDoubleArray(int[] array)
	{
		double[] result = new double[array.length];
		
		for(int index=0; index < array.length; index++)
			result[index] = array[index];
		
		return result;
	}
	
	//login method
	public void login(String emailId, String password)
	{
		//search for email. if found, display ref. #
		for(Integer key: patientList.keySet())
		{
			if(patientList.get(key).get(0).equals(emailId))
			{
				//if email exists, proceed to PW Authentication
				System.out.println(patientList.get(key).get(0)+" --> " + key + "\n");
				Patient user = (Patient)patientList.get(key).get(1);
				System.out.println(user.authenticate(password));
			}
		}
	}
	
	public String getFacilityName(){return this.facility;}

}
