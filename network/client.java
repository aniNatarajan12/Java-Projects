package jrJava.network;

import java.io.*;
import java.net.Socket;

public class client {
	
	private static String IPAddress = "192.168.1.27";
	private static int portNumber = 5454;
	private static Socket s;
	private static OutputStream os;
	
	public static void connect() throws IOException{
		s = new Socket(IPAddress,portNumber);
		os = s.getOutputStream();
	}

	public static void main(String[] args) throws IOException {
		connect();
		
		OutputStreamWriter osr = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osr);
		pw.println("U R FAT!!!");
		
		pw.flush();
		pw.close();
	}

}
