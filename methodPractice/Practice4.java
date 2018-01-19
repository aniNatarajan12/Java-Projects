package jrJava.methodPractice;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import resources.Timer;

public class Practice4 {

	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(800,600);
		Timer timer = new Timer();
		
		int myRadius = 80;
		Color myColor = Color.red;
		move(myColor, myRadius, board, timer, 100, 100, 700, 500);
		move(myColor, myRadius, board, timer, 700, 500, -100, 600);
		move(myColor, myRadius, board, timer, -100, 600, 300, 700);
		move(myColor, myRadius, board, timer, 300, 700, 400, 300);
	}

	private static void move (Color color, int radius, DrawingBoard board, Timer timer, int x1, int y1, int x2, int y2){
		
		Graphics2D canvas = board.getCanvas();
		
		for(int i=0; i<=100; i++){
			
			board.clear();
			
			int x = (int)(x1 + (x2-x1)/100.0*i);
			int y = (int)(y1 + (y2-y1)/100.0*i);
			
			canvas.setColor(color);
			canvas.fillOval(x-radius,y-radius,2*radius,2*radius);
			board.repaint();
			timer.pause(10);
			
		}

	}

}
