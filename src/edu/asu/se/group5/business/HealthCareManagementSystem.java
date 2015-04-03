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

public class HealthCareManagementSystem {
	//private static HashMap<Integer,Patient> patientList = new HashMap<Integer,Patient>();
	//private static HashMap<Integer,HealthserviceProvider> doctorList = new HashMap<Integer,HealthserviceProvider>();
	
	private static HashMap<Integer,ArrayList<Object>> patientList = new HashMap<Integer,ArrayList<Object>>();
	private static HashMap<Integer,ArrayList<Object>> doctorList = new HashMap<Integer,ArrayList<Object>>();
	
	
	
	private static int referenceNumberGenerator = 1001;  
	static Scanner scanIn = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		int flag = 0;
		
		int[] curCon = new int[5];
		int[] thresh = {0,0,0,0,0};
		
		
		Random generator = new Random();
		
		//utilize overloaded constructor to create Member objects.
		HealthserviceProvider doctor = new HealthserviceProvider("Doctor J", "docj@doctor.com", "docPassword", "(555) 555-1512", referenceNumberGenerator++, "Cardiology");		
		
		ArrayList<Object> vals = new ArrayList<Object>();
		Patient p = new Patient("Jimi Aguirre", "Doctor J", "jimi@jimiaguirre.com", "patientPassword", "(555) 555-1212", "Heart Surgery", referenceNumberGenerator++);
		
		vals.add(new String("jimi@jimiaguirre.com"));
		vals.add(p);
		
		
		patientList.put(referenceNumberGenerator, vals);
		
		
		//test PW auth.
		System.out.println(p.authenticate("patientPassword")+"\n");
		
		//test hash email lookup
		//search for email. if found, display ref. #
		for(Integer key: patientList.keySet())
		{
			if(patientList.get(key).get(0).equals("jimi@jimiaguirre.com"))
				System.out.println(patientList.get(key).get(0)+" --> " + key + "\n");
		}
		
		
		//test login method
		login("jimi@jimiaguirre.com", "patientPassword");
		
		
		
		
		//utilize overloaded toString to display member details
		System.out.format("%s%s",doctor,p);
		
		//populate a list of 10 RANDOM health conditions to simulate past medical condition update submissions
		//Random data to be used in std. dev. calculations		
		ArrayList<int[]> pHistory = new ArrayList<int[]>();		
		for (int historyIndex = 0; historyIndex < 10; historyIndex++)
		{
			for(int conditionIndex = 0; conditionIndex < curCon.length; conditionIndex++)
				curCon[conditionIndex] = generator.nextInt(((10 - 0) + 1) - 0);
			p.setCurrentCondition(Arrays.copyOf(curCon, curCon.length));						
		}						
		
		//verify list contains 10 random data entries
		pHistory = p.getConditionHistory();
		System.out.format("Condition History Size: %s%n", pHistory.size());//verify size
			
		//print each element of each ArrayList Entry
		for (int historyIndex = 0; historyIndex < pHistory.size(); historyIndex++)
		{
			System.out.format("History [%s]: {", historyIndex+1);
			for(int conditionIndex = 0; conditionIndex < pHistory.get(historyIndex).length; conditionIndex++)
				System.out.format("%s, ", pHistory.get(historyIndex)[conditionIndex]);
			System.out.format("}%n");
		}
				
		
		//doctor updates patient thresh values
		doctor.updateThreshold(p, new int[]{5,4,7,3,7});		
		
		//evaluate patient given data
		//p.setCurrentCondition(new int[]{5,2,10,4,6});//can use this known current condition to test std. deviation calculation
		
		//store results of evaluation
		int[] data = evaluate(p);
		
		
		//display most recent data, the results in eval, an std. dev.
		System.out.format("Current Condition:%15s","");		
		for(int i = 0; i < curCon.length; i++)
			System.out.format("%d, ",curCon[i]);
		
		
		System.out.format("%nAssessment Evaluation Threshold:%1s","");		
		for(int i = 0; i < p.getAssessmentEvaluationThreshold().length; i++)
			System.out.format("%d, ",p.getAssessmentEvaluationThreshold()[i]);
		
		System.out.format("%nEvaluation Results:%14s","");		
		for(int i = 0; i < data.length; i++)
			System.out.format("%s, ",data[i]);
		System.out.println();
				
		
		
		
		
		while(flag!=1){
			System.out.println("\n\nPlease choose the option");
			System.out.println("\t 1.Register new patient");
			System.out.println("\t 2.Register new doctor");
			System.out.println("\t 3.Get details of patient");
			System.out.println("\t 4.Exit");
			String option;
			
			option = scanIn.nextLine();
			int opt = Integer.parseInt(option.trim());
			switch(opt){
				case 1: registerPatient();
						break;
				case 2: registerDoctor();
						break;
				case 3: displayDetailsOfPatient();
						break;
				case 4: System.out.println("Have a nice day");
						System.exit(0);
						break;
				case 5:
					getPatientData();
					
			}
		}
		scanIn.close(); 
		
		
		
	}
	
	public static void displayDetailsOfPatient() 
	{
		System.err.println("Enter patient's id");
		int referenceNumber = Integer.parseInt(scanIn.nextLine());
		Patient p = (Patient)patientList.get(referenceNumber).get(1);//get Patient
		if(p == null){
			System.out.println("Patient with this id is not present in the system");
			return;
		}else{
			System.out.println("Patient's Name :" + p.getName());
			System.out.println("Patient's Phone :" + p.getPhone());
			System.out.println("Patient's Email id :" + p.getEmailId());
			System.out.println("Patient's doctor :" + p.getDoctorAssigned());
		}
	}		

	public static void registerDoctor() {
		String userName = "";
		String password = "";
		String passwordConfirmation = "";
		String doctor = "";
		String emailId = "";
		String phone = "";
	//	Scanner scanIn = new Scanner(System.in);
		System.out.println("Enter the name of Doctor");
		userName = scanIn.nextLine();
		System.out.println("Enter the password");
		password = scanIn.nextLine();
		System.out.println("Confirm the password");
		passwordConfirmation = scanIn.nextLine();
		if(!password.equals(passwordConfirmation)){
			System.out.println("passwords not matching");
			System.exit(0);
		}
		//System.out.println("Enter the patient assigned");
		//doctor = scanIn.nextLine();
		System.out.println("Enter your email-id");
		emailId = scanIn.nextLine();
		System.out.println("Enter your phone number");
		phone = scanIn.nextLine();
	//	scanIn.close(); 
		
		HealthserviceProvider h1 = new HealthserviceProvider();
		h1.setReferenceNumber(referenceNumberGenerator);
		h1.setName(userName);
		h1.setPassword(password);
		//.setPatientAssigned(doctor);
		h1.setPhone(phone);
		h1.setEmailId(emailId);
		
		//doctorList.put(h1.getReferenceNumber(),h1);
		ArrayList<Object> values = new ArrayList<Object>();
		
		values.add(emailId);
		values.add(h1);
		
		doctorList.put(referenceNumberGenerator, values);
		
		referenceNumberGenerator++;
		
		System.out.println(userName + " is added to the system with reference number " + h1.getReferenceNumber() + ". \n thanks for your time");
	}

	public static void registerPatient(){
		String userName = "";
		String password = "";
		String passwordConfirmation = "";
		String doctor = "";
		String emailId = "";
		String phone = "";
	//	Scanner scanIn = new Scanner(System.in);
		System.out.println("Enter the name of Patient");
		userName = scanIn.nextLine();
		System.out.println("Enter the password");
		password = scanIn.nextLine();
		System.out.println("Confirm the password");
		passwordConfirmation = scanIn.nextLine();
		if(!password.equals(passwordConfirmation)){
			System.out.println("passwords not matching");
			System.exit(0);
		}
		
		System.out.println("Enter the doctor assigned");
		doctor = scanIn.nextLine();
		
		Set<Integer> presentDoctorIds = doctorList.keySet();
		if(!presentDoctorIds.contains(Integer.parseInt(doctor))){
			System.out.println("doctor not present int the system. \nPlease start a new registration");
			return;
		}
		System.out.println("Enter your email-id");
		emailId = scanIn.nextLine();
		System.out.println("Enter your phone number");
		phone = scanIn.nextLine();
	//	scanIn.close(); 
		
		Patient p1 = new Patient();
		p1.setReferenceNumber(referenceNumberGenerator);
		p1.setName(userName);
		p1.setPassword(password);
		p1.setDoctorAssigned(doctor);
		p1.setPhone(phone);
		p1.setEmailId(emailId);
		
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(new String("email@email.com"));
		values.add(p1);
		
		patientList.put(referenceNumberGenerator,values);
		
		referenceNumberGenerator++;
		
		System.out.println(userName + " is added to the system with reference number " + p1.getReferenceNumber() + ". \n thanks for your time");
	}
	
	//evaluate a given patient
	public static int[] evaluate(Patient patient)
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
	public static double calculateStdDev(int[] patientData)
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
	public static double calculateAverage(double[] input)
	{
		double result = 0;
		for(int index = 0; index < input.length; index++)
			result += input[index];
		result /= (input.length);
		
		return result;
	}
	
	//if patient exists, retrieve patient object from database
	public static Patient getPatientData() 
	{
		System.err.println("Enter patient's id");
		int referenceNumber = Integer.parseInt(scanIn.nextLine());
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
	public static double[] toDoubleArray(int[] array)
	{
		double[] result = new double[array.length];
		
		for(int index=0; index < array.length; index++)
			result[index] = array[index];
		
		return result;
	}
	
	//login method
	public static void login(String emailId, String password)
	{
		//search for email. if found, display ref. #
		for(Integer key: patientList.keySet())
		{
			if(patientList.get(key).get(0).equals(emailId))
			{
				//it email exists, proceed to PW Authentication
				System.out.println(patientList.get(key).get(0)+" --> " + key + "\n");
				Patient user = (Patient)patientList.get(key).get(1);
				System.out.println(user.authenticate(password));
			}
		}
	}
	
	

}
