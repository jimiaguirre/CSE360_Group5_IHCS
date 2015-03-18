package edu.asu.se.group5.business;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Patient;

public class HealthCareManagementSystem {
	private static HashMap<Integer,Patient> patientList = new HashMap<Integer,Patient>();
	private static HashMap<Integer,HealthserviceProvider> doctorList = new HashMap<Integer,HealthserviceProvider>();
	private static int referenceNumberGenerator = 1001;  
	static Scanner scanIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int flag = 0;
		
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
			}
		}
		scanIn.close(); 
	}
	
	public static void displayDetailsOfPatient() {
		System.err.println("Enter patient's id");
		int referenceNumber = Integer.parseInt(scanIn.nextLine());
		Patient p = patientList.get(referenceNumber);
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
		
		doctorList.put(h1.getReferenceNumber(),h1);
		
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
		
		patientList.put(p1.getReferenceNumber(),p1);
		
		referenceNumberGenerator++;
		
		System.out.println(userName + " is added to the system with reference number " + p1.getReferenceNumber() + ". \n thanks for your time");
	}
	
	
}
