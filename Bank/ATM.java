package jrJava.Bank;

public class ATM implements Runnable{
	
	private BankAccount account;
	
	public void setBankAccount(BankAccount _account){
		account = _account;
	}
	
	public void widthdrawAll(){
		double currentBalance = account.getBalance();
		boolean shouldDispense = account.widthdraw(currentBalance);
		
		if(shouldDispense){
			//gives the money
			System.out.println("Take the cash below, $" + currentBalance);
		}
		else{
			System.out.println("Sorry, could not proccess your request.");
		}
	}
	
	public void run(){
		widthdrawAll();
	}

}
