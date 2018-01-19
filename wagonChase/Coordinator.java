package jrJava.wagonChase;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import resources.DrawingBoard;
import resources.Timer;


public class Coordinator {

	public static final String RESOURCE_PATH = "jrJava/wagonChase/imagesAndSounds/";
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 500;
	public static final int PAUSE_TIME = 30;
	public static final int SCREEN_SPEED = 2;
	public static final int SCREEN_REPEAT_WIDTH = 1600;
	public static boolean gameOver;

	

	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(SCREEN_WIDTH, SCREEN_HEIGHT);
		Timer timer = new Timer();

		board.setBackgroundImage(RESOURCE_PATH + "bg.png");
		Image ground = new ImageIcon(RESOURCE_PATH + "ground2.png").getImage();
		Graphics2D canvas = board.getCanvas();

		Slinger slinger = new Slinger(650, 415);
		board.addMouseListener(slinger);
		board.addMouseMotionListener(slinger);


		int imageX = 0;
		while(!gameOver){
			board.clear();

			canvas.drawImage(ground, imageX, 330, board);
			imageX -= SCREEN_SPEED;
			if(imageX<=-SCREEN_REPEAT_WIDTH) imageX = 0;

			slinger.move();
			slinger.draw(board);

			RobotManager.move();
			RobotManager.draw(board); 
			
			ProjectileManager.move();
			ProjectileManager.draw(board); 
			
			board.repaint();
			timer.pause(PAUSE_TIME);
		}

	}

}