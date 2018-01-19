package jrJava.GUIChat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	private static String IPAddress = "localhost";
	private static int portNumber = 5454;
	
	private static InputStream is; 
	private static OutputStream os;
	
	private static void connect(){
		try{
			Socket s = new Socket(IPAddress, portNumber);
			is = s.getInputStream();
			os = s.getOutputStream();
		}
		catch(Exception e){
			System.out.println("Network connection failed.");
		}
	}
	
	public static void main(String[] args) {
		
		// Create a GUI object.
		GUI gui = new GUI();
		// Make connection.
		connect();
		// using 'is', create MessageReceiver.
		MessageReceiver receiver = new MessageReceiver(is);
		// using 'os', create MessageSender.
		MessageSender sender = new MessageSender(os);
		// set the relationships between objects.
		gui.setMessageSender(sender);
		receiver.setGUI(gui);
		// create and start MessageReceiver thread.
		Thread receiveThread = new Thread(receiver);
		receiveThread.start();
	}
}