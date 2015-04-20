package edu.asu.se.group5.beans;

import java.util.List;
import java.util.ArrayList;

public abstract class Member 
{
	private int referenceNumber;
	private String name;
	private String phone;
	private String emailId;
	private String outgoing, incoming;
        private ArrayList<String[]> messages = new ArrayList();
        private boolean messageOut , messageIn;
	private char[] password;
	private List<String> history;
	private boolean activeSession = false;
	
	public abstract String register();
	
        public void inbox(String message) 
        {
            this.setMessageIn(message);
            this.messageIn = true;
        }
        
        public void outbox(String message) 
        {
            this.setMessageOut(message);
            this.messageOut = true;
        }
        
        public void setMessageOut(String message){this.outgoing = this.name + ": "+message;}
            
        public void setMessageIn(String response){this.incoming = response;}
        
        public void logMessage(String message){this.messages.add(new String[] {message, ""});}
        public void logResponse(String message){this.messages.add(new String[] {message, ""});}
        
        public String getInbox()
        {
            String msg = this.incoming;
            this.messageIn = false;
            return msg;
        }
        public String getOutbox()
        {
            String msg = this.outgoing;
            this.messageOut = false;
            return msg;    
        }
        
        public boolean hasOutgoing(){return this.messageOut;}
        public boolean hasIncoming(){return this.messageIn;}
                
        
        public ArrayList<String[]> getMessageLog() {return this.messages;}
        
        public String printMessageLog()
        {
            return"";
        }
        
        
       
	
	
	public Member(String name, String email, char[] password, String phone, int referenceNumber)
	{
		this.name = name;
		this.emailId = email;
		this.password = password;
		this.phone = phone;
		this.referenceNumber = referenceNumber;
	}
	
	
	
	public boolean authenticate(char[] input)
	{
		boolean valid = true;
		boolean active = true;
				
		char[] t = input;	
		
		if(this.password.length == input.length)
                {
                    while(valid && active)
                    {
                            for(int index = 0; index < this.password.length; index++)
                            {
                                    if(this.password[index] != input[index])
                                    {
                                            valid = false;					
                                            break;
                                    }
                            //System.out.format("%s, %s --> %b%n", this.password[index], input.charAt(index), valid);
                            }
                            active = false;
                    }
                }
                else
                    valid = false;
		
		if(valid) {logIn();}
		
		return valid;
	}
	
	public int getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public boolean isActiveSession() {
		return activeSession;
	}
	public void setActiveSession(boolean activeSession) {
		this.activeSession = activeSession;
	}
	private void logIn(){ this.activeSession = true;}
	public void logOff(){ this.activeSession = false;}
	
        protected boolean isActive()
	{
		boolean sessionActive = false;
		if(this.activeSession)
			sessionActive = true;
		
		return sessionActive;
	}
	
	
	public void setPassword(String password) 
	{	
		this.password = password.toCharArray();
	}
	public List<String> getHistory() {
		return history;
	}
	public void setHistory(List<String> history) {
		this.history = history;
	}
        
        public String toString(int[] value, String[] category)
        {
            String result = "";
            
            for (int index = 0; index < category.length; index++)
                result += String.format("|%-15s%15d|%n", category[index], value[index]);
           
            return result;
                
        }
        
        
	
	public String toString()
	{								
		return String.format("%s, %s%n%n", this.name, this.emailId);
	}
	
	
		
}
