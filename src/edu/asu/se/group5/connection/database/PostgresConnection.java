package edu.asu.se.group5.connection.database;

import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.postgresql.util.PSQLException;

import edu.asu.se.group5.beans.HealthCondition;
import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Patient;
import edu.asu.se.group5.business.HealthCareManagementSystem;

public class PostgresConnection {
	private final String username = "postgres";
	private final String password = "postgres";
	
	/*public static void main(String[] argv) {
		 
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql11://127.0.0.1:5432/postgres11", "postgres",
					"postgres");
 
		} catch (Exception e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			//getDoctorIds();
		} else {
			System.out.println("Failed to make connection!");
		}
	}*/
	/**************************************************************
	 * Method to register patient
	 * @param p1
	 * @return
	 */
	public Integer registerPatient(Patient p1) {
		Connection connection = null;
		String password = new String(p1.getPassword());
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("insert into patient_details(reference_number,username,password,doctor,doctor_name,doctor_email,doctor_phone,emailid,phone,underlying_condition) values(?,?,?,?,?,?,?,?,?,?)");    
					statement.setInt(1, p1.getReferenceNumber());
					statement.setString(2, p1.getName());
					statement.setString(3, String.valueOf(p1.getPassword()));
					statement.setString(4, String.valueOf(p1.getDoctorAssignedReferenceNumber()));
					statement.setString(10, p1.getDoctorAssignedName());
					statement.setString(6, p1.getDoctorAssignedEmail());
					statement.setString(7, p1.getDoctorAssignedPhone());
					statement.setString(8, p1.getEmailId());
					statement.setString(9, p1.getPhone());
					statement.setString(5, p1.getUnderlyingCondition());
					statement.executeUpdate();
					
					
					statement = connection.prepareStatement("insert into ref_number_generator values(?)");
					statement.setInt(1, p1.getReferenceNumber());
					statement.executeUpdate();
					st.close();
					
					return p1.getReferenceNumber();
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					return 0;//"SQL exception, please contact administrator";
				}
			}else{
				System.out.println("Failed to make connection!");
				return 0;//"failure";
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return 0;//"failure";
		}
		finally{
			try {
				connection.close();
			} catch (Exception e) {
				
				e.printStackTrace();
				return 0;
			}
		}
	}
	
	/*******************************************************************************
	 * Method to getPatientIds
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getPatientIds(){
		ArrayList<Integer> patientId = new ArrayList<Integer>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("select reference_number from patient_details");
					while (rs.next())
					{
					  // System.out.print("Column 1 returned ");
					  // System.out.println(rs.getString(1));
					   patientId.add(rs.getInt(1));
					} rs.close();
					st.close();
					return patientId;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					//patientId.add("Failure");
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				//patientId.add("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			//patientId.add("Failure");
			return null;
		}
		
	}
	
	/******************************************************************************
	 * Method to get doctor ids whiich are in database
	 */
	public List<String> getDoctorIds(){
		List<String> doctorId = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("select reference_number from doctor_details");
					while (rs.next())
					{
					  // System.out.print("Column 1 returned ");
					  // System.out.println(rs.getString(1));
					   doctorId.add(rs.getString(1));
					} rs.close();
					st.close();
					return doctorId;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					doctorId.add("Failure");
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				doctorId.add("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			doctorId.add("Failure");
			return null;
		}
		
	}

	/********************************************************************************
	 * method to register doctor in database
	 * @param h1
	 * @return
	 */
	public int registerDoctor(HealthserviceProvider h1) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("insert into doctor_details(reference_number,username,password,emailid,phone,department) values(?,?,?,?,?,?)");    
					statement.setInt(1, h1.getReferenceNumber());
					statement.setString(2, h1.getName());
					statement.setString(3, String.valueOf(h1.getPassword()));
					statement.setString(4, h1.getEmailId());
					statement.setString(5, h1.getPhone());
					statement.setString(6, h1.getMedicalField());
					
					statement.executeUpdate();
					
					statement = connection.prepareStatement("update ref_number_generator set reference_number = ?");
					statement.setInt(1, h1.getReferenceNumber());
					statement.executeUpdate();
					st.close();
					
					
					return h1.getReferenceNumber();
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					return 0; //"SQL exception, please contact administrator";
				}
			}else{
				System.out.println("Failed to make connection!");
				return 0;//"failure";
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return 0; //"failure";
		}
		
	}

	/********************************************************************************************************************
	 * Method to get details of patients from database
	 * @param patientId
	 * @return Patient
	 */
	public Patient getDetailsOfPatient(String patientId) {
		Patient patient = new Patient();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from patient_details where reference_number = ?");    
					statement.setInt(1, Integer.parseInt(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  // System.out.print("Column 1 returned ");
					  // System.out.println(rs.getString(1));
					   patient.setReferenceNumber(Integer.parseInt(rs.getString(1)));
					   patient.setName(rs.getString(2));
					   patient.setDoctorAssignedReferenceNumber(Integer.parseInt(rs.getString(4)));
					   patient.setEmailId(rs.getString(5));
					   patient.setPhone(rs.getString(6));
					   
					} rs.close();
					st.close();
					return patient;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					patient.setName("Failure");
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				patient.setName("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			patient.setName("Failure");
			return null;
		}
		
	}

	/**************************************************************************************************************
	 * method to get details of doctor 
	 * @param doctorId
	 * @return HealthserviceProvider
	 */
	public HealthserviceProvider getDetailsOfDoctor(String doctorId) {
		HealthserviceProvider h1 = new HealthserviceProvider();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from doctor_details where reference_number = ?");    
					statement.setInt(1, Integer.parseInt(doctorId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  // System.out.print("Column 1 returned ");
					  // System.out.println(rs.getString(1));
					   h1.setReferenceNumber(Integer.parseInt(rs.getString(1)));
					   h1.setName(rs.getString(2));
					   //patient.setDoctorAssigned(rs.getString(4));
					   h1.setEmailId(rs.getString(5));
					   h1.setPhone(rs.getString(4));
					   h1.setMedicalField(rs.getString(6));
					} rs.close();
					st.close();
					return h1;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					h1.setName("Failure");
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				h1.setName("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			h1.setName("Failure");
			return null;
		}
		
	}

	/**************************************************************************************************
	 * Method to load health status updates from database
	 * @param patientId
	 * @return List<HealthCondition>
	 */
	public List<HealthCondition> getLastKHealthStatusUpdates(int patientId)	 {
		List<HealthCondition> hlist = new ArrayList<HealthCondition>();
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from patient_health_status where patient_reference_number = ?");    
					statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					if(rs!=null){
						while (rs.next())
						{
						  HealthCondition h1 = new HealthCondition();
						  h1.setPatientReferenceNumber(Integer.parseInt(rs.getString(1)));
						  //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						  //Date date = new Date();
						  h1.setPain(rs.getInt(2));
						  h1.setAnxiety(rs.getInt(5));
						  h1.setDepression(rs.getInt(3));
						  h1.setDrowsiness(rs.getInt(6));
						  h1.setNausea(rs.getInt(4));
						  
						  hlist.add(h1);
						  count++;
						  
						}
					}rs.close();
					st.close();
					System.out.println("for patient " + patientId + "there are " + hlist.size() +" medical updates in database");
					return hlist;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					h1.setDoctor_remark("Failure");
					hlist.add(h1);
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				hlist.add(h1);
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			hlist.add(h1);
			return null;
		}
		
	}

	/**************************************************************************************
	 * method to update health status as a patient
	 * @param hc1
	 * @return int success message
	 */
	public int updateHealthStatusAsPatient(HealthCondition hc1) {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					CallableStatement updateHealthProcedure = connection.prepareCall("{ ? = call update_health_condition(?,?,?,?,?,?,?) }");
					updateHealthProcedure.registerOutParameter(1, Types.INTEGER);
					updateHealthProcedure.setInt(2, hc1.getPatientReferenceNumber());
					updateHealthProcedure.setString(3, hc1.getTime());
					updateHealthProcedure.setInt(4, hc1.getPain());
					updateHealthProcedure.setInt(5, hc1.getDrowsiness());
					updateHealthProcedure.setInt(6, hc1.getNausea());
					updateHealthProcedure.setInt(7, hc1.getAnxiety());
					updateHealthProcedure.setInt(8, hc1.getDepression());
					
					updateHealthProcedure.execute();
					
					int registration_number = updateHealthProcedure.getInt(1);
					
					return registration_number;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					return 0;//"SQL exception, please contact administrator";
				}
			}else{
				System.out.println("Failed to make connection!");
				return 0;//"failure";
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return 0;//"failure";
		}
	}

	/**********************************************************************************
	 * Method to get the condition category from database
	 * @return
	 */
	public String[] getConditionCategory() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from condition_category");    
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  String condition = rs.getString(1);
					  conditionCategoryList.add(condition);
					} rs.close();
					st.close();
					Iterator<String> it = conditionCategoryList.iterator();
					conditionCategory = new String[conditionCategoryList.size()];
					for(int i=0;i<conditionCategoryList.size();i++){
						conditionCategory[i] = it.next();
					}
					return conditionCategory;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}
	
	/**********************************************************************************
	 * Method to get the action from database
	 * @return
	 */
	public String[] getAction() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from action");    
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  String condition = rs.getString(1);
					  conditionCategoryList.add(condition);
					} rs.close();
					st.close();
					Iterator<String> it = conditionCategoryList.iterator();
					conditionCategory = new String[conditionCategoryList.size()];
					for(int i=0;i<conditionCategoryList.size();i++){
						conditionCategory[i] = it.next();
					}
					return conditionCategory;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}
	
	/**********************************************************************************
	 * Method to get the medical field from database
	 * @return
	 */
	public String[] getMedicalField() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from medical_field");    
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  String condition = rs.getString(1);
					  conditionCategoryList.add(condition);
					} rs.close();
					st.close();
					Iterator<String> it = conditionCategoryList.iterator();
					conditionCategory = new String[conditionCategoryList.size()];
					for(int i=0;i<conditionCategoryList.size();i++){
						conditionCategory[i] = it.next();
					}
					return conditionCategory;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}
	
	/**********************************************************************************
	 * Method to get the underlying conditions from database
	 * @return
	 */
	public String[] getunderlyingConditions() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from underlying_condition");    
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  String condition = rs.getString(1);
					  conditionCategoryList.add(condition);
					} rs.close();
					st.close();
					Iterator<String> it = conditionCategoryList.iterator();
					conditionCategory = new String[conditionCategoryList.size()];
					for(int i=0;i<conditionCategoryList.size();i++){
						conditionCategory[i] = it.next();
					}
					return conditionCategory;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}

	/****************************************************************************************
	 * Method called when a patient udpates his status
	 * @param referenceNumber
	 * @param object
	 */
	public void updatePateintStatus(int referenceNumber, int[] object) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("insert into patient_health_status(patient_reference_number,pain,drowsiness,nausea,anxiety,depression) values(?,?,?,?,?,?)");    
					statement.setString(1, String.valueOf(referenceNumber));
					statement.setInt(2, object[0]);
					statement.setInt(3, object[4]);
					statement.setInt(4, object[3]);
					statement.setInt(5, object[1]);
					statement.setInt(6, object[2]);
					statement.executeUpdate();
					st.close();
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					return;
				}
			}else{
				System.out.println("Failed to make connection!");
				return;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}

	/******************************************************************************************************
	 * method to load patients on start
	 * @return HashMap<Integer, ArrayList<Object>>
	 */
	public HashMap<Integer, ArrayList<Object>> loadPatients() {
		HashMap<Integer, ArrayList<Object>> patientList = new HashMap<Integer, ArrayList<Object>>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select "
							+ "reference_number,username,password,doctor,emailid,phone,"
							+ " doctor_email,doctor_phone,doctor_name,underlying_condition  from patient_details");    
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					 
					
					 
					while (rs.next())
					{	
						 ArrayList<Object> add = new ArrayList<Object>();
						 Integer reference_number = 0;
						Patient p1 = new Patient();
					  reference_number = rs.getInt(1);
					  String emailId = rs.getString(5);
					  System.out.println("reference no of patient" + reference_number);
					  p1.setName(rs.getString(2));
					  p1.setPassword(rs.getString(3));
					  p1.setPassword(rs.getString(3).toCharArray());
					  System.out.println("email in DB is + " + emailId);
					  p1.setDoctorAssignedEmail(rs.getString(7));
					  p1.setDoctorAssignedName(rs.getString(9)) ;
					  p1.setDoctorAssignedPhone(rs.getString(8));
					  p1.setDoctorAssignedReferenceNumber(Integer.parseInt(rs.getString(4)));
					  p1.setEmailId(emailId);
					  p1.setPhone(rs.getString(6));
					  p1.setReferenceNumber(rs.getInt(1));
					  p1.setUnderlyingCondition(rs.getString(10));
					  
					  add.add(p1.getEmailId());
					  add.add(p1);
					  System.out.println("email id after add is : " + emailId);
					  patientList.put(reference_number, add);
					  getLastKHealthStatusUpdates(p1.getReferenceNumber());
					 
					} rs.close();
					st.close();
					System.out.println("patient list size is " + patientList.size());
					for(Integer key: patientList.keySet()){
	            		System.out.println("key is " + key);
	            		ArrayList test = patientList.get(key);
	            		System.out.println("email id is : " + test.get(0));
					}		
					  return patientList;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
	}

	/***********************************************************************************
	 * method tp load all the doctors at start
	 * @return
	 */
	public HashMap<Integer, ArrayList<Object>> loadDoctors() {
		HashMap<Integer, ArrayList<Object>> patientList = new HashMap<Integer, ArrayList<Object>>();
		HealthCareManagementSystem hsystem = new HealthCareManagementSystem();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select "
							+ "reference_number,username,password,emailid,phone,"
							+ " department,patient_list  from doctor_details");  
								
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
						 ArrayList<Object> add = new ArrayList<Object>();
							
						 Integer reference_number = 0;
						 String emailID = "";
					  HealthserviceProvider p1 = new HealthserviceProvider();
					  reference_number = rs.getInt(1);
					  emailID = rs.getString(4);
					  
					  p1.setName(rs.getString(2));
					  p1.setPassword(rs.getString(3));
					  p1.setPassword(rs.getString(3).toCharArray());
					  p1.setEmailId(rs.getString(4));
					  p1.setPhone(rs.getString(5));
					  p1.setReferenceNumber(rs.getInt(1));
					  p1.setMedicalField(rs.getString(6));
					  String listOfPatients = rs.getString(7);
					  if(listOfPatients != null){
						  String[] patients = listOfPatients.split(":");
					 
					  for(int i=0;i<patients.length;i++){
						  String name = patients[i];
						  i++;
						  p1.addPatient(name, patients[i]);
					  }
					  }
					  add.add(emailID);
					  add.add(p1);
					  patientList.put(reference_number, add);
					  hsystem.addDoctor(rs.getString(2), String.valueOf(reference_number));
					} rs.close();
					st.close();
					
					  return patientList;
				}catch(PSQLException e){
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
					return null;
				} 
				catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch(PSQLException e){
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		
	}

	/************************************************************************************
	 * Method to get  the reference number generator
	 * @return
	 */
	public Integer getRefenceNumberGenerator() {
		int ref = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select max(reference_number) from ref_number_generator");
								
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  ref = rs.getInt(1);
					} rs.close();
					st.close();
					
					  return ref;
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator"); 
					e.printStackTrace();
					return 0;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return 0;
		}finally{
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
				
			}
		}
	}

	public void addPatientToDoctor(int i, String userName, String ref) {
		String list = "";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql11://127.0.0.1:5432/postgres", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select patient_list from doctor_details");
								
					//statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  list = rs.getString(1);
					} rs.close();
					
					if(list!=null){
						list +=  userName + ":" + ref + ":";
					}else{
						list = userName + ":" + ref + ":";
					}
					
					statement = connection.prepareStatement("update doctor_details set patient_list = ? where reference_number = ?");
					statement.setString(1, list);
					statement.setInt(2,i);
					statement.executeUpdate();
					st.close();
					
				} catch (Exception e) {
					System.out.println("SQL exception, please contact administrator while loading  doctor "); 
					e.printStackTrace();
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
			}
		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
	}
}
