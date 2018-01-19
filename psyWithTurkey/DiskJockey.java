package jrJava.psyWithTurkey;

import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;

public class DiskJockey {
	
	public static final String RECOURSE_PATH = "jrJava/psyWithTurkey/imagesAndSounds/";

	public static void main(String[] args) {
		
		DrawingBoard board = new DrawingBoard(1000, 700);
		Timer timer = new Timer();
		
		Psy hoppingPsy = new Psy(board, timer);
		
		board.setBackgroundImage(RECOURSE_PATH + "bg.png");
		
		SoundPlayer bgSound = new SoundPlayer();
		bgSound.load(RECOURSE_PATH + "bgMusic.wav");
		bgSound.playLoop();
		
		while(true){
			hoppingPsy.hop();
		}
	}

}
