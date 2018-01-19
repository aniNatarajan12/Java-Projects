package jrJava.Bank;

public class Customer {
	
	public static void main(String[] args){
		
		BankAccount account = new BankAccount();
		ATM atm = new ATM();
		atm.setBankAccount(account);
		
		Thread t1 = new Thread(atm);
		Thread t2 = new Thread(atm);
		Thread t3 = new Thread(atm);
		Thread t4 = new Thread(atm);
		Thread t5 = new Thread(atm);
		
		t1.run();
		t2.run();
		t3.run();
		t4.run();
		t5.run();
		
	}

}
