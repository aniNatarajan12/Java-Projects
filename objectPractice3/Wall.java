package jrJava.objectPractice3;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Wall {
	int left=50;
	int right=750;
	int top=50;
	int bottom=550;
	private Color color=Color.DARK_GRAY;
	private int thickness=10;
	
	public Wall(){ }
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.drawRect(left , top, right-left, bottom);
	}

}
