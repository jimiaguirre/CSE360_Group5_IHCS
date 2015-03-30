package edu.asu.se.group5.beans;

public class Patient extends Member{
	private int referenceNumber;
	private String name;
	private String password;
	private String phone;
	private String emailId;
	private String doctorAssigned;
	private String underlyingCondition;
	private int[] assessmentEvaluationThreshold;
	private int[] currentCondition;
	
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
	public void setAssessmentEvaluationThreshold(int[] assessmentEvaluationThreshold) {
		this.assessmentEvaluationThreshold = assessmentEvaluationThreshold;
	}
	//set the current patient condition
	public void setCurrentCondition(int[] currentCondition)
	{
		//to do: update patient history within database.
		this.currentCondition = currentCondition;
	}
	//return the patients current condition
	public int[] getCurrentCondition()
	{
		return this.currentCondition;
	}
	
	
	
}
