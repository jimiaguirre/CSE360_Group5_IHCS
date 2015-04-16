package edu.asu.se.group5.beans;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;




import edu.asu.se.group5.business.HealthCareManagementSystem;
import gui.InitialMenu;

public class test 
{

	public static void main(String[] args) 
	{
            
		int flag = 0;
		
		int[] curCon = new int[5];
		int[] thresh = {0,0,0,0,0};				
		Random generator = new Random();
		
		HealthCareManagementSystem system = new HealthCareManagementSystem("Eddie Cares");
		System.out.format("System Name: %s%n%n", system.getFacilityName());
		
		
		//system.registerDoctor("Doctor J", "docj@doctor.com", "docPassword", "docPassword", "(555) 555-1512");
		
		//system.registerPatient("Jimi Aguirre", new char[]{'s','e','c','u','r','e','P','W'}, new char[]{'s','e','c','u','r','e','P','W'}, "1001", "jimi@jimiaguirre.com", "555-5511");
		//system.register("Patient","Jimi Aguirre", new char[]{'1'}, new char[]{'1'}, "1001", "pain", "1", "555-5511");
//		system.register("Patient","Savannah P", new char[]{'s','e','c','u','r','e','P','W'}, new char[]{'s','e','c','u','r','e','P','W'}, "1001","pain", "sp@email.com", "555-5511");
//		system.register("Patient","Eddie Wolf", new char[]{'s','e','c','u','r','e','P','W'}, new char[]{'s','e','c','u','r','e','P','W'}, "1001","pain", "wolfpack@email.com", "555-5511");
//		system.register("Patient","Deepak parameshawarn", new char[]{'s','e','c','u','r','e','P','W'}, new char[]{'s','e','c','u','r','e','P','W'}, "1001","pain", "deepak@email.com", "555-5511");
//		system.register("Patient","Nishant Coder", new char[]{'s','e','c','u','r','e','P','W'}, new char[]{'s','e','c','u','r','e','P','W'}, "1001","pain", "nishant@email.com", "555-5511");
//              
                
		
		
		
		
		//login(member type, emailId, password)
		//System.out.println(system.login("Doctor", "docj@doctor.com", "docPassword"));
		//System.out.println(system.login("Patient", "docj@doctor.com", "docPassword"));
		//System.out.println(system.login("Patient", "jimi@jimiaguirre.com", "securePW"));
                
                for(int i=0;i<50;i++)
                    System.out.println();
                
                
                String password = "1";
                char[] pw = password.toCharArray();
                String email = "1";
                
                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "1001", "1", email, "123"));
                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "1003", "1", "1", "123"));
                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "1002", "1", "12", "1234"));
                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "1001", "1", "123", "12345"));
                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "1002", "1", "1234", "12346"));
                
                
//		System.out.println(system.login("Patient", email, pw)[0]);
//                System.out.println(system.login("Patient", "12", pw)[0]);
//                System.out.println(system.login("Patient", "1234", pw)[0]);
		
		System.out.println(system.updatePatientStatus(1006, new int[]{2,4,1,6,7}));
		System.out.println(system.updatePatientStatus(1006, new int[]{5,7,10,9,1}));
		System.out.println(system.updatePatientStatus(1006, new int[]{8,9,10,9,9}));
                System.out.println(system.updatePatientStatus(1006, new int[]{2,4,1,6,7}));
                System.out.println(system.updatePatientStatus(1006, new int[]{5,7,10,9,1}));
                System.out.println(system.updatePatientStatus(1006, new int[]{8,9,10,9,9}));
                
                System.out.println(system.printKeys());
                
                
		
                
		
		//populate a list of 10 RANDOM health conditions to simulate past medical condition update submissions
		//Random data to be used in std. dev. calculations		
//		ArrayList<int[]> pHistory = new ArrayList<int[]>();
//                
		for (int historyIndex = 0; historyIndex < 10; historyIndex++)
		{
			for(int conditionIndex = 0; conditionIndex < curCon.length; conditionIndex++){
				curCon[conditionIndex] = generator.nextInt(10 - 1 + 1) + 1;}
			System.out.println(system.updatePatientStatus(1006,Arrays.copyOf(curCon, curCon.length)));
                        System.out.println(system.updatePatientStatus(1008,Arrays.copyOf(curCon, curCon.length)));
                        System.out.println(system.updatePatientStatus(1010,Arrays.copyOf(curCon, curCon.length)));
		}	
                
                
		System.out.println(system.printKeys());
                
//		System.out.println();
                
                
		
//		String emailCheck = "jimi@jimiaguirre.com";
//		String memberType = "Patient";
//		System.out.format("Email[%s]: Unique Email ID: [%s]%n%n", emailCheck, system.isUniqueEmailId(memberType, emailCheck));
//		
//		emailCheck = "docBishop@fringe.com";
//		memberType = "Doctor";		
//		System.out.format("Email[%s]: Unique Email ID: [%s]%n%n", emailCheck, system.isUniqueEmailId(memberType, emailCheck));
//		
//		emailCheck = "newAddy@unique.com";
//		memberType = "Patient";
//		System.out.format("Email[%s]: Unique Email ID: [%s]%n%n", emailCheck, system.isUniqueEmailId(memberType, emailCheck));
//		
//		emailCheck = "newDoc@uniqueID.com";
//		memberType = "Doctor";		
//		System.out.format("Email[%s]: Unique Email ID: [%s]%n%n", emailCheck, system.isUniqueEmailId(memberType, emailCheck));
		
		
		
		
		//GUI STUFF***********************************************************//
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        InitialMenu systemMenu = new InitialMenu(system);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                systemMenu.setVisible(true);
            }
        });
		
		
	
		
		
		//GUI STUFF***********************************************************//
		
		
		
		
		//System.out.println(system.patientDetails(1002));
		
		
		
		//utilize overloaded constructor to create Member objects.
		//HealthserviceProvider doctor = new HealthserviceProvider("Doctor J", "docj@doctor.com", "docPassword", "(555) 555-1512", referenceNumberGenerator++, "Cardiology");		
		
		
		//create an ArrayList to hold multiple hashmap values
		//ArrayList<Object> vals = new ArrayList<Object>();				
		//create test patient to add to hashtable
		//Patient p = new Patient("Jimi Aguirre", "Doctor J", "jimi@jimiaguirre.com", "patientPassword", "(555) 555-1212", "Heart Surgery", referenceNumberGenerator++);
		
		//add email to the ArrayList, vals, in index[0]
		//vals.add(new String("jimi@jimiaguirre.com"));
		
		//add the patient object into the the ArrayList in index[1]
		//vals.add(p);
		
		//Add to hashmap 
		//ref. # is the key
		//ArrayList, vals, is the value		
	//	patientList.put(referenceNumberGenerator, vals);
		
		
		//test PW auth.
		//System.out.println(p.authenticate("patientPassword")+"\n");
		
		//test hash email lookup
		//search for email. if found, display ref. #
//		for(Integer key: patientList.keySet())
//		{
//			if(patientList.get(key).get(0).equals("jimi@jimiaguirre.com"))
//				System.out.println(patientList.get(key).get(0)+" --> " + key + "\n");
//		}
		
		
		//test login method
		//login("jimi@jimiaguirre.com", "patientPassword");
		
		
		
		
		//utilize overloaded toString to display member details
		//System.out.format("%s%s",doctor,p);
		
		//populate a list of 10 RANDOM health conditions to simulate past medical condition update submissions
		//Random data to be used in std. dev. calculations		
//		ArrayList<int[]> pHistory = new ArrayList<int[]>();		
//		for (int historyIndex = 0; historyIndex < 10; historyIndex++)
//		{
//			for(int conditionIndex = 0; conditionIndex < curCon.length; conditionIndex++)
//				curCon[conditionIndex] = generator.nextInt(((10 - 0) + 1) - 0);
//			p.setCurrentCondition(Arrays.copyOf(curCon, curCon.length));						
//		}						
		
		//verify list contains 10 random data entries
//		pHistory = p.getConditionHistory();
//		System.out.format("Condition History Size: %s%n", pHistory.size());//verify size
//			
//		//print each element of each ArrayList Entry
//		for (int historyIndex = 0; historyIndex < pHistory.size(); historyIndex++)
//		{
//			System.out.format("History [%s]: {", historyIndex+1);
//			for(int conditionIndex = 0; conditionIndex < pHistory.get(historyIndex).length; conditionIndex++)
//				System.out.format("%s, ", pHistory.get(historyIndex)[conditionIndex]);
//			System.out.format("}%n");
//		}
				
		
		//doctor updates patient thresh values
		//doctor.updateThreshold(p, new int[]{5,4,7,3,7});		
		
		//evaluate patient given data
		//p.setCurrentCondition(new int[]{5,2,10,4,6});//can use this known current condition to test std. deviation calculation
		
		//store results of evaluation
//		int[] data = evaluate(p);
		
		
		//display most recent data, the results in eval, an std. dev.
//		System.out.format("Current Condition:%15s","");		
//		for(int i = 0; i < curCon.length; i++)
//			System.out.format("%d, ",curCon[i]);
//		
//		
//		System.out.format("%nAssessment Evaluation Threshold:%1s","");		
//		for(int i = 0; i < p.getAssessmentEvaluationThreshold().length; i++)
//			System.out.format("%d, ",p.getAssessmentEvaluationThreshold()[i]);
//		
//		System.out.format("%nEvaluation Results:%14s","");		
//		for(int i = 0; i < data.length; i++)
//			System.out.format("%s, ",data[i]);
//		System.out.println();
				
		
		
		
		
//		while(flag!=1){
//			System.out.println("\n\nPlease choose the option");
//			System.out.println("\t 1.Register new patient");
//			System.out.println("\t 2.Register new doctor");
//			System.out.println("\t 3.Get details of patient");
//			System.out.println("\t 4.Exit");
//			String option;
//			
//			option = scanIn.nextLine();
//			int opt = Integer.parseInt(option.trim());
//			switch(opt){
//				case 1: registerPatient();
//						break;
//				case 2: registerDoctor();
//						break;
//				case 3: displayDetailsOfPatient();
//						break;
//				case 4: System.out.println("Have a nice day");
//						System.exit(0);
//						break;
//				case 5:
//					getPatientData();
//					
//			}
//		}
//		scanIn.close(); 
	}

}
