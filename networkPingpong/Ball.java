package jrJava.networkPingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import resources.DrawingBoard;

public class Ball {

	private int x = 100, y = 200;
	private int vx = 10, vy = 4;
	private int radius = 20;
	private Color color = Color.green;
	private Deflector cDeflector, sDeflector;
	
	
	public Ball(){ }
	
	
	public void setDeflectors(Deflector _cDeflector, Deflector _sDeflector){
		cDeflector = _cDeflector;
		sDeflector = _sDeflector;
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
	
	public void move(){
		x += vx;
		y += vy;
		
		if(y<0+radius){
			y = 0+radius;
			vy = -vy;
		}
		else if(y>Pingpong.SCREEN_HEIGHT-radius){
			y = Pingpong.SCREEN_HEIGHT-radius;
			vy = -vy;
		}
		
		// collision with client deflector
		if(x>cDeflector.getX() &&
		   x<cDeflector.getX()+Deflector.WIDTH+radius &&
		   y>cDeflector.getY()-radius &&
		   y<cDeflector.getY()+Deflector.HEIGHT+radius){
			
			x = cDeflector.getX()+Deflector.WIDTH+radius;
			vx = -vx;
		}
		// collision with server deflector
		else if(x>sDeflector.getX()-radius &&
				x<sDeflector.getX()+Deflector.WIDTH &&
				y>sDeflector.getY()-radius &&
				y<sDeflector.getY()+Deflector.HEIGHT+radius){
			
			x = sDeflector.getX()-radius;
			vx = -vx;
		}
				
	}
	
}















