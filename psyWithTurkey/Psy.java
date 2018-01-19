package jrJava.psyWithTurkey;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;
import resources.Timer;

public class Psy {

	private DrawingBoard board;
	private Timer timer;
	
	private Image psyLeftUp, psyRightUp, psyStand;
	private Image turkeyLeftUp, turkeyRightUp, turkeyStand;
	private Image leftUp,rightUp, stand;
	
	private int upTime,standTime;
	
	private int width, height;
	private int x, y;
	
	
	public Psy(DrawingBoard _board, Timer _timer){
		board = _board;
		timer = _timer;
		
		psyLeftUp = new ImageIcon(DiskJockey.RECOURSE_PATH + "psy_left_up.png").getImage();
		psyRightUp = new ImageIcon(DiskJockey.RECOURSE_PATH + "psy_right_up.png").getImage();
		psyStand = new ImageIcon(DiskJockey.RECOURSE_PATH + "psy_stand.png").getImage();
		
		turkeyLeftUp = new ImageIcon(DiskJockey.RECOURSE_PATH + "turkey_left_up.png").getImage();
		turkeyRightUp = new ImageIcon(DiskJockey.RECOURSE_PATH + "turkey_right_up.png").getImage();
		turkeyStand = new ImageIcon(DiskJockey.RECOURSE_PATH + "turkey_stand.png").getImage();
		
		leftUp = psyLeftUp;
		rightUp = psyRightUp;
		stand = psyStand;
		
		x = 470;
		y = 300;
		
		width = leftUp.getWidth(null);
		height = leftUp.getHeight(null);
		
		upTime = 250;
		standTime = 200;
	}
	
	
	public void hop(){
		draw(leftUp, upTime);
		draw(stand, standTime);
		draw(rightUp, upTime);
		draw(stand, standTime);
		
	}
	
	public void draw(Image image, int pause){
		Graphics2D canvas = board.getCanvas();
		
		board.clear();
		canvas.drawImage(image, x-width/2, y-height/2, board);
		board.repaint();
		timer.pause(pause);
	}
}
