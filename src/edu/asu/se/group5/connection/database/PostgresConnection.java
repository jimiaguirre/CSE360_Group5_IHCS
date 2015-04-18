package edu.asu.se.group5.connection.database;

import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asu.se.group5.beans.HealthCondition;
import edu.asu.se.group5.beans.HealthserviceProvider;
import edu.asu.se.group5.beans.Patient;

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
			//e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres",
					"postgres");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			//getDoctorIds();
		} else {
			System.out.println("Failed to make connection!");
		}
	}*/

	public Integer registerPatient(Patient p1) {
		Connection connection = null;
		String password = new String(p1.getPassword());
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres1111", "postgres","postgres");
			if(connection!=null){
				try {
					CallableStatement patientRegistrationProc = connection.prepareCall("{ ? = call register_patient(?,?,?,?,?) }");
					patientRegistrationProc.registerOutParameter(1, Types.INTEGER);
					patientRegistrationProc.setString(2, p1.getName());
					patientRegistrationProc.setString(3, password);
					patientRegistrationProc.setString(4, String.valueOf(p1.getDoctorAssignedReferenceNumber()));
					patientRegistrationProc.setString(5, p1.getEmailId());
					patientRegistrationProc.setString(6, p1.getPhone());
					
					patientRegistrationProc.execute();
					
					int registration_number = patientRegistrationProc.getInt(1);
					
					return registration_number;
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					return 2;//"SQL exception, please contact administrator";
				}
			}else{
				System.out.println("Failed to make connection!");
				return 3;//"failure";
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			return 3;//"failure";
		}
	}
	
	public List<String> getPatientIds(){
		List<String> patientId = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("select reference_number from patient_details");
					while (rs.next())
					{
					  // System.out.print("Column 1 returned ");
					  // System.out.println(rs.getString(1));
					   patientId.add(rs.getString(1));
					} rs.close();
					st.close();
					return patientId;
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					patientId.add("Failure");
					return patientId;
				}
			}else{
				System.out.println("Failed to make connection!");
				patientId.add("Failure");
				return patientId;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			patientId.add("Failure");
			return patientId;
		}
	}
	
	public List<String> getDoctorIds(){
		List<String> doctorId = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					doctorId.add("Failure");
					return doctorId;
				}
			}else{
				System.out.println("Failed to make connection!");
				doctorId.add("Failure");
				return doctorId;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			doctorId.add("Failure");
			return doctorId;
		}
	}

	public int registerDoctor(HealthserviceProvider h1) {
		Connection connection = null;
		String password = new String(h1.getPassword());
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
			if(connection!=null){
				try {
					CallableStatement doctorRegistrationProc = connection.prepareCall("{ ? = call register_doctor(?,?,?,?,?) }");
					doctorRegistrationProc.registerOutParameter(1, Types.INTEGER);
					doctorRegistrationProc.setString(2, h1.getName());
					doctorRegistrationProc.setString(3, password);
					doctorRegistrationProc.setString(4, h1.getEmailId());
					doctorRegistrationProc.setString(5, h1.getPhone());
					doctorRegistrationProc.setString(6, h1.getMedicalField());
					doctorRegistrationProc.execute();
					
					int registration_number = doctorRegistrationProc.getInt(1);
					
					return registration_number;
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					return 2; //"SQL exception, please contact administrator";
				}
			}else{
				System.out.println("Failed to make connection!");
				return 3;//"failure";
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			return 3; //"failure";
		}

	}

	public Patient getDetailsOfPatient(String patientId) {
		Patient patient = new Patient();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					patient.setName("Failure");
					return patient;
				}
			}else{
				System.out.println("Failed to make connection!");
				patient.setName("Failure");
				return patient;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			patient.setName("Failure");
			return patient;
		}
	}

	public HealthserviceProvider getDetailsOfDoctor(String doctorId) {
		HealthserviceProvider h1 = new HealthserviceProvider();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					h1.setName("Failure");
					return h1;
				}
			}else{
				System.out.println("Failed to make connection!");
				h1.setName("Failure");
				return h1;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			h1.setName("Failure");
			return h1;
		}
	}

	public List<HealthCondition> getLastKHealthStatusUpdates(int i,int patientId)	 {
		List<HealthCondition> hlist = new ArrayList<HealthCondition>();
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
			if(connection!=null){
				try {
					Statement st = connection.createStatement();
					PreparedStatement statement = connection.prepareStatement("select *  from patient_health_status where patient_reference_number = ?");    
					statement.setString(1, String.valueOf(patientId));
					ResultSet rs = statement.executeQuery();
					
					while (rs.next())
					{
					  HealthCondition h1 = new HealthCondition();
					  h1.setPatientReferenceNumber(Integer.parseInt(rs.getString(1)));
					  //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					  //Date date = new Date();
					  h1.setTime(rs.getString(2));
					  h1.setPain(rs.getInt(3));
					  h1.setAnxiety(rs.getInt(6));
					  h1.setDepression(rs.getInt(7));
					  h1.setDrowsiness(rs.getInt(4));
					  h1.setNausea(rs.getInt(5));
					  h1.setDoctor_remark(rs.getString(8));
					  
					  hlist.add(h1);
					  count++;
					  if(count>i){
						  break;
					  }
					} rs.close();
					st.close();
					return hlist;
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					h1.setDoctor_remark("Failure");
					hlist.add(h1);
					return hlist;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				hlist.add(h1);
				return hlist;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			hlist.add(h1);
			return hlist;
		}
		
	}

	public int updateHealthStatusAsPatient(HealthCondition hc1) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					return 2;//"SQL exception, please contact administrator";
				}
			}else{
				System.out.println("Failed to make connection!");
				return 3;//"failure";
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			return 3;//"failure";
		}
	}

	public String[] getConditionCategory() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}
	
	public String[] getAction() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}
	
	public String[] getMedicalField() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}
	
	public String[] getunderlyingConditions() {
		String[] conditionCategory = null;
		List<String> conditionCategoryList = new ArrayList<String>(); 
		int count = 0;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
					HealthCondition h1 = new HealthCondition();
					return null;
				}
			}else{
				System.out.println("Failed to make connection!");
				HealthCondition h1 = new HealthCondition();
				h1.setDoctor_remark("Failure");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
			HealthCondition h1 = new HealthCondition();
			h1.setDoctor_remark("Failure");
			return null;
		}
		
	}

	public void updatePateintStatus(int referenceNumber, int[] object) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres11", "postgres","postgres");
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
				} catch (SQLException e) {
					System.out.println("SQL exception, please contact administrator"); 
					//e.printStackTrace();
				}
			}else{
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();
		}
	}

}
