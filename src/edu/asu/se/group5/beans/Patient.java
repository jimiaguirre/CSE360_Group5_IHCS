package edu.asu.se.group5.beans;


import java.awt.List;
import java.util.ArrayList;

//import edu.asu.se.group5.business.ArrayList;

public class Patient extends Member
{
	private int referenceNumber;
	private String name;
	private String password;
	private String phone;
	private String emailId;
	private String doctorAssigned;
	
	private String underlyingCondition;
	private ArrayList<int[]> patientHistory = new ArrayList<int[]>();
	private int[] assessmentEvaluationThreshold;
	private int[] currentCondition;
	private int historySize;
	
	
	public Patient()
	{
		this("name", "doctor", "email", "password", "phone", "underlying condition", 0000);
	}
	
	public Patient(String name, String doctor, String email, String password, String phone, String underlyingCondition, int referenceNumber)
	{
		super(name,email,password,phone,referenceNumber);
		this.doctorAssigned = doctor;	
		this.underlyingCondition = underlyingCondition;
		this.historySize = 0;
	}
	
	@Override
	public String register() {
		// TODO Auto-generated method stub
		return null; //return success message
	}
	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
		return null; //return success message
	}
	
	public String submitStatus(int[] status){
		// TODO Auto-generated method stub
		return null; //return success message
	}
	
	public String setThreshold(int[] threshold){
		// TODO Auto-generated method stub
		return null; //return success message
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
////	public String getPassword() {
////		return password;
////	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
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
	public String getDoctorAssigned() {
		return doctorAssigned;
	}
	public void setDoctorAssigned(String doctorAssigned) {
		this.doctorAssigned = doctorAssigned;
	}
	public String getUnderlyingCondition() {
		return underlyingCondition;
	}
	public void setUnderlyingCondition(String underlyingCondition) {
		this.underlyingCondition = underlyingCondition;
	}
	//return the assessment threshold for a given patient
	public int[] getAssessmentEvaluationThreshold() {
		return assessmentEvaluationThreshold;
	}
	//for Health care provider use, to set and update the threshold for a given patient.
	protected void setAssessmentEvaluationThreshold(int[] assessmentEvaluationThreshold) {
		this.assessmentEvaluationThreshold = assessmentEvaluationThreshold;
	}
	//set the current patient condition
	public void setCurrentCondition(int[] currentCondition)
	{
		//to do: update patient history within database.
		this.currentCondition = currentCondition;//update current
		this.patientHistory.add(currentCondition);//add to history list
		this.historySize++;//increment history count
	}
	//return the patients current condition
	public int[] getCurrentCondition()
	{
		return this.currentCondition;
	}
	
	public void updateConditionHistory(int[] condition)
	{
		//update Condition History using
		this.patientHistory.add(condition);		
	}
	
	public ArrayList<int[]> getConditionHistory()
	{
		return this.patientHistory;
	}
	public int getHistoryCount()
	{
		return this.historySize;
	}
	
	public String toString()
	{
		return String.format("<Primary Care Physician: %s>%n<Underlying Condition: %s>%n%s",this.doctorAssigned, this.underlyingCondition, super.toString());
	}
	
	
	
}
