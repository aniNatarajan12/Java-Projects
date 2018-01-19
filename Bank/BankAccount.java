package jrJava.Bank;

import resources.Timer;

public class BankAccount {
	
	private Timer timer = new Timer();
	private double balance = 2000.00;
	
	public double getBalance() {return balance;}
	
	public boolean widthdraw(double requestAmount){
		
		if(requestAmount>balance) return false;
		
		timer.pause(100); //checking around to make sure its legit :D
		
		balance -= requestAmount;
		return true;
		
	}
	
}
