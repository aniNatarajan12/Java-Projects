package jrJava.tetris;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;


public class Wall {

	public static final int LEFT = 100;
	public static final int RIGHT = 500;
	public static final int TOP = 40;
	public static final int BOTTOM = 600;
	
	private static Color wallColor = Color.black;
	private static Color gridColor = Color.gray;
	
	
	public static void draw(DrawingBoard board){
		
		Graphics2D canvas = board.getCanvas();
		
		// draw the grids.
		canvas.setColor(gridColor);
		
		for(int x=LEFT; x<=RIGHT; x+=Block.SIZE){
			canvas.drawLine(x, TOP, x, BOTTOM);
		}
		
		for(int y=TOP; y<=BOTTOM; y+=Block.SIZE){
			canvas.drawLine(LEFT, y, RIGHT, y);
		}
		
		// draw the wall boundary.
		canvas.setColor(wallColor);
		canvas.drawRect(LEFT, TOP, RIGHT-LEFT, BOTTOM-TOP);
		
	}
	
	
	
	public static boolean isOutside(Block block){
		if(block.getX()<LEFT ||
		   block.getX()>=RIGHT ||
		   block.getY()>=BOTTOM){
			return true;
		}
		return false;
	}
	
	
}















