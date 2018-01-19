package jrJava.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server{
	
	private static int portNumber = 5454; 
	private static InputStream is;
	private static String line;
	private static ServerSocket ss;
	private static Socket s;
	
	public static void connect() throws IOException {
		ss = new ServerSocket(portNumber);
		
		s = ss.accept();
		is = s.getInputStream();
	}

	public static void main(String[] args) throws IOException {
		connect();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		line = br.readLine();
		System.out.println(line);
		
		br.close();
	}

}
