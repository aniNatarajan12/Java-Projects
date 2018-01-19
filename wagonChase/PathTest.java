package jrJava.wagonChase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import resources.DrawingBoard;
import resources.Timer;

public class PathTest {

	
	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(1000, 600);
		Timer timer = new Timer();
		
		Heart myHeart = new Heart(400, 200, 200, Color.black);
		Heart yourHeart = new Heart(700, 200, 500, Color.red);
		
		board.addMouseListener(myHeart);
		board.addMouseMotionListener(myHeart); 
		
		while(true){
			board.clear();
			
			myHeart.draw(board);
			yourHeart.draw(board);
			
			board.repaint();
			timer.pause(40);
		}
	}

}
