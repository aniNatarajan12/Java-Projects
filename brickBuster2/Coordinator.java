package jrJava.brickBuster2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import resources.DrawingBoard;
import resources.Timer;


public class Coordinator {
	
	public static final int SCREEN_WIDTH = 570;
	public static final int SCREEN_HEIGHT = 720;


	public static int score = 0;


	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(SCREEN_WIDTH, SCREEN_HEIGHT);
		Timer timer = new Timer();
		Graphics2D canvas = board.getCanvas();

		Wall wall = new Wall();
		Deflector deflector = new Deflector(85, 610);
		int deadBalls = 0;

		board.addMouseMotionListener(deflector);
		board.addMouseListener(deflector);
		
		deflector.setWall(wall);
		JFrame frame = board.getJFrame();
		frame.addKeyListener(deflector);

		int[] numOfBricks = new int[]{25, 5, 21, 3, 17, 10, 25, 5, 17, 25};

		BrickManager[] brickManagers = new BrickManager[10];

		for(int i=0; i<brickManagers.length; i++){
			brickManagers[i] = new BrickManager(wall.getLeft()+50*i, wall.getTop(), numOfBricks[i]);
		}

		Ball[] balls = new Ball[10];

		int[] vx = new int[]{3,4,5,6,7,-3,-4,-5,-6,-7};
		int[] vy = new int[]{2,-5,5,-5,3,5,-5,5,-5,3};
		Color[] colors = new Color[]{ Color.red, Color.green, Color.blue, Color.cyan, Color.yellow,
				Color.magenta, Color.pink, Color.orange, Color.gray, Color.black};


		for(int i=0; i<balls.length; i++){
			balls[i] = new Ball( vx[i], vy[i], colors[i]);
			balls[i].setWall(wall);
			balls[i].setDeflector(deflector);
			balls[i].setBrickManagers(brickManagers);
		}
		

		while(true){

			board.clear();
			
			Deflector.time++;
			
			Ball.growAndShrink();

			for(int i=0; i<balls.length; i++){
				balls[i].move();
				balls[i].draw(board);

				if(balls[i].x<=700){
					deadBalls++;
				}
			}

			wall.draw(board);
			deflector.draw(board);

			for(int i=0; i<brickManagers.length; i++){
				brickManagers[i].draw(board);
			}


			board.repaint();
			timer.pause(1);

		}
	}
}
