package jrJava.networkChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static int portNumber = 5454;
	private static InputStream is;
	private static OutputStream os;

	public static void connect(){
		try{
			ServerSocket ss = new ServerSocket(portNumber);
			Socket s = ss.accept();
			is = s.getInputStream();
			os = s.getOutputStream();
		}
		catch(Exception e){
			e.printStackTrace();
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






