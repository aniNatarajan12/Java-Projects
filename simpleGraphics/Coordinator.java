package jrJava.simpleGraphics;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.Timer;


public class Coordinator {

	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		FancyDrawingBoard board = new FancyDrawingBoard(900, 600);

		Pen pen = new Pen(board, Color.red, 1.0f, 7.0f);
		PenTool penTool = new PenTool(pen);
		pen.setPenTool(penTool);
		
		penTool.draw(board.getTCanvas2());
		
		board.addMouseListener(pen);
		board.addMouseMotionListener(pen);
		
		board.clearCanvas();
		
		
		while(true){
			
			board.repaint();
			timer.pause(20);
		}
		
		
	}

}