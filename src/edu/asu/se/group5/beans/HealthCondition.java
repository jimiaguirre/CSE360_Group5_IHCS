package edu.asu.se.group5.beans;

public class HealthCondition {
	private int HealthConditionRecordNumber;
	private int patientReferenceNumber;
	private String time;
	private int pain;
	private int drowsiness;
	private int nausea;
	private int anxiety;
	private int depression;
	private String doctor_remark;
	public int getHealthConditionRecordNumber() {
		return HealthConditionRecordNumber;
	}
	public void setHealthConditionRecordNumber(int healthConditionRecordNumber) {
		HealthConditionRecordNumber = healthConditionRecordNumber;
	}
	public int getPatientReferenceNumber() {
		return patientReferenceNumber;
	}
	public void setPatientReferenceNumber(int patientReferenceNumber) {
		this.patientReferenceNumber = patientReferenceNumber;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPain() {
		return pain;
	}
	public void setPain(int pain) {
		this.pain = pain;
	}
	public int getDrowsiness() {
		return drowsiness;
	}
	public void setDrowsiness(int drowsiness) {
		this.drowsiness = drowsiness;
	}
	public int getNausea() {
		return nausea;
	}
	public void setNausea(int nausea) {
		this.nausea = nausea;
	}
	public int getAnxiety() {
		return anxiety;
	}
	public void setAnxiety(int anxiety) {
		this.anxiety = anxiety;
	}
	public int getDepression() {
		return depression;
	}
	public void setDepression(int depression) {
		this.depression = depression;
	}
	public String getDoctor_remark() {
		return doctor_remark;
	}
	public void setDoctor_remark(String string) {
		this.doctor_remark = string;
	}
	
	
}
