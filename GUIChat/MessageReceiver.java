package jrJava.GUIChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageReceiver implements Runnable {

	private GUI gui;
	private BufferedReader br;
	
	
	public MessageReceiver(InputStream is){
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
	}
		
	public void setGUI(GUI _gui){ gui = _gui; }
	
	public void run(){
		
		String msg;
		while(true){
			try{
				msg = br.readLine();
				gui.addText(msg);
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}