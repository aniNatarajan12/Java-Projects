package jrJava.networkPingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import resources.DrawingBoard;
import resources.Timer;


public class Pingpong {

	public static final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
	private static boolean isServer = true;

	private static String IPAddress = "192.168.1.12";
	private static int portNumber = 5454;
	
	private static InputStream is; 
	private static OutputStream os;
	
	private static void connect(){
		try{
			if(isServer){
				ServerSocket ss = new ServerSocket(portNumber);
				Socket s = ss.accept();
				is = s.getInputStream();
				os = s.getOutputStream();
			}
			else {
				Socket s = new Socket(IPAddress, portNumber);
				is = s.getInputStream();
				os = s.getOutputStream();
			}
		}
		catch(Exception e){
			System.out.println("Network connection failed.");
		}
	}
	

	public static void main(String[] args) throws Exception {

		System.out.println("Are you a Client(c) or Server(s)?");
		char mode = (char) System.in.read();
		if(mode=='c') isServer = false;

		Timer timer = new Timer();
		DrawingBoard board = new DrawingBoard(SCREEN_WIDTH, SCREEN_HEIGHT);
		Graphics2D canvas = board.getCanvas();
		
		Ball ball = new Ball();
		Deflector cDeflector = new Deflector(0, 0, Color.red);
		Deflector sDeflector = new Deflector(SCREEN_WIDTH-Deflector.WIDTH, 0, Color.blue);
		ball.setDeflectors(cDeflector, sDeflector);
		
		if(isServer){
			board.addMouseListener(sDeflector);
			board.addMouseMotionListener(sDeflector);
		}
		else {
			board.addMouseListener(cDeflector);
			board.addMouseMotionListener(cDeflector);
		}

		connect();

		MessageReceiver mR = new MessageReceiver(is);
		MessageSender mS = new MessageSender(os);
		Thread recieverThread = new Thread();		
		recieverThread.start();
		
		if(isServer){
			sDeflector.setMessageSender(mS);
			mR.setDeflector(cDeflector);
		}
		else{
			cDeflector.setMessageSender(mS);
			mR.setDeflector(sDeflector);
		}
		
		long interval = 30;
		long nextUpdateTime = System.currentTimeMillis() + interval;
		
		while(true){
			board.clear();
			ball.move();

			canvas.setColor(Color.black);
			canvas.drawLine(0, SCREEN_HEIGHT/2, SCREEN_WIDTH, SCREEN_HEIGHT/2);
			canvas.drawLine(SCREEN_WIDTH/2, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT);

			ball.draw(board);
			cDeflector.draw(board);
			sDeflector.draw(board);

			board.repaint();
			
			long currentTime = System.currentTimeMillis();
			if(currentTime<nextUpdateTime){
				timer.pause((int)(nextUpdateTime-currentTime));
			}
			nextUpdateTime += interval;
		}


	}


}







