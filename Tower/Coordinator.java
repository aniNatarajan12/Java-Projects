package jrJava.Tower;

import java.awt.Color;

import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	
	private static DrawingBoard board = new DrawingBoard(800, 600);
	private static Timer timer = new Timer();
	private static Tower A, B, C;
	
	
	public static void main(String[] args) {
	
		A = new Tower(150);
		B = new Tower(400);
		C = new Tower(650);
		
		A.push( new Disk(210, Color.yellow) );
		A.push( new Disk(190, Color.gray) );
		A.push( new Disk(170, Color.black) );
		A.push( new Disk(150, Color.red) );
		A.push( new Disk(130, Color.blue) );
		A.push( new Disk(110, Color.green) );
		A.push( new Disk(90, Color.cyan) );
		A.push( new Disk(70, Color.orange) );
		A.push( new Disk(50, Color.magenta) );
		A.push( new Disk(30, Color.pink) );
		A.push( new Disk(10, Color.lightGray) );
		
		drawTowers();
		move(A.size(), A, B, C);
	}

	
	private static void move(int topN, Tower from, Tower stage, Tower to){
		
		if(topN==1){
			to.push(from.pop());
			drawTowers();
		}
		else {
			move(topN-1, from, to, stage);
			to.push(from.pop());
			drawTowers();
			move(topN-1, stage, from, to);
		}
	}
	
	
	
	private static void drawTowers(){
		board.clear();
		
		A.draw(board);
		B.draw(board);
		C.draw(board);
		
		board.repaint();
		timer.pause(10);
	}
	
}