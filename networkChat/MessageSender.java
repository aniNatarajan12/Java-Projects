package jrJava.networkChat;

import java.io.*;


public class MessageSender {

	private OutputStream os;


	public MessageSender(OutputStream _os){
		os = _os;
	}


	public void send(){

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);

		try{
			while(true){
				pw.println(br.readLine());
				pw.flush();
			}
		}
		catch(IOException ioe){
			System.out.println("Error during message sending.");
		}

	}

}









