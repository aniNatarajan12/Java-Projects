package jrJava.MovingShape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import resources.Timer;

public class Practice4 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		int CornerX=100;
		int CornerY=100;


		DrawingBoard board = new DrawingBoard(820,610);
		Graphics2D canvas = board.getCanvas();

		for(int i=1; i<=50; i++){
			board.clear();
			canvas.setColor(Color.red);
			canvas.fillOval(CornerX, CornerY, 200, 200);
			board.repaint();
			CornerX=CornerX+10;
			timer.pause(20);
		}
		
		for(int i=1; i<=30; i++){
			board.clear();
			canvas.setColor(Color.blue);
			canvas.fillOval(CornerX, CornerY, 200, 200);
			board.repaint();
			CornerY=CornerY+10;
			timer.pause(20);
		}
		
		for(int i=1; i<=50; i++){
			board.clear();
			canvas.setColor(Color.green);
			canvas.fillOval(CornerX, CornerY, 200, 200);
			board.repaint();
			CornerX=CornerX-10;
			timer.pause(20);
		}
		
		for(int i=1; i<=30; i++){
			board.clear();
			canvas.setColor(Color.magenta);
			canvas.fillOval(CornerX, CornerY, 200, 200);
			board.repaint();
			CornerY=CornerY-10;
			timer.pause(20);
		}

	}

}
