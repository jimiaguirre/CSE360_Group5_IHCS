package edu.asu.se.group5.beans;

import java.util.ArrayList;
import java.util.Arrays;

//import edu.asu.se.group5.business.ArrayList;

public class Patient extends Member
{
	private String doctorAssignedName, doctorAssignedPhone, doctorAssignedEmail;

    public String getDoctorAssignedPhone() {
        return doctorAssignedPhone;
    }

    public void setDoctorAssignedPhone(String doctorAssignedPhone) {
        this.doctorAssignedPhone = doctorAssignedPhone;
    }

    public String getDoctorAssignedEmail() {
        return doctorAssignedEmail;
    }

    public void setDoctorAssignedEmail(String doctorAssignedEmail) {
        this.doctorAssignedEmail = doctorAssignedEmail;
    }
	private int doctorAssignedReferenceNumber;
	
	private String underlyingCondition;
	private ArrayList<int[]> patientHistory = new ArrayList<int[]>();
	private int[] assessmentEvaluationThreshold = {2,4,5,6,9};
	private int[] currentCondition;
	private int historySize = 0;
        private int thresholdUpdates = 1;
        private String messageOut, messageIn;

    public int getThresholdUpdates() {
        return thresholdUpdates;
    }

    public void setThresholdUpdates(int thresholdUpdates) {
        this.thresholdUpdates = thresholdUpdates;
    }
        
        private String[] conditions;
	
	
	public Patient(){this("name", 0000, "doctor Name","doctor Phone","doctor Email", "email", new char[]{0,0,0,0,0}, "phone", "underlying condition", 0000);}
	
	public Patient(String name, int doctorReferenceNumber, String doctorName, String doctorPhone, String doctorEmail, String email, char[] password, String phone, String underlyingCondition, int referenceNumber)
	{
		super(name,email,password,phone,referenceNumber);
                this.doctorAssignedPhone = doctorPhone;
                this.doctorAssignedEmail = doctorEmail;
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

	public void sendMessage(String message) 
        {
            String msg="";
            
            msg = String.format("%nMessages:%n%s: %s%n", super.getName(), message);
            
            super.outbox(message);
        }
        
	
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
	protected void setAssessmentEvaluationThreshold(int[] assessmentEvaluationThreshold) 
        {
            this.assessmentEvaluationThreshold = assessmentEvaluationThreshold;
            this.thresholdUpdates++;
        }
	
	//set the current patient condition
	public String setCurrentCondition(int[] currentCondition, String[] category)
	{
		String result = "";
		if(super.isActive())
		{
                    this.conditions = category;
                    this.currentCondition = Arrays.copyOf(currentCondition, currentCondition.length);//update current
                    updateConditionHistory(this.currentCondition);
                    result = result.concat(String.format("Update Submitted!%n%s%n", printConditions(this.currentCondition, category)));
		}
                
		else {result = "You have been logged out, Please Login.";}
                
                System.out.println(result);
		
                return result;
	}
        
        private String printConditions(int[] condition, String[] category)
        {
            String result = "";
            for (int index = 0; index < condition.length; index++)
                result = result.concat(String.format("%-10s %2d%n", category[index], condition[index]));
            
            return String.format("%s" , result);
                
        }
        
        public String printHistory()
        {
            String result = "";
            if(this.hasHistory())
            {
                result = String.format("%s's History%n", this.getName());
                result += " #|";

                for (int category = 0; category < this.conditions.length; category++)
                    result += String.format("%-10s|", conditions[category]);

                for (int historyIndex = 0; historyIndex < this.patientHistory.size(); historyIndex++)
                {
                        result += String.format("%n%2d)", historyIndex + 1);
                            for(int conditionIndex = 0; conditionIndex < this.patientHistory.get(historyIndex).length; conditionIndex++)
                                result += String.format("%-11d", this.patientHistory.get(historyIndex)[conditionIndex]);
                }
                
            }
            else
                result = String.format("%s has not made any updates.", super.getName());
            
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
	
	public String toString(){return String.format(
                "%sPhysician: %s%n - Ph: %s%n - Email: %s%n", super.toString(), this.doctorAssignedName, this.doctorAssignedPhone, this.doctorAssignedEmail);}

	public ArrayList<int[]> getPatientHistory() {
		return patientHistory;
	}

	public void setPatientHistory(ArrayList<int[]> patientHistory) {
		this.patientHistory = patientHistory;
	}
		
	
}
