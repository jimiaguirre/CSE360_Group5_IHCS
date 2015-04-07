package edu.asu.se.group5.beans;

import java.util.List;

public class HealthserviceProvider extends Member
{	
	//private String password;	
	private String medicalField;
	private List<Integer> patientList;
	private int numberOfPatients;
	
	public HealthserviceProvider()
	{
		this("name", "email", new char[]{0,0,0,0}, "phone", 0000, "default field", "0");
	}
	
	public HealthserviceProvider(String name, String email, char[] password, String phone, int referenceNumber, String medicalField, String numberOfPatients)
	{
		super(name,email,password,phone,referenceNumber);
		this.medicalField = medicalField;
                this.numberOfPatients = Integer.parseInt(numberOfPatients);
                System.out.println(this.toString());
	}
	
	@Override
	public String register() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateThreshold(Patient patient, int[] thresholdArray)
	{		
		patient.setAssessmentEvaluationThreshold(thresholdArray);
	}
	
	public String getPatientHistory(Patient patient){
		// TODO Auto-generated method stub
		return null;
	}
	
	public String addPatient(int referenceNumber){
		// TODO Auto-generated method stub
		return null;
	}
	
	public String deletePatient(int referenceNumber){
		// TODO Auto-generated method stub
		return null;
	}
		
	public List<Integer> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<Integer> patientList) {
		this.patientList = patientList;
	}
	public int getNumberOfPatients() {
		return numberOfPatients;
	}
	public void setNumberOfPatients(int numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
	}
	
	public String toString()
	{
		return String.format("<Medical Field: %s>%n<Patients: %s>%n%s", this.medicalField,this.numberOfPatients, super.toString());
	}
}
