package jrJava.networkChat;

import java.io.*;

public class MessageReceiver implements Runnable {

	private InputStream is;


	public MessageReceiver(InputStream _is){
		is = _is;
	}

	
	public void run(){
		receive();
	}
	

	public void receive(){

		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		try{
			while(true){
				System.out.println(br.readLine());
			}
		}
		catch(IOException ioe){
			System.out.println("Error during message receiving.");
		}
	}
}
