//athrvrocks4321@gmail.com
//kevals10@gmail.com

package jrJava.objectPractice;

import java.awt.Color;

import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(800,650);
		Timer timer = new Timer();

		Ball ballA = new Ball(400,400,Color.red,3,4);
		Ball ballB = new Ball(400,400,Color.blue,4,7);
		Ball ballC = new Ball(400,400,Color.green,6,3);
		Ball ballD = new Ball(400,400,Color.magenta,7,5);
		Ball ballE = new Ball(400,400,Color.cyan,5,6);

		
		Wall wall = new Wall();
		
		ballA.setWall(wall);
		ballB.setWall(wall);
		ballC.setWall(wall);
		ballD.setWall(wall);
		ballE.setWall(wall);
		

		for (int i=0; i<10000; i++){
			board.clear();
			ballA.move();
			ballB.move();
			ballC.move();
			ballD.move();
			ballE.move();
			
			ballA.draw(board);
			ballB.draw(board);
			ballC.draw(board);
			ballD.draw(board);
			ballE.draw(board);
			
			wall.draw(board);
			board.repaint();
			timer.pause(10);
		}
	}

}
