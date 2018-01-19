package jrJava.blinkingBalls;

import java.awt.Color;
import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(800, 600);
		Timer timer = new Timer();

		Ball ballA = new Ball(Color.red, 200, 250, 80, 5, 4);
		Ball ballB = new Ball(Color.blue, 550, 350, 60, -6, 3);
		
		ballA.setTheOtherBall(ballB);
		ballB.setTheOtherBall(ballA);
		
		Wall wall = new Wall();
		
		ballA.setWall(wall);
		ballB.setWall(wall);
		
		
		for(int i=0; i<10000; i++){
			board.clear();
			
			ballA.move();
			ballB.move();
			
			ballA.draw(board);
			ballB.draw(board);
			
			wall.draw(board);
			
			board.repaint();
			timer.pause(20);
		}

	}

}
