package jrJava.tetris;


import resources.DrawingBoard;
import resources.SoundPlayer;
import resources.Timer;


public class Coordinator {


	public static final String RESOURCE_PATH = "jrJava/tetris/imagesAndSounds/";
	
	
	public static void main(String[] args) {

		DrawingBoard board = new DrawingBoard(600, 700);
		Timer timer = new Timer();

		TetrisObject t;
		
		SoundPlayer bgSound = new SoundPlayer();
		bgSound.load(RESOURCE_PATH + "imperialMarch.wav");
		bgSound.playLoop();


		while(true){

			t = createNewTetrisObject();
			board.getJFrame().addKeyListener(t);

			int count = 0;

			while(true){

				count++;
				if(count==14){
					Graveyard.clearFullRowsIfAny();
					t.moveDown();
					count = 0;
				}

				board.clear();

				Wall.draw(board);
				t.draw(board);
				Graveyard.draw(board);
				
				board.repaint();

				if(t.isBuried()) break;

				timer.pause(20); 
			}

			board.getJFrame().removeKeyListener(t);
			timer.pause(700);
		}
	}

	
	private static TetrisObject createNewTetrisObject(){
		
		int index = (int) (Math.random()*8);
		
		if(index==0){
			return new ShortStick();
		}
		else if(index==1){
			return new LongStick();
		}
		else if(index==2){
			return new ShortL();
		}
		else if(index==3){
			return new LongL();
		}
		else if(index==4){
			return new ShortZ();
		}
		else if(index==5){
			return new LongZ();
		}
		else if(index==6){
			return new Cross();
		}
		else if(index==7){
			return new Square();
		}
		
		return new ShortStick();
	}
	
	
}








