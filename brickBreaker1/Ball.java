package jrJava.brickBreaker1;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Ball {
	
	private int x=300, y=500;
	private int vx=4, vy=-5;
	private int radius=10;
	private Color color=Color.red;
	int time = 0;
	
	private Wall wall;
	private Deflector deflector;
	
	public Ball(){ }
	
	public int getY(){return y;}
	
	public void setWall(Wall _wall){
		wall = _wall;
	}
	public void setDeflector(Deflector _deflector){
		deflector = _deflector;
	}
	
	public void move(){
		x = x + vx;
		y = y + vy;
		
		//Check collision with wall.
		if(x<=wall.getLeft()+radius){
			vx = -vx;
			color = Color.green;
		}
		if(x>= wall.getRight()-radius){
			vx = -vx;
			color = Color.cyan;
		}
		if(y<=wall.getTop()+radius /*|| y>=wall.getBottom()-radius*/){
			vy = -vy;
			color = Color.blue;
		}
		
		//Check collision with deflector.
		if(x>=deflector.getX()-radius &&
			x<=deflector.getX()+deflector.getWidth()+radius &&
			y>=deflector.getY()-radius &&
			y<=deflector.getY()+deflector.getHeight()){
			
			vy=-vy;
			color = Color.red;
			y = deflector.getY() - radius;
		}
	
	}
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillOval(x-radius,y-radius,2*radius,2*radius);
	}

}
