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
	
	public Member(){this("name", "default@email.com", new char[] {0,0,0,0,0,0}, "(000) 000-0000", 0000);}
	
	public Member(String name, String email, char[] password, String phone, int referenceNumber)
	{
		this.name = name;
		this.emailId = email;
		this.password = password;
		this.phone = phone;
		this.referenceNumber = referenceNumber;
	}
	
	public int getReferenceNumber() {
		return referenceNumber;
	}
	private void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private String getPhone() {
		return phone;
	}
	private void setPhone(String phone) {
		this.phone = phone;
	}
	private String getEmailId() {
		return emailId;
	}
	private void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	private char[] getPassword() {
		return password;
	}
	
	public boolean authenticate(char[] input)
	{
		boolean valid = true;
		boolean active = true;
				
		char[] t = input;					
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
		
		if(valid) {logIn();}
		
		return valid;
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
	
	public String toString()
	{								
		return String.format("--Name: %s%n--Ref. #: %s%n--Email: %s%n--Password: %s%n%n", this.name, this.referenceNumber, this.emailId, this.password);
	}
	
	
		
}
