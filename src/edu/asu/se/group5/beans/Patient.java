package edu.asu.se.group5.beans;

import java.util.ArrayList;
import java.util.Arrays;

//import edu.asu.se.group5.business.ArrayList;

public class Patient extends Member
{
	private String doctorAssignedName;
	private int doctorAssignedReferenceNumber;
	
	private String underlyingCondition;
	private ArrayList<int[]> patientHistory = new ArrayList<int[]>();
	private int[] assessmentEvaluationThreshold = {2,4,5,6,9};
	private int[] currentCondition;
	private int historySize = 0;
	
	
	public Patient(){this("name", 0000, "doctor", "email", new char[]{0,0,0,0,0}, "phone", "underlying condition", 0000);}
	
	public Patient(String name, int doctorReferenceNumber, String doctorName, String email, char[] password, String phone, String underlyingCondition, int referenceNumber)
	{
		super(name,email,password,phone,referenceNumber);
		this.doctorAssignedName = doctorName;
		this.doctorAssignedReferenceNumber = doctorReferenceNumber;
		this.underlyingCondition = underlyingCondition;
		this.historySize = 0;
	}
        public boolean hasHistory()
        {
            boolean result = false;
            if(this.historySize != 0)
                result = true;
            return result;
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
			this.currentCondition = Arrays.copyOf(currentCondition, currentCondition.length);//update current
                        updateConditionHistory(this.currentCondition);
			result = String.format("<Patient [%s]: %s> --> Update %s Added %s%n", this.getReferenceNumber(), this.getName(),this.getHistoryCount(), printConditions(this.currentCondition));
		}
		else {result = "You have been logged out, Please Login.";}
                
		return result;
	}
        
        private String printConditions(int[] conditions)
        {
            String result = "{";
            for (int index = 0; index < conditions.length; index++)
                result = result.concat(String.format("[%d]", conditions[index]));
            
            return result.concat("}");
                
        }
        
        public String printHistory()
        {
            String result = "";
            
            result = (String.format("<%s  Total Updates [%d]>%n",getReferenceNumber(), this.patientHistory.size()));
            
            for (int historyIndex = 0; historyIndex < this.patientHistory.size(); historyIndex++)
		{
                        result = result.concat(String.format("History [%2d]: {", historyIndex + 1));
                        
			for(int conditionIndex = 0; conditionIndex < this.patientHistory.get(historyIndex).length; conditionIndex++)
                        {
                           
				result = result.concat(String.format("[%2d]", this.patientHistory.get(historyIndex)[conditionIndex]));
                            if(conditionIndex == this.patientHistory.get(historyIndex).length){result = result.concat(String.format("}%n"));}
                        }
			result = result.concat(String.format("}%n"));
		}
            return result;
        }
	
	//return the patients current condition
	public int[] getCurrentCondition(){return this.currentCondition;}
	
	public void updateConditionHistory(int[] condition)
        {
            this.patientHistory.add(condition);
            this.historySize++;
        }
	
	public ArrayList<int[]> getConditionHistory(){return this.patientHistory;}
	
	public int getHistoryCount(){return this.patientHistory.size();}
	
	public String toString(){return String.format("<Primary Care Physician [%s]: %s>%n<Underlying Condition: %s>%n%s",this.doctorAssignedReferenceNumber, this.doctorAssignedName, this.underlyingCondition, super.toString());}
		
	
}
