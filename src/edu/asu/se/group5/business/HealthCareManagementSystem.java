package edu.asu.se.group5.business;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Member;
import edu.asu.se.group5.beans.Patient;
import edu.asu.se.group5.util.Util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HealthCareManagementSystem 
{		
    private  HashMap<Integer,ArrayList<Object>> patientList = new HashMap<Integer,ArrayList<Object>>();
    private  HashMap<Integer,ArrayList<Object>> doctorList = new HashMap<Integer,ArrayList<Object>>();		
    private  String facility;
  //  private static int referenceNumber = Util.getRefenceNumberGenerator();    //commented for database
	private  int referenceNumberGenerator =  1001;               //referenceNumber + 1;   required when using database
 	private int writeToDatabase = 0;
    //private  int referenceNumberGenerator = 1001;
    private boolean hasMessages;
    private int patients, healthcareProviders, logins, transactions, submissions, samples;
    private  ArrayList<Integer> patientKeys = new ArrayList();
    private double standardDeviation, populationMean, populationVariance, minStdDev, maxStdDev;
    private final String[] conditionCategory = {"Pain","Anxiety","Depression","Nausea","Dizziness"};
    private final String[] action = {"Bed Rest","Take Medication","Call Doctor","Emergency Room","911"};
    private final String[] medicalField = {"Select Field","Cardiology","Neurology","Oncology","Pediatrics","Geriatics","Critical Care"}; 
    private final String[] underlyingConditions = {"Select Condition", "Post Surgery", "Pre Surgery", "Maternity", "Special Needs", "Heart Related", "Other"};
    private  ArrayList<String[]> doctors = new ArrayList();
    
    //SYSTTEM METHODS: USED TO PERFORM TASK WITHIN THE SYSTEM   
    //<editor-fold defaultstate="collapsed" desc="System Methods">
    public HealthCareManagementSystem(){this("Unspecified");}
    public HealthCareManagementSystem(String facilityName)
    {
        this.facility = facilityName;
        this.patients = this.healthcareProviders = 0;
        
        doctors.add(new String[]{"Select Doctor","0000"});
       // this.register("Doctor", "Walter Bishop",new char[]{'1'},new char[]{'1'},"Neuro Surgeon", "0","1", "(555) 555-1512");
        
////		this.register("Doctor", "Bishop, Walter",new char[]{'i','m','N','o','t','C','r','a','z','y'},new char[]{'i','m','N','o','t','C','r','a','z','y'},"Neuro Surgeon", "0","docBishop@fringe.com", "(555) 555-1512");
//        this.register("Doctor", "Henry Jekyll", new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, "Plastic Surgeon","0","biPolar@ontheedge.com", "(555) 531-3357");
//        this.register("Doctor", "Doctor Dre", new char[]{'g','i','n','N','J','u','i','c','e'}, new char[]{'g','i','n','N','J','u','i','c','e'}, "Orthopedics","0", "dreDay@beats.com", "(234) 333-9382");
//        this.register("Doctor", "Hannibal Lecter", new char[]{'f','a','c','e','S','t','e','a','k','!'}, new char[]{'f','a','c','e','S','t','e','a','k','!'}, "Cardiology","6", "hungry@humans.com", "(223) 543-0929");
//        this.register("Doctor", "Doctor Evil", new char[]{'m','i','n','i','m','e'}, new char[]{'m','i','n','i','m','e'}, "Surgeon","0","evil@doctor.com", "(325) 943-1264");
    }
    
    //if Member exists, retrieve Member object from database
    private Member getMember(String memberType, int referenceNumber)
    {
        Member result;
        
        if(memberType.equalsIgnoreCase("Patient"))
            result = getPatient(referenceNumber);
        else
            result = getDoctor(referenceNumber);
        
        return result;
    }
    
    //assuming already logged in, the reference number is provided from the caller
    private String memberDetails(String memberType, int referenceNumber)
    {
        String result;
        if(memberType.equals("Patient"))
            result = patientDetails(referenceNumber);
        else
            result = healthcareProviderDetails(referenceNumber);
        
        return result;
    }
    
    //login method verifies email and password, then returns feedback regarding the success of the login attempt
    public String[] login(String memberType, String emailId, char[] password)
    {
        String report[] = {"",""};
        int key;
        
        if(password.length != 0)
        {
            if(!emailId.isEmpty())
            {
                key = verifyEmail(memberType, emailId);
                if(key != 0)
                {
                    Member user;
                    
                    if(memberType.equals("Patient")){user = (Member)patientList.get(key).get(1);}
                    else {user = (Member)doctorList.get(key).get(1);}
                    
                    if(user.authenticate(password))
                    {
                        report[0] = "Logged In.";
                        report[1] = this.memberDetails(memberType, emailToReferenceNumber(memberType, emailId));
                        this.logins++;
                    }
                    else report[0] = "Invalid Password.";
                }
                else report[0] = "Invalid Email";
                System.out.println(emailId);
                
            }
            else
                report[0] = "No Email Entered";
        }
        else
            report[0] = "No Password Entered";
        
        return report;
    }
    
    public void logout(Member m){m.logOff();}
    
    //add doctor to the doctor list that is used by GUI
    public void addDoctor(String doctor, String referenceNumber){this.doctors.add(new String[]{doctor, referenceNumber});}
    
    public int emailToReferenceNumber(String memberType, String emailId)    { return verifyEmail(memberType,emailId);}
    
    //return the doctor list, which is an list of String[] {doctor name, doctor reference number}
    public ArrayList<String[]> getDoctors() {return this.doctors;}
    
    //print all keys that are in hashmap
    public String printKeys()
    {
        String result = "";
        for(int i = 0; i < this.patientKeys.size(); i++)
            result = result.concat(String.format("%s%n", this.patientKeys.get(i)));
        
        return result;
    }
    
    //return name of facility
    public String getFacilityName(){return this.facility;}
    
    public String toString(){return String.format("Name: [%s]%nHealthcare Providers: [%s]%nPatiens: [%s]", this.facility,this.healthcareProviders,this.patients);}
//</editor-fold>
    
    //REGISTRATION METHODS: used to register a member in to the system
    //<editor-fold defaultstate="collapsed" desc="REGISTRATION METHODS">
    /*
    public String register(memberType, userName, password, passwordConfirmation, otherInfo ,info, emailId, phone)
    private void registerPatient(userName, password, otherInfo, info, emailId, phone)
    private void registerDoctor(userName, password, otherInfo, info, emailId, phone)
    */
    //register a member into the hashmap + Database additions should be done here
    public String register(String memberType, String userName, char[] password, char[] passwordConfirmation, String otherInfo ,String info, String emailId, String phone)
    {
        String result = "Processing"; //Processing of registration has begun
        //Not valid, email already registered, member not added
        if(!this.isUniqueEmailId(memberType, emailId))
            result = "Email aleady in use.";
        //Not valid, passwords do not match, member not added
        if (!passwordsMatch(password, passwordConfirmation))
            result = "Passwords do not match.";
        
        //Email and passwords are valid, proceed to next stage of registration
        if(result.equals("Processing"))
        {	//check if memberType is a patient
            if(memberType.equals("Patient"))
                registerPatient(userName, password, otherInfo, info, emailId, phone);
            //if not patient, must be doctor - the only two member types passed from GUI
            else
                registerDoctor(userName, password, otherInfo, info, emailId, phone);
            //result string changed to reflect success
            result = "Registration Complete!";
            this.transactions++;
            this.referenceNumberGenerator++;
        }
        return result;
    }
    
    //register patient into Hashmap/Database, add Patient to Doctors list of patients
    private void registerPatient(String userName, char[] password, String otherInfo, String info, String emailId, String phone)
    {
        //otherInfo = contains the index of the doctor referenced to by the doctor list.
        //create temporary HealthserviceProvider
        HealthserviceProvider temp = (HealthserviceProvider)doctorList.get(getDoctorNumber(Integer.parseInt(otherInfo))).get(1);
        
        //create arrayList for multiple values per single key of hashmap entry, Email, and Member object
        ArrayList<Object> patientValues = new ArrayList();
        patientValues.add(emailId);//index 0 = email, index 1 = member object
        patientValues.add(new Patient(userName, Integer.parseInt(otherInfo), temp.getName(), temp.getPhone(), temp.getEmailId(), emailId, password, phone, "Condition", this.referenceNumberGenerator));
        
        //add patient to the Doctors list of patients
        temp.addPatient( userName, String.valueOf(referenceNumberGenerator));
        
        //add patient to hash map
        this.patientList.put(referenceNumberGenerator, patientValues);
        this.patientKeys.add(referenceNumberGenerator);
        
        /*******
         * commenting code for data persistance
        
        
      //add patient to database
        Util util = new Util();
        util.addPatientToDoctor(temp.getReferenceNumber(),userName, String.valueOf(referenceNumberGenerator));
        Patient p1 = new Patient();
        p1.setName(userName);
        p1.setPassword(password);
        p1.setDoctorAssignedName(info);
        p1.setDoctorAssignedEmail(temp.getEmailId());
        p1.setDoctorAssignedPhone(temp.getPhone());
        p1.setDoctorAssignedReferenceNumber(Integer.parseInt(otherInfo));
        p1.setEmailId(emailId);
        p1.setPhone(phone);
        p1.setReferenceNumber(referenceNumberGenerator);
        p1.setUnderlyingCondition("condition");
         
        
       
        int registration = util.registerPatient(p1); */
        
        this.patients++;
    }
    
    //register doctor into Hashmap/database
    private void registerDoctor(String userName, char[] password, String otherInfo, String info, String emailId, String phone)
    {
        //create array list to strore doctor values (Email and the Member object)
        ArrayList<Object> doctorValues = new ArrayList();
        doctorValues.add(emailId);
        doctorValues.add(new HealthserviceProvider(userName, emailId, password, phone, referenceNumberGenerator, otherInfo, info));
        //add doctor to doctorList (used by the GUI to display doctors to patient during registration)
        doctorList.put(referenceNumberGenerator, doctorValues);
        
        System.out.format("[Reference Number: %s]%n - %s has been added to \"%s Healthcare Management System\"%n%n", referenceNumberGenerator, userName, this.facility);
        //add doctor to heashmap/database
        this.healthcareProviders++;
        addDoctor(userName, String.valueOf(this.referenceNumberGenerator));
        
        /*******
         * commenting code for data persistance
         
		
		HealthserviceProvider h1 = new HealthserviceProvider();
		h1.setReferenceNumber(referenceNumberGenerator);
		h1.setName(userName);
		h1.setPassword(password);
		h1.setMedicalField(otherInfo);
		h1.setEmailId(emailId);
		h1.setPhone(phone);
		 Util util = new Util();
	     int registration = util.registerDoctor(h1);
	     */
    }
    
//</editor-fold>
    
    //Healthcare Provider Methods: Used by system to access/modify doctor data//method for doctor to update a patients threshold that is contained in the doctors patient list
    //<editor-fold defaultstate="collapsed" desc="Doctor Methods">
    public String updateThreshold(int referenceNumber, int patientIndex, int[] threshold)
    {
        //updates patient threshold through doctors list of patients
        //the patient index referes to the patient at the index  of the list held by the doctor
        //patient list is also used by GUI to generate a drop down list of patients the doctor has
        HealthserviceProvider d = getDoctor(referenceNumber);
        return d.updateThreshold(getPatient(d.getPatientNumber(patientIndex)), threshold);
    }
    public String getPatientHistory(int referenceNumber, int patientIndex)
    {
        HealthserviceProvider d = getDoctor(referenceNumber);
        return d.getPatientHistory(getPatient(d.getPatientNumber(patientIndex)));
    }
    
    
    
    public String getPatientMessage(int referenceNumber, int patientIndex)
    {
        HealthserviceProvider d = getDoctor(referenceNumber);
        return d.getPatientMessage(getPatient(d.getPatientNumber(patientIndex)));
    }
    
    public String sendPatientResponse(int referenceNumber, int patientIndex, String message)
    {
        HealthserviceProvider d = getDoctor(referenceNumber);
        d.sendPatientResponse(getPatient(d.getPatientNumber(patientIndex)), message);
        return "Response Sent.";
    }
    
    
    //retrieve HealthserviceProvider object
    private HealthserviceProvider getDoctor(int referenceNumber)
    {
        HealthserviceProvider d = new HealthserviceProvider();
        if(this.doctorList.containsKey(referenceNumber))
            d = (HealthserviceProvider)this.doctorList.get(referenceNumber).get(1);
        
        return d;
    }
    
    //USED BY GUI return the referenceNumber of doctor referred to by the list
    public int getDoctorNumber(int index){return Integer.parseInt(this.doctors.get(index)[1]);}
//</editor-fold>
    
    //Patient Methods: Methods used by system to access/modify Patient data
    //<editor-fold defaultstate="collapsed" desc="Patient Methods">
    private String healthcareProviderDetails(int referenceNumber) {return doctorList.get(referenceNumber).get(1).toString();}
    
    private String patientDetails(int referenceNumber) {return patientList.get(referenceNumber).get(1).toString();}
    //update patient medical condition status
    //assuming already logged in, the reference number is provided from the caller
    public String updatePatientStatus(int referenceNumber, int[] condition)
    {
        String result="";
        Patient p;
        //verify reference number is valid, then proceed
        if(patientList.containsKey(referenceNumber))
        {
            p = (Patient)patientList.get(referenceNumber).get(1);
            if(p.isActiveSession())//verify the patiet is logged in
            {
                result = String.format("%n%s%n", p.setCurrentCondition(condition, this.conditionCategory));
                result = String.format("%s%s", result, p.printHistory());
                
                result = String.format("%s%s", result, evaluate(p));
                calculateStdDev();
                this.transactions++;
                logout(p);//log out the patient
            }
        }
       // writeToDatabase(referenceNumber,condition,writeToDatabase);    //commented for database
        return result;
    }
    
    /*******
     * commenting code for data persistance
     
    private void writeToDatabase(int referenceNumber, int[] condition,
			int i) {
    	 Util util = new Util();
         util.updatePateintStatus(referenceNumber,condition,i);
	}
    */
    private Patient getPatient(int referenceNumber)
    {
        Patient p = new Patient();
        if(this.patientList.containsKey(referenceNumber))
           p = (Patient)this.patientList.get(referenceNumber).get(1);

        return p;
    }
//</editor-fold>
    
    //EVALUATION METHODS: USED TO EVALUATE A PATIENT, AND CALCULATE STD. DEV
    //<editor-fold defaultstate="collapsed" desc="Evaluation Methods">
    //internal method used but the management class to evaluate a patient based on threshold and standard deviation
    public String evaluate(Patient patient)
    {
        //Array of int[] containing data needed for assessment evaluation
        int[] evaluationData[] = {patient.getCurrentCondition(), patient.getAssessmentEvaluationThreshold()};
        
        double patientScore = 0;
        String result="";
        patientScore = calculateAverage(evaluationData[0]);
        //patientScore =  calculateAverage(patient.getCurrentCondition());
        result = String.format("Health Score: %s%nEvaluation: ", patientScore);
        
        //return evaluation based on the patients score and the threshold limits for each action
        if(patientScore >= evaluationData[1][4])
            result += this.action[4];
        if(patientScore >= evaluationData[1][3] && patientScore < evaluationData[1][4])
            result += this.action[3];
        if(patientScore >= evaluationData[1][2] && patientScore < evaluationData[1][3])
            result += this.action[2];
        if(patientScore >= evaluationData[1][1] && patientScore < evaluationData[1][2])
            result += this.action[1];
        if(patientScore < evaluationData[1][1])
            result += this.action[0];
        
        return  result;
    }
    
    //calculates standard deviation based on all patients within the system
    public String calculateStdDev()
    {
        double result = 0;
        Patient patient;
        ArrayList<int[]> patientHistory;
        ArrayList<double[]> patientCalculation = new ArrayList();
        ArrayList<double[]> systemCalculation = new ArrayList();
        double average;
        
        System.out.println("***STARTING STD DEV. CAlCULATION***");
        
        for(int key = 0; key < this.patientKeys.size(); key++)
        {
            patient = (Patient)this.patientList.get(this.patientKeys.get(key)).get(1);
            
            if(patient.hasHistory())
            {
                patientHistory = patient.getConditionHistory();
                patientCalculation = toDoubleArrayList(patientHistory);
                average = calculateAverage(patientCalculation);
                this.populationMean = average;
                
                for(int listIndex = 0; listIndex < patientHistory.size(); listIndex++)
                {
                    this.submissions++;
                    for(int arrayIndex = 0; arrayIndex < patientHistory.get(listIndex).length; arrayIndex++)
                    {
                        patientCalculation.get(listIndex)[arrayIndex] = Math.pow(patientHistory.get(listIndex)[arrayIndex] - average,2);
                        this.samples++;
                    }
                    systemCalculation.add(patientCalculation.get(listIndex));
                }
            }
        }
        
        this.populationVariance = calculateAverage(systemCalculation);
        this.standardDeviation = Math.sqrt(this.populationVariance);
        
        System.out.println("***ENDING STD DEV. CAlCULATION***");
        
        return String.format("MEAN: %s, VAR: %s, STD DEV:%s, Submissions: %s, Samples: %s", this.populationMean, this.populationVariance, this.standardDeviation, this.submissions, this.samples);
    }
    //helper function for calculating average
    private double calculateAverage(ArrayList<double[]> input)
    {
        int count=0;
        String values="";
        double result = 0;
        
        for(int listIndex = 0; listIndex < input.size(); listIndex++)
        {
            for(int arrayIndex = 0; arrayIndex < input.get(listIndex).length; arrayIndex++)
            {
                result += input.get(listIndex)[arrayIndex];
                values = values.concat(input.get(listIndex)[arrayIndex]+ ",");
                count++;
            }
        }
        result /= (input.size() * input.get(0).length);
        return result;
    }
    
    //overloaded method for average of int[]
    private int calculateAverage(int[] input)
    {
        int result = 0;
        for(int i = 0; i < input.length; i++)
            result += input[i];
        
        result /= input.length;
        
        return result;
    }
    
    //helper method to convert int[] double []
    private ArrayList<double[]> toDoubleArrayList(ArrayList<int[]> arrayList)
    {
        ArrayList<double[]> result = new ArrayList<double[]>(arrayList.size());
        double[] temp;

            for(int listIndex = 0; listIndex < arrayList.size(); listIndex++)
                {
                    temp = new double[arrayList.get(listIndex).length];
                    for(int arrayIndex = 0; arrayIndex < arrayList.get(listIndex).length; arrayIndex++)
                    {
                        temp[arrayIndex] = arrayList.get(listIndex)[arrayIndex];
                    }
                    result.add(temp);
                } 
            return result;
    }
//</editor-fold>
    
    //VALIDATION METHODS: USED TO VALIDATE EMAIL, PASSWORD
    //<editor-fold defaultstate="collapsed" desc="Validation Methods">
    /*
    public int verifyEmail(String memberType, String emailId)
    public boolean isUniqueEmailId(String memberType, String emailId)
    public boolean passwordsMatch(char[] password, char[] passwordConfirmation)
    */
    //verify that both passwords match
    public int verifyEmail(String memberType, String emailId)
    {
        System.out.println("Verify: "+emailId);
        HashMap<Integer, ArrayList<Object>> memberList;
        int result = 0;
        
        if(memberType.equalsIgnoreCase("Patient"))
            memberList = this.patientList;
        else
            memberList = this.doctorList;
        
        //search for email. if found, return reference Number
        for(Integer key: memberList.keySet())
            if(memberList.get(key).get(0).equals(emailId))       
                result = key;
        return result;
    }
    //determine if email already exists within the systems
    public boolean isUniqueEmailId(String memberType, String emailId)
    {
        boolean result = false;
        if(verifyEmail(memberType, emailId) == 0)
            result = true;
        return result;
    }
    public boolean passwordsMatch(char[] password, char[] passwordConfirmation)
    {
        boolean valid = true;
        boolean active = true;
        
        char[] t = password;
        if(password.length == passwordConfirmation.length)
        {
            while(valid && active)
            {
                for(int index = 0; index < password.length; index++)
                {
                    if(password[index] != passwordConfirmation[index])
                    {
                        valid = false;
                        break;
                    }
                }
                active = false;
            }
        }
        else
            valid = false;
        
        return valid;
    }
//</editor-fold>
    
    //GUI METHODS: Methods used by GUI to create fields within the GUI
    //<editor-fold defaultstate="collapsed" desc="GUI METHODS">
    /*
    public String[] getDoctorList() - list of doctors for patient registrations
    public String[] getUnderlyingConditions() - list of underliying condition supported by system
    public String[] getConditionCategory() - list of conditions categories for patient update
    public String[] getAction() - get actions for doctor limit thresholds
    public String[] getMedicalField() - get the medical fields currently supported for doctor registraton
    public String[] getPatientsAssigned(HealthserviceProvider doctor) - get the list of patients currently assigned to a doctors
    */
    //used by GUI to generate a list of Doctors for registering patients to select
    public String[] getDoctorList()
    {
        String[] result = new String[this.doctors.size()];
        
        for(int i = 0; i < this.doctors.size(); i++)
            result[i] = this.doctors.get(i)[0];
        
        return result;
    }
    //USED by GUI return list of underlying conditions
    public String[] getUnderlyingConditions() {return underlyingConditions;}
    
    public String[] getConditionCategory() {return conditionCategory;}
    
    public String[] getAction() {return action;}
    
    public String[] getMedicalField() {return medicalField;}
    
    //used by GUI to generate list of patients assigned to doctor
    public String[] getPatientsAssigned(int referenceNumber)
    {
        
        return checkPatientMessages(referenceNumber ,this.getDoctor(referenceNumber).getPatientList());
    }
    
    public String[] checkPatientMessages(int referenceNumber ,String[] patientList)
    {
        HealthserviceProvider d;
        d = this.getDoctor(referenceNumber);
        String result = "";
        
        for(int i = 0; i < patientList.length; i++)
        {
            if(d.checkPatientOutbox(this.getPatient(d.getPatientNumber(i+1))))
            {
                result = "** ";
                result += patientList[i];
                patientList[i] = result;
                d.setMessagesFlag(true);
                d.addMessagePendingCount();
            }
        }
        
        return patientList;
        
    }
    
    public boolean drHasPendingMessages(int referenceNumber)
    {
        return this.getDoctor(referenceNumber).hasMessages();
    }
    
    public int drMessagesPendingCount(int referenceNumber)
    {
        return this.getDoctor(referenceNumber).getMessagesPendingCount();
    }
    
    

    public String sendMessage(String memberType, int referenceNumber, String message)
    {
        Member m = this.getMember(memberType, referenceNumber); 
        
        m.outbox(message); 
        
        return "Message Sent.";      
    }
    
    public String getMessage(String memberType, int referenceNumber)
    {
       String msg = "\nNew Message!\n";
       Member m = this.getMember(memberType, referenceNumber);
       
       if(m.hasIncoming())
           msg += m.getInbox();
       else
           msg = "\nNo New Messages.\n";
       
       return msg;
       
    }
public int getPatients() {
		return patients;
	}
	public void setPatients(int patients) {
		this.patients = patients;
	}
	//</editor-fold>    
	public HashMap<Integer, ArrayList<Object>> getPatientList() {
		return patientList;
	}
	public void setPatientList(HashMap<Integer, ArrayList<Object>> patientList) {
		this.patientList = patientList;
	}
	public ArrayList<Integer> getPatientKeys() {
		return patientKeys;
	}
	public void setPatientKeys(ArrayList<Integer> patientKeys) {
		this.patientKeys = patientKeys;
	}
	public void setDoctorList(HashMap<Integer, ArrayList<Object>> doctorList) {
		this.doctorList = doctorList;
	}
	public void setDoctors(ArrayList<String[]> doctors) {
		this.doctors = doctors;
	}
	public int getWriteToDatabase() {
		return writeToDatabase;
	}
	public void setWriteToDatabase(int writeToDatabase) {
		this.writeToDatabase = writeToDatabase;
	}
	
}
