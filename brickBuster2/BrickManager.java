package jrJava.brickBuster2;

import java.awt.Color;
import java.util.ArrayList;

import resources.DrawingBoard;


public class BrickManager {

	private ArrayList<Brick> list;
	private int x, y;
	private int brickWidth = 50;
	private int brickHeight = 20;
	
	
	public BrickManager(int _x, int _y, int numOfBricks){
		x = _x;
		y = _y;
		
		list = new ArrayList<Brick>();
		// create all the bricks.
		for(int i=0; i<numOfBricks; i++){
			
			int yPos = y + brickHeight*i;
			
			int red = (int) (Math.random()*256);
			int green = (int) (Math.random()*256);
			int blue = (int) (Math.random()*256);
			Color color = new Color(red, green, blue);
			
			boolean isLast = false;
			if(i==numOfBricks-1) isLast = true;
			
			Brick each = new Brick(x, yPos, brickWidth, brickHeight, color, isLast);
			list.add(each);
		}
		
	}
	
	
	public void draw(DrawingBoard board){
		
		for(int i=0; i<list.size(); i++){
			Brick each = list.get(i);
			each.draw(board);
		}
	}
	
	
	public boolean isHit(Ball ball){
		
		for(int i=0; i<list.size() ; i++){
			Brick each = list.get(i);
			if(each.isHit(ball)){
				list.remove(i);
				updateBrickPositions();
				return true;
			}
		}
		
		return false;
	}
	
	
	
	void updateBrickPositions(){
		for(int i=0; i<list.size(); i++){
			Brick each = list.get(i);
			
			int yPos = y + brickHeight*i;
			
			boolean isLast = false;
			if(i==list.size()-1) isLast = true;
			
			each.updatePosition(x, yPos, isLast);
		}
		
	}
	
}


















