package edu.asu.se.group5.beans;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import edu.asu.se.group5.business.HealthCareManagementSystem;
import edu.asu.se.group5.util.Util;
import gui.InitialMenu;

public class test 
{

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
            
		int flag = 0;
		
		int[] curCon = new int[5];
		int[] thresh = {0,0,0,0,0};				
		Random generator = new Random();
		
		HealthCareManagementSystem system = new HealthCareManagementSystem("Eddie Cares");
		System.out.format("System Name: %s%n%n", system.getFacilityName());
		
		//Adding some patients to the start
		
		 
		ArrayList<String[]> logins = new ArrayList();
        
		system.register("Doctor", "Walter Bishop",new char[]{'1'},new char[]{'1'},"Neuro Surgeon", "0","1", "(555) 555-1512");
        
//		system.register("Doctor", "Bishop, Walter",new char[]{'i','m','N','o','t','C','r','a','z','y'},new char[]{'i','m','N','o','t','C','r','a','z','y'},"Neuro Surgeon", "0","docBishop@fringe.com", "(555) 555-1512");
        system.register("Doctor", "Henry Jekyll", new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, "Plastic Surgeon","0","biPolar@ontheedge.com", "(555) 531-3357");
        system.register("Doctor", "Doctor Dre", new char[]{'g','i','n','N','J','u','i','c','e'}, new char[]{'g','i','n','N','J','u','i','c','e'}, "Orthopedics","0", "dreDay@beats.com", "(234) 333-9382");
        system.register("Doctor", "Hannibal Lecter", new char[]{'f','a','c','e','S','t','e','a','k','!'}, new char[]{'f','a','c','e','S','t','e','a','k','!'}, "Cardiology","6", "hungry@humans.com", "(223) 543-0929");
        system.register("Doctor", "Doctor Evil", new char[]{'m','i','n','i','m','e'}, new char[]{'m','i','n','i','m','e'}, "Surgeon","0","evil@doctor.com", "(325) 943-1264");
        
        String password = "1";
        
        //String[] jimiLogin = {"jimi@jimiaguirre.com", "jimiPassword"};
        String[] jimiLogin = {"1", "1"};
        String[] savannahLogin = {"savannah@email.com", "savannahPassword"};
        String[] edisonLogin = {"edison@wolfpack.com", "wolfpackPassword"};
        String[] nishantLogin = {"nishant@email.com", "nishantPassword"};
        String[] deepakLogin = {"pak@pak.com", "deepakPassword"};
        
        logins.add(jimiLogin);
        logins.add(savannahLogin);
        logins.add(edisonLogin);
        logins.add(nishantLogin);
        logins.add(deepakLogin);
        
        String[] firstNames = {"John", "Jim", "Tom", "Edward", "Walter", "Eddie", "Josh", "Craig", "Alex", "Timothy", "Deepak", "Nishant", "Jimi", "Jill", "Stephanie", "Susan", "Natalie", "Nicole", "Savannah", "Milla", "Megan", "Joanne", "Breanne", "Gertrude" , "Mona", "Gaylord", "Bart", "Lisa", "Maggie", "Homer"};
        String[] lastNames = {"Daniels","Smith", "Adams", "Parameshawaran", "Kumar", "Puckett", "Cooper", "Schweitzer", "Chae", "Burger", "Martinez", "Aguirre", "Jovovich", "Fox", "Portman", "Sanchez", "Flanders", "Simpson", "Focker", "Norton", "Sandler"};
        int[] doctorRefNumbers = {1001,1002,1003,1004,1005};
        
        String firstName, lastName, phone, doctor, uCondition, email, result;
        
        
        
        char[] pw = password.toCharArray();
        
        for(int i = 0; i < 50; i++)
        {
            firstName = firstNames[generator.nextInt(firstNames.length)];
            lastName = lastNames[generator.nextInt(lastNames.length)];
            pw = (firstName + "Password").toCharArray();
            email = firstName.charAt(0) + lastName + "@email.com";
            
            phone = "(";
            phone += String.valueOf(generator.nextInt(999 - 201 + 1) + 201);
            phone +=") ";
            phone += String.valueOf(generator.nextInt(999 - 201 + 1) + 201);
            phone += "-";
            phone += String.format("%02d", generator.nextInt(9999 - 1 + 1) + 1);
            
            doctor = String.valueOf(generator.nextInt(5)+1);
            uCondition = String.valueOf(generator.nextInt(5)+1);
            result = (system.register("Patient", firstName+" "+lastName, pw, pw, doctor, uCondition, email, phone));
            
            if(result.equalsIgnoreCase("Registration Complete!"))
                logins.add(new String[] {email, firstName + "Password"});
            
            
                   
            }
            
            
        
        
        
        String [] memberLogins[] = {jimiLogin, savannahLogin, edisonLogin, nishantLogin, deepakLogin};
                
        
        email = "1";
        
        
        
        
        System.out.println(system.register("Patient", "Jimi Aguirre", memberLogins[0][1].toCharArray(), memberLogins[0][1].toCharArray(), "1", "1", memberLogins[0][0], "123"));
        System.out.println(system.register("Patient", "Savannah Pucket", memberLogins[1][1].toCharArray(), memberLogins[1][1].toCharArray(), "1", "1", memberLogins[1][0], "123"));
        System.out.println(system.register("Patient", "Edison Schweitzer", memberLogins[2][1].toCharArray(), memberLogins[2][1].toCharArray(), "1", "1", memberLogins[2][0], "1234"));
        System.out.println(system.register("Patient", "Nishant Kumar", memberLogins[3][1].toCharArray(), memberLogins[3][1].toCharArray(), "1", "1", memberLogins[3][0], "12345"));
        System.out.println(system.register("Patient", "Deepak Parameshawaran", memberLogins[4][1].toCharArray(), memberLogins[4][1].toCharArray(), "1", "1", memberLogins[4][0], "12346"));
        
        
System.out.println(system.login("Patient", jimiLogin[0], jimiLogin[1].toCharArray()));
System.out.println(system.updatePatientStatus(1006, new int[]{2,4,1,6,7}));
        System.out.println(system.login("Patient", email, pw));
System.out.println(system.updatePatientStatus(1006, new int[]{5,7,10,9,1}));
        System.out.println(system.login("Patient", email, pw));
System.out.println(system.updatePatientStatus(1006, new int[]{8,9,10,9,9}));
        System.out.println(system.login("Patient", email, pw));
        System.out.println(system.updatePatientStatus(1006, new int[]{2,4,1,6,7}));
        System.out.println(system.login("Patient", email, pw));
        System.out.println(system.updatePatientStatus(1006, new int[]{5,7,10,9,1}));
        System.out.println(system.login("Patient", email, pw));
        System.out.println(system.updatePatientStatus(1006, new int[]{8,9,10,9,9}));
        
        System.out.println(system.printKeys());
        
        

        

//populate a list of 10 RANDOM health conditions to simulate past medical condition update submissions
//Random data to be used in std. dev. calculations		
//
//        
for(int memberIndex = 0; memberIndex < logins.size(); memberIndex++)
        {
            for (int historyIndex = 0; historyIndex < 10; historyIndex++)
            {
                for(int conditionIndex = 0; conditionIndex < curCon.length; conditionIndex++){
                        curCon[conditionIndex] = generator.nextInt(10 - 1 + 1) + 1;}
                System.out.println(system.login("Patient", logins.get(memberIndex)[0], logins.get(memberIndex)[1].toCharArray())); 
                System.out.println(system.updatePatientStatus(system.emailToReferenceNumber("Patient", logins.get(memberIndex)[0]), Arrays.copyOf(curCon, curCon.length)));
            }
        }       
		
		
		
		
		//login(member type, emailId, password)
		//System.out.println(system.login("Doctor", "docj@doctor.com", "docPassword"));
		//System.out.println(system.login("Patient", "docj@doctor.com", "docPassword"));
		//System.out.println(system.login("Patient", "jimi@jimiaguirre.com", "securePW"));
                
		 
		
		
                for(int i=0;i<50;i++)
                    System.out.println();
                
                /************************************************************************
                 * code block commented for database persistence
                 *
                 *
                 *
                Util util = new Util(); 
                
                HashMap<Integer,ArrayList<Object>> doctorList = util.loadDoctors();
                system.setDoctorList(doctorList);
                Set<Integer> doc_ref = doctorList.keySet();
                Iterator<Integer> doc_it = doc_ref.iterator();
                while(doc_it.hasNext()){
                	ArrayList add = doctorList.get(doc_it.next());
                	System.out.println("add get 1 is " + add.get(1));
                	HealthserviceProvider h1 = (HealthserviceProvider) add.get(1);
                	//System.out.println("name of doc is " + h1.getName() + " and ref number is  + " h1.getReferenceNumber());
                	ArrayList<String[]> doctors = system.getDoctors();
                	doctors.add(new String[]{h1.getName(),String.valueOf(h1.getReferenceNumber())});
                	system.setDoctors(doctors);
                }
                
               // System.out.println("doctor 1 name is " + system.doctors.get(1)[0]);
               // System.out.println("doctor 2 name is " + system.doctors.get(2)[0]);
                
                if(doctorList == null){
                
                system.setDoctorList(new HashMap<Integer, ArrayList<Object>>());
                system.register("Doctor", "Walter Bishop",new char[]{'1'},new char[]{'1'},"Neuro Surgeon", "0","1", "(555) 555-1512");
                
//        		system.register("Doctor", "Bishop, Walter",new char[]{'i','m','N','o','t','C','r','a','z','y'},new char[]{'i','m','N','o','t','C','r','a','z','y'},"Neuro Surgeon", "0","docBishop@fringe.com", "(555) 555-1512");
                system.register("Doctor", "Henry Jekyll", new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, new char[]{'i','m','f','i','n','e','i','m','n','o','t'}, "Plastic Surgeon","0","biPolar@ontheedge.com", "(555) 531-3357");
                system.register("Doctor", "Doctor Dre", new char[]{'g','i','n','N','J','u','i','c','e'}, new char[]{'g','i','n','N','J','u','i','c','e'}, "Orthopedics","0", "dreDay@beats.com", "(234) 333-9382");
                system.register("Doctor", "Hannibal Lecter", new char[]{'f','a','c','e','S','t','e','a','k','!'}, new char[]{'f','a','c','e','S','t','e','a','k','!'}, "Cardiology","6", "hungry@humans.com", "(223) 543-0929");
                system.register("Doctor", "Doctor Evil", new char[]{'m','i','n','i','m','e'}, new char[]{'m','i','n','i','m','e'}, "Surgeon","0","evil@doctor.com", "(325) 943-1264");
            //}
                
                
                /************************************************************************
                 * code block commented for database persistence
                 *
                 *
		            HashMap<Integer,ArrayList<Object>> patList = util.loadPatients();
		            system.setPatientList(patList);
		            system.setPatients(patList.size());
		            system.setPatientKeys(util.getPatientIds());
		            if(patList == null){
		                HashMap<Integer,ArrayList<Object>> patList1 = new HashMap<Integer,ArrayList<Object>>();
		            	system.setPatientList(patList1);
		                String password = "1";
		                char[] pw = password.toCharArray();
		                String email = "1";
		                
		                System.out.println("Jimi :" + system.register("Patient", "Jimi Aguirre", pw, pw, "1", "1", email, "123"));
		                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "4", "1", "1", "123"));
		                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "2", "1", "12", "1234"));
		                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "3", "1", "123", "12345"));
		                System.out.println(system.register("Patient", "Jimi Aguirre", pw, pw, "5", "1", "1234", "12346"));
		                
		                System.out.println(system.updatePatientStatus(1006, new int[]{2,4,1,6,7}));
		        		System.out.println(system.updatePatientStatus(1006, new int[]{5,7,10,9,1}));
		        		System.out.println(system.updatePatientStatus(1006, new int[]{8,9,10,9,9}));
		                System.out.println(system.updatePatientStatus(1006, new int[]{2,4,1,6,7}));
		                System.out.println(system.updatePatientStatus(1006, new int[]{5,7,10,9,1}));
		                System.out.println(system.updatePatientStatus(1006, new int[]{8,9,10,9,9}));
		                /************************************************************************
		                 * code block commented for database persistence
		                 *
		                 *
		                  }else{
	                	system.setWriteToDatabase(1);
	                	Set patientIds = system.getPatientList().keySet();
	                	Iterator ids = patientIds.iterator();
	                	
	                	while(ids.hasNext()){
	                		int id = (int)ids.next();
	                		Patient p1 = (Patient) system.getPatientList().get(id).get(1);
	                		System.out.println("patient name is " + p1.getName());
	                		List<HealthCondition> hlist = util.getLastKHealthStatusUpdates(id);
	                		
	                		Iterator<HealthCondition> condition = hlist.iterator();
	                		ArrayList<int[]> conditionHistory = new ArrayList<int[]>();
	                		while(condition.hasNext()){
	                			HealthCondition h1 = condition.next();
	                			int[] cond = new int[5];
	                			cond[0] = h1.getPain();
	                			cond[1] = h1.getAnxiety();
	                			cond[2] = h1.getDepression();
	                			cond[3] = h1.getNausea();
	                			System.out.println("for patient " + id + "there are " + hlist.size() +" medical updates in database");
	                			cond[4] = h1.getDrowsiness();
	                			system.setWriteToDatabase(1);
	                			system.updatePatientStatus(id, cond);
	                			conditionHistory.add(cond);
	                		}
	                		p1.setPatientHistory(conditionHistory);
	                	}
	                	system.setWriteToDatabase(0);
	                } */
                
                
                
//		System.out.println(system.login("Patient", email, pw)[0]);
//                System.out.println(system.login("Patient", "12", pw)[0]);
//                System.out.println(system.login("Patient", "1234", pw)[0]);
		
		        
		
                
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
