package edu.asu.se.group5.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.asu.se.group5.beans.HealthCondition;
import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Patient;
import edu.asu.se.group5.connection.database.PostgresConnection;

public class Util {

	/**************************************************************
	 * Method to register patient
	 * @param p1
	 * @return
	 */
	public int registerPatient(Patient p1) {
		PostgresConnection conn = new PostgresConnection();
		int returnStatus = conn.registerPatient(p1);
		return returnStatus;
	}

	/*******************************************************************************
	 * Method to register doctors
	 * @return ArrayList<Integer>
	 */
	public int registerDoctor(HealthserviceProvider h1) {
		PostgresConnection conn = new PostgresConnection();
		int returnStatus = conn.registerDoctor(h1);
		return returnStatus;		
	}

	/******************************************************************************
	 * Method to get doctor ids whiich are in database
	 */
	public List<String> getDoctorIds() {
		PostgresConnection conn = new PostgresConnection();
		List<String> doctorIds = conn.getDoctorIds();
		return doctorIds;
	}

	/********************************************************************************
	 * method to get patients from database
	 * @param h1
	 * @return
	 */
	public ArrayList<Integer> getPatientIds() {
		PostgresConnection conn = new PostgresConnection();
		ArrayList<Integer> patientIds = conn.getPatientIds();
		return patientIds;
	}

	/********************************************************************************************************************
	 * Method to get details of patients from database
	 * @param patientId
	 * @return Patient
	 */
	public Patient getDetailsOfPatient(String patientId) {
		PostgresConnection conn = new PostgresConnection();
		Patient p = conn.getDetailsOfPatient(patientId);
		return p;
	}

	/**************************************************************************************************************
	 * method to get details of doctor 
	 * @param doctorId
	 * @return HealthserviceProvider
	 */
	public HealthserviceProvider getDetailsOfDoctor(String doctorId) {
		PostgresConnection conn = new PostgresConnection();
		HealthserviceProvider p = conn.getDetailsOfDoctor(doctorId);
		return p;
	}

	/**************************************************************************************************
	 * Method to load health status updates from database
	 * @param patientId
	 * @return List<HealthCondition>
	 */
	public List<HealthCondition> getLastKHealthStatusUpdates(int patientId) {
		PostgresConnection conn = new PostgresConnection();
		return conn.getLastKHealthStatusUpdates(patientId);
	}

	/**************************************************************************************
	 * method to update health status as a patient
	 * @param hc1
	 * @return int success message
	 */
	public int updateHealthStatusAsPatient(HealthCondition hc1) {
		PostgresConnection conn = new PostgresConnection();
		int returnStatus = conn.updateHealthStatusAsPatient(hc1);
		return returnStatus;
	}

	/**********************************************************************************
	 * Method to get the condition category from database
	 * @return
	 */
	public String[] getConditionCategory() {
		PostgresConnection conn = new PostgresConnection();
		String[] conditionCategory = conn.getConditionCategory();
		return conditionCategory;
	}
	
	/**********************************************************************************
	 * Method to get the action from database
	 * @return
	 */
	public String[] getAction() {
		PostgresConnection conn = new PostgresConnection();
		String[] conditionCategory = conn.getAction();
		return conditionCategory;
	}
	
	/**********************************************************************************
	 * Method to get the medical field from database
	 * @return
	 */
	public String[] getMedicalField() {
		PostgresConnection conn = new PostgresConnection();
		String[] conditionCategory = conn.getMedicalField();
		return conditionCategory;
	}
	
	/**********************************************************************************
	 * Method to get the underlying conditions from database
	 * @return
	 */
	public String[] getunderlyingConditions() {
		PostgresConnection conn = new PostgresConnection();
		String[] conditionCategory = conn.getunderlyingConditions();
		return conditionCategory;
	}

	/****************************************************************************************
	 * Method called when a patient udpates his status
	 * @param referenceNumber
	 * @param object
	 */
	public void updatePateintStatus(int referenceNumber, int[] object, int i) {
		if(i != 1){
		PostgresConnection conn = new PostgresConnection();
		conn.updatePateintStatus(referenceNumber,object);
		}else{
			
		}
	}

	/******************************************************************************************************
	 * method to load patients on start
	 * @return HashMap<Integer, ArrayList<Object>>
	 */
	public HashMap<Integer, ArrayList<Object>> loadPatients() {
		PostgresConnection conn = new PostgresConnection();
		HashMap<Integer, ArrayList<Object>> patientList = conn.loadPatients();
		return patientList;
	}

	/***********************************************************************************
	 * method tp load all the doctors at start
	 * @return
	 */
	public HashMap<Integer, ArrayList<Object>> loadDoctors() {
		PostgresConnection conn = new PostgresConnection();
		HashMap<Integer, ArrayList<Object>> doctorList = conn.loadDoctors();
		return doctorList;
	}

	/************************************************************************************
	 * Method to get  the reference number generator
	 * @return
	 */
	public static int getRefenceNumberGenerator() {
		PostgresConnection conn = new PostgresConnection();
		Integer ref = conn.getRefenceNumberGenerator();
		return ref;
	}

	public void addPatientToDoctor(int i, String userName, String ref) {
		PostgresConnection conn = new PostgresConnection();
		conn.addPatientToDoctor(i,userName,ref);
	}

}
