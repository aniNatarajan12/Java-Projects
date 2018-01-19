package jrJava.objectPractice;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;

public class Wall {
	int left=50;
	int right=750;
	int top=50;
	int bottom=550;
	Color color=Color.DARK_GRAY;
	int thickness=10;
	
	Wall(){ }
	
	void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.drawRect(left , top, right-left, bottom);
	}

}
