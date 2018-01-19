package jrJava.memoryCardGame;

import resources.DrawingBoard;
import resources.Timer;

public class Coordinator {

	public static final String RESOURCE_PATH = "jrJava/memoryCardGame/imagesAndSounds/";
	public static final int ROW_NUM = 6;
	public static final int COL_NUM = 6;
	public static final int MARGIN = 50;
	
	
	public static void main(String[] args) {
		
		DrawingBoard board = new DrawingBoard(700, 700);
		Timer timer = new Timer();
		
		CardManager manager = new CardManager();
		board.addMouseListener(manager);
		
		while(true){
			
			board.clear();
			manager.update();
			manager.draw(board);
			board.repaint();
			timer.pause(1);
		}
	}

}