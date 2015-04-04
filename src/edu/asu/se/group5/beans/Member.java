package edu.asu.se.group5.beans;

import java.util.List;

public abstract class Member {
	private int referenceNumber;
	private String name;
	private String phone;
	private String emailId;
	//private String password;
	private char[] password;
	private List<String> history;
	private boolean activeSession;
	
	public abstract String register();
	public abstract String sendMessage();
	
	public Member(){this("name", "default@email.com", "defaultPassword", "(000) 000-0000", 0000);}
	
	public Member(String name, String email, String password, String phone, int referenceNumber)
	{
		this.name = name;
		this.emailId = email;
		this.password = password.toCharArray();
		this.phone = phone;
		this.referenceNumber = referenceNumber;
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
	
	public boolean authenticate(String input)
	{
		boolean valid = true;
		boolean active = true;
				
		char[] t = input.toCharArray();					
		while(valid && active)
		{
			for(int index = 0; index < this.password.length; index++)
			{
				if(this.password[index] != input.charAt(index))
				{
					valid = false;					
					break;
				}
			//System.out.format("%s, %s --> %b%n", this.password[index], input.charAt(index), valid);
			}
			active = false;
		}
		
		if(valid) {logIn();}
		
		return valid;
	}
	
	public void logIn(){ this.activeSession = true;}
	public void logOff(){ this.activeSession = false;}
	
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
	
	public String toString()
	{								
		return String.format("--Name: %s%n--Ref. #: %s%n--Email: %s%n--Password: %s%n%n", this.name, this.referenceNumber, this.emailId, this.password);
	}
	
		
}
