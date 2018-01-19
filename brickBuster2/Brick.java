package jrJava.brickBuster2;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;


public class Brick {

	private int x, y; // left, top
	private int width, height;
	private Color color;
	private boolean isLastBrick;
	
	
	public Brick(int _x, int _y, int _width, int _height, Color _color, boolean _isLastBrick){
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		color = _color;
		isLastBrick = _isLastBrick;
	}
	
	
	public void updatePosition(int _x, int _y, boolean _isLastBrick){
		x = _x;
		y = _y;
		isLastBrick = _isLastBrick;
	}
	
	
	public boolean isHit(Ball ball){
		
		if(ball.getX()<x-ball.getRadius() || ball.getX()>x+width+ball.getRadius()) return false;
		
		if(ball.getY()>y && ball.getY()<=y+height){
			
			if(ball.getX()<x+width/2){
				ball.setX( x-ball.getRadius() );
				ball.setVX( -ball.getVX() );
				return true;
			}
			else{
				ball.setX( x+width+ball.getRadius() );
				ball.setVX( -ball.getVX() );
				return true;
			}
		}
		
		
		if(isLastBrick){
			
			if(ball.getY()>=y+height && ball.getY()<=y+height+ball.getRadius()){
				ball.setY(y+height+ball.getRadius());
				ball.setVY( Math.abs( ball.getVY() ) );
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public void draw(DrawingBoard board){
		
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, width, height);
		canvas.setColor(Color.black);
		canvas.drawRect(x, y, width, height);
	}
	
}



























