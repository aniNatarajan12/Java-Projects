package jrJava.loopPractice;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import resources.Timer;

public class Pallette {

	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(700,700);
		Graphics2D canvas = board.getCanvas();
		Timer timer = new Timer();
		
		int size = 20;
		
		for(int i=0; i<30; i++){

			for(int j=0; j<30; j++){

				int x = 50 + j*size;
				int y = 50 + i*size;
				
				Color color = new Color(0,8*j,8*i);
				
				canvas.setColor(color);
				canvas.fillRect(x,y,size,size);
				
				canvas.setColor(Color.white);
				canvas.drawRect(x,y,size,size);
				
				board.repaint();
				timer.pause(1);
			}

		}

	}

}
