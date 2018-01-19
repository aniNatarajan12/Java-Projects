package jrJava.networkPingpong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageReceiver implements Runnable {

	private BufferedReader br;
	private Deflector deflector;
	
	public MessageReceiver(InputStream is){
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
	}
		
	
	public void run(){
		
		String msg;
		while(true){
			try{
				msg = br.readLine();
				int y = Integer.parseInt(msg.substring(2));
				deflector.setY(y);
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}


	public void setDeflector(Deflector _deflector) {
		deflector = _deflector;
	}
}