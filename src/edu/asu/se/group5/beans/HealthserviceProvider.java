package edu.asu.se.group5.beans;

import java.util.List;

public class HealthserviceProvider extends Member{
	private int referenceNumber;
	private String name;
	private String password;
	private String phone;
	private String emailId;
	private List<Integer> patientList;
	private int numberOfPatients;
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
	
	public String updateThreshold(Patient patient, int[] thresholdArray){
		// TODO Auto-generated method stub
		return null;
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
}
