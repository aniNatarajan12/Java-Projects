package jrJava.GUIChat;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MessageSender {

	private PrintWriter pw;
	
	public MessageSender(OutputStream os){
		OutputStreamWriter osw = new OutputStreamWriter(os);
		pw = new PrintWriter(osw);
	}
	
	public void send(String msg){
		pw.println(msg);
		pw.flush();
	}
	
}