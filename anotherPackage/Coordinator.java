package jrJava.anotherPackage;

import java.awt.Color;
import jrJava.objectPractice3.Ball;
import jrJava.objectPractice3.Wall;

import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class Coordinator {

	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(800,650);
		Timer timer = new Timer();

		Ball ballA = new Ball(400,325,-3,4,"imagesAndSounds/redBall.png");
		Ball ballB = new Ball(400,325,4,-7,"imagesAndSounds/greenBall.png");
		Ball ballC = new Ball(400,325,-6,-3,"imagesAndSounds/yellowBall.png");
		Ball ballD = new Ball(400,325,7,5,"imagesAndSounds/grayBall.png");
		Ball ballE = new Ball(400,325,-5,6,"imagesAndSounds/blueBall.png");
		Ball ballF = new Ball(400,325,5,-6,"imagesAndSounds/purpleBall.png");

		
		Wall wall = new Wall();
		
		ballA.setWall(wall);
		ballB.setWall(wall);
		ballC.setWall(wall);
		ballD.setWall(wall);
		ballE.setWall(wall);
		ballF.setWall(wall);
		
		board.setBackgroundImage("imagesAndSounds/bg4.png");
		
		SoundPlayer bgSound = new SoundPlayer();
		bgSound.load("imagesAndSounds/harryPotter_law.wav");
		bgSound.playLoop();

		for (int i=0; i<100000; i++){
			board.clear();
			ballA.move();
			ballB.move();
			ballC.move();
			ballD.move();
			ballE.move();
			ballF.move();
			
			ballA.draw(board);
			ballB.draw(board);
			ballC.draw(board);
			ballD.draw(board);
			ballE.draw(board);
			ballF.draw(board);
			
			wall.draw(board);
			board.repaint();
			timer.pause(10);
		}
	}

}
