package edu.asu.se.group5.beans;

import java.util.List;

public class HealthserviceProvider extends Member{
	private int referenceNumber;
	private String name;
	private String password;
	private String phone;
	private String emailId;
	private String medicalField;
	private List<Integer> patientList;
	private int numberOfPatients;
	
	public HealthserviceProvider()
	{
		this("name", "email", "password", "phone", 0000, "default field");
	}
	
	public HealthserviceProvider(String name, String email, String password, String phone, int referenceNumber, String medicalField)
	{
		super(name,email,password,phone,referenceNumber);
		this.medicalField = medicalField;
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
	
	public int getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return String.format("<Medical Field: %s>%n%s", this.medicalField, super.toString());
	}
}
