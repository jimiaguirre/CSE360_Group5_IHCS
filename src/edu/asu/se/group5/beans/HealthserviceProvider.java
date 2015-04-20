package edu.asu.se.group5.beans;

import java.util.List;
import java.util.ArrayList;

public class HealthserviceProvider extends Member
{	
	//private String password;	
	private String medicalField;
	private ArrayList<String[]> patientList = new ArrayList();
        private ArrayList<Boolean> pendingMessages = new ArrayList();
	private int numberOfPatients;
        private boolean messagesPending;
        private int messagesPendingCount;
        private String[] action = {"Bed Rest","Take Medication","Call Doctor","Emergency Room","911"};
	
	public HealthserviceProvider()
	{
		this("name", "email", new char[]{0,0,0,0}, "phone", 0000, "default field", "0");
	}
	
	public HealthserviceProvider(String name, String email, char[] password, String phone, int referenceNumber, String medicalField, String numberOfPatients)
	{
		super(name,email,password,phone,referenceNumber);
		this.medicalField = medicalField;
                this.patientList = new ArrayList();
                this.numberOfPatients = Integer.parseInt(numberOfPatients);
                System.out.println(this.toString());
	}
        
        public String getPatientMessage(Patient p)
        {
            this.messagesPendingCount--;
            return p.getOutbox();
        }
        
        public void sendPatientResponse(Patient p, String msg)
        {
            p.inbox("Dr. " + super.getName() + ": " + msg);
            
        }
        
        public boolean hasMessages()
        {
            return this.messagesPending;
        }
        
        public void setMessagesFlag(boolean flag)
        {
            this.messagesPending = flag;
        }
        
        public void addMessagePendingCount()
        {
            this.messagesPendingCount++;
        }
        
        public int getMessagesPendingCount()
        {
            return this.messagesPendingCount;
        }
        
	
	public String getMedicalField() {
		return medicalField;
	}

	public void setMedicalField(String medicalField) {
		this.medicalField = medicalField;
	}

	@Override
	public String register() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String updateThreshold(Patient patient, int[] thresholdArray)
        {
            String result = "";
            
            result += String.format("Attempting Update: %s%n", patient.getName());
            result += String.format("From Previous [%2d]%n%s%n", patient.getThresholdUpdates(), getThreshold(patient));
            patient.setAssessmentEvaluationThreshold(thresholdArray);
            result += String.format("Update [%2d] Complete.%n%s%n", patient.getThresholdUpdates(), getThreshold(patient));
            
            return result;
        }
	
	public String getThreshold(Patient patient){return super.toString(patient.getAssessmentEvaluationThreshold(),this.action);}
        
        public String getPatientHistory(Patient patient){ return patient.printHistory();}
	
	public void addPatient(String name, String referenceNumber)
        {
            this.patientList.add(new String[]{name, referenceNumber});
            this.pendingMessages.add(false);
            this.numberOfPatients++;
            System.out.format("%n<[%s] %s>  added to patient list for: %s%n Total Patients: %s%n",referenceNumber, name,this.getName(), this.getNumberOfPatients() );
	}
        
        
	
	public void deletePatient(int referenceNumber){
		this.patientList.remove(referenceNumber);
	}
		
	public String[] getPatientList() 
        {
            String[] result = new String[this.patientList.size()];
        
            for(int i = 0; i < this.patientList.size(); i++)
               result[i] = this.patientList.get(i)[0];
        
            return result;
	}
        
        public boolean checkPatientOutbox(Patient p)
        {
            return p.hasOutgoing();
        }
        
        public int getPatientNumber(int index)
        {
         return Integer.parseInt(this.patientList.get(index-1)[1]);
        }
        
	public void setPatientList(ArrayList<String[]> patientList) {
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
		return String.format
                (
                        "%s%n%s%nPatients:%n%s%n--Total: %s%n",
                        super.toString(),
                        this.medicalField,
                        toString(getPatientList()),
                        this.numberOfPatients
                );
	}
        
        public String toString(String[] array)
        {
            String result = ""; 
            
            for(int i = 0; i < array.length; i++)
                result = result.concat(String.format("%02d: %s%n",i+1, array[i]));
            return result;
        }
}
