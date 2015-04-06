package edu.asu.se.group5.beans;

import java.util.ArrayList;

//import edu.asu.se.group5.business.ArrayList;

public class Patient extends Member
{
	private String doctorAssignedName;
	private int doctorAssignedReferenceNumber;
	
	private String underlyingCondition;
	private ArrayList<int[]> patientHistory = new ArrayList<int[]>();
	private int[] assessmentEvaluationThreshold;
	private int[] currentCondition;
	private int historySize;
	
	
	public Patient(){this("name", 0000, "doctor", "email", new char[]{0,0,0,0,0}, "phone", "underlying condition", 0000);}
	
	public Patient(String name, int doctorReferenceNumber, String doctorName, String email, char[] password, String phone, String underlyingCondition, int referenceNumber)
	{
		super(name,email,password,phone,referenceNumber);
		this.doctorAssignedName = doctorName;
		this.doctorAssignedReferenceNumber = doctorReferenceNumber;
		this.underlyingCondition = underlyingCondition;
		this.historySize = 0;
	}
	

	public String register() {return null;}

	public String sendMessage() {return null;}
	
	public String submitStatus(int[] status){return null;}
	
	public String setThreshold(int[] threshold){return null;}

	public String getDoctorAssignedName() {return this.doctorAssignedName;}
	
	public void setDoctorAssignedName(String doctorName) {this.doctorAssignedName = doctorName;}
	
	public int getDoctorAssignedReferenceNumber() {return this.doctorAssignedReferenceNumber;}
	public void setDoctorAssignedReferenceNumber(int doctorReferenceNumber) {this.doctorAssignedReferenceNumber = doctorReferenceNumber;}
	public String getUnderlyingCondition() {return underlyingCondition;}
	public void setUnderlyingCondition(String underlyingCondition) {this.underlyingCondition = underlyingCondition;}
	
	//return the assessment threshold for a given patient
	public int[] getAssessmentEvaluationThreshold() {return assessmentEvaluationThreshold;}
	
	//for Health care provider use, to set and update the threshold for a given patient.
	protected void setAssessmentEvaluationThreshold(int[] assessmentEvaluationThreshold) {this.assessmentEvaluationThreshold = assessmentEvaluationThreshold;}
	
	//set the current patient condition
	public String setCurrentCondition(int[] currentCondition)
	{
		String result;
		if(super.isActive())
		{
			//to do: update patient history within database.
			this.currentCondition = currentCondition;//update current
			this.patientHistory.add(currentCondition);//add to history list
			this.historySize++;//increment history count
			result = String.format("<Patient [%s]: %s> --> Condition[%2s] Added {%s, %s, %s, %s, %s}", this.getReferenceNumber(), this.getName(),this.getHistoryCount(), currentCondition[0], currentCondition[1], currentCondition[2], currentCondition[3], currentCondition[4]);
		}
		else result = "You have been logged out, Please Login.";
		
		return result;
	}
	
	//return the patients current condition
	public int[] getCurrentCondition(){return this.currentCondition;}
	
	public void updateConditionHistory(int[] condition){this.patientHistory.add(condition);}
	
	public ArrayList<int[]> getConditionHistory(){return this.patientHistory;}
	
	public int getHistoryCount(){return this.historySize;}
	
	public String toString(){return String.format("<Primary Care Physician [%s]: %s>%n<Underlying Condition: %s>%n%s",this.doctorAssignedReferenceNumber, this.doctorAssignedName, this.underlyingCondition, super.toString());}
		
	
}
