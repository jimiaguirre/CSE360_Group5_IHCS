package edu.asu.se.group5.util;

import java.util.List;

import edu.asu.se.group5.beans.HealthCondition;
import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Patient;
import edu.asu.se.group5.connection.database.PostgresConnection;

public class Util {

	public int registerPatient(Patient p1) {
		PostgresConnection conn = new PostgresConnection();
		int returnStatus = conn.registerPatient(p1);
		return returnStatus;
	}

	public int registerDoctor(HealthserviceProvider h1) {
		PostgresConnection conn = new PostgresConnection();
		int returnStatus = conn.registerDoctor(h1);
		return returnStatus;		
	}

	public List<String> getDoctorIds() {
		PostgresConnection conn = new PostgresConnection();
		List<String> doctorIds = conn.getDoctorIds();
		return doctorIds;
	}

	public List<String> getPatientIds() {
		PostgresConnection conn = new PostgresConnection();
		List<String> patientIds = conn.getPatientIds();
		return patientIds;
	}

	public Patient getDetailsOfPatient(String patientId) {
		PostgresConnection conn = new PostgresConnection();
		Patient p = conn.getDetailsOfPatient(patientId);
		return p;
	}

	public HealthserviceProvider getDetailsOfDoctor(String doctorId) {
		PostgresConnection conn = new PostgresConnection();
		HealthserviceProvider p = conn.getDetailsOfDoctor(doctorId);
		return p;
	}

	public List<HealthCondition> getLastKHealthStatusUpdates(int i,int patientId) {
		PostgresConnection conn = new PostgresConnection();
		return conn.getLastKHealthStatusUpdates(i, patientId);
	}

	public int updateHealthStatusAsPatient(HealthCondition hc1) {
		PostgresConnection conn = new PostgresConnection();
		int returnStatus = conn.updateHealthStatusAsPatient(hc1);
		return returnStatus;
	}
}
