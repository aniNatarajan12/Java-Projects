package jrJava.wagonChase;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;


public class Projectile {

	private double x, y; // center
	private double vx, vy;
	private boolean hasLanded;
	private boolean toBeRemoved;

	public static final int RADIUS, BURIED_RADIUS;
	public static final int LANDING_POS = 437;
	public static final Image image, buried;
	public static final double GRAVITY = 0.4;

	static{
		image = new ImageIcon(Coordinator.RESOURCE_PATH + "spike_ball1.png").getImage();
		RADIUS = image.getWidth(null)/2;
		buried = new ImageIcon(Coordinator.RESOURCE_PATH + "buried_ball1.png").getImage();
		BURIED_RADIUS = buried.getWidth(null)/2;
	}

	public Projectile(double x, double y, double vx, double vy){
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}


	public double getX(){ return x; }
	public double getY(){ return y; }
	public boolean toBeRemoved(){ return toBeRemoved; }
	
	
	public void move(){

		if(x<0) toBeRemoved = true;

		if(hasLanded){
			x -= Coordinator.SCREEN_SPEED;
		}
		else {
			x += vx;
			y += vy;
			vy += GRAVITY;

			// check the collision with robots.
			if(RobotManager.isHit(this)){
				toBeRemoved = true;
			}

			if(y>=LANDING_POS) hasLanded = true;
		}
	}


	public void draw(DrawingBoard board){
		if(toBeRemoved) return;

		Graphics2D canvas = board.getCanvas();
		if(hasLanded){
			canvas.drawImage(buried, (int)x-BURIED_RADIUS, LANDING_POS, board);
		}
		else {
			canvas.drawImage(image, (int)x-RADIUS, (int)y-RADIUS, board);
		}
	}
}










