package jrJava.networkChat;

import java.io.*;
import java.net.Socket;

public class Client {

	private static int portNumber = 5454;
	private static String IPAddress = "";
	private static InputStream is;
	private static OutputStream os;

	public static void connect(){
		try{
			Socket s = new Socket(IPAddress, portNumber);
			is = s.getInputStream();
			os = s.getOutputStream();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		connect();

		MessageReceiver receiver = new MessageReceiver(is);
		MessageSender sender = new MessageSender(os);
		
		Thread thread = new Thread(receiver);
		thread.start();
		
		sender.send();
	}
}





