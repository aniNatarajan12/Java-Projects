package jrJava.brickBreaker1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	public static void main(String[] args) {
		
		DrawingBoard board = new DrawingBoard(550,720);
		Graphics2D canvas = board.getCanvas();
		Timer timer = new Timer();
		
		Ball ball = new Ball();
		Wall wall = new Wall();
		Deflector deflector = new Deflector(85,610);     //////
		
		JFrame frame = board.getJFrame();
		frame.addKeyListener(deflector);
		
		ball.setWall(wall);
		ball.setDeflector(deflector);
		deflector.setWall(wall);
		
		while(true){
			
		//	board.clear();
			
			ball.move();
			if(ball.getY()>700) break;
			
			ball.draw(board);
			wall.draw(board);
			deflector.draw(board);    ///////
		
			board.repaint();
			timer.pause(1);
		}
		canvas.setFont(new Font("arial", Font.BOLD, 120));

		canvas.setColor(Color.RED);
		canvas.drawString("GAME ", 100, 180);
		canvas.setColor(Color.BLUE);
		canvas.drawString("OVER!", 100, 320);

		board.repaint();

	}

}
