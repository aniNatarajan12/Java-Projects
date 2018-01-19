package jrJava.tetris;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import resources.DrawingBoard;
import resources.SoundPlayer;


public abstract class TetrisObject implements KeyListener {

	
	public static SoundPlayer bubblingSound = new SoundPlayer();
	public static SoundPlayer arrowSound = new SoundPlayer();
	public static SoundPlayer shiftSound = new SoundPlayer();
	public static SoundPlayer kChingSound = new SoundPlayer();
	
	
	public static Color[] colorMenu = new Color[]{ Color.RED,
												   Color.GREEN,
												   Color.BLUE,
												   Color.YELLOW,
												   Color.MAGENTA,
												   Color.PINK,
												   Color.CYAN,
												   Color.ORANGE };
	
	protected Block[] blocks;
	protected int xCenter, yCenter;
	protected Color color;
	protected boolean isBuried;
	

	static {
		bubblingSound.load(Coordinator.RESOURCE_PATH + "bubbling.wav");
		arrowSound.load(Coordinator.RESOURCE_PATH + "arrow.wav");
		shiftSound.load(Coordinator.RESOURCE_PATH + "shift.wav");
		kChingSound.load(Coordinator.RESOURCE_PATH + "kChing.wav");
	}
	
	
	public TetrisObject(){
		xCenter = (Wall.LEFT + Wall.RIGHT)/2;
		yCenter = Wall.TOP + 3*Block.SIZE;
		createTetrisObject();
	}


	protected abstract void createTetrisObject();

	
	protected boolean isLegal(){
		for(int i=0; i<blocks.length; i++){
			if( Wall.isOutside(blocks[i]) || Graveyard.isInside(blocks[i])){
				return false;
			}
		}
		return true;
	}

	
	protected void buryToGraveyard(){
		for(int i=0; i<blocks.length; i++){
			blocks[i].markAsBuried();
			Graveyard.bury(blocks[i]);
		}
	}
	
	
	
	public boolean isBuried(){
		return isBuried;
	}
	
	
	
	public void moveDown(){
		bubblingSound.play();
		yCenter += Block.SIZE;
		updateBlocks();
		
		if(!isLegal()){
			yCenter -= Block.SIZE;
			updateBlocks();
			buryToGraveyard();
			isBuried = true;
		}
	}


	public void hardDrop(){
		
		while(true){
			yCenter += Block.SIZE;
			updateBlocks();
			
			if(!isLegal()){
				yCenter -= Block.SIZE;
				updateBlocks();
				buryToGraveyard();
				isBuried = true;
				return;
			}
		}
	}
	
	
	
	public void moveLeft(){
		xCenter -= Block.SIZE;
		updateBlocks();
		
		if(!isLegal()){
			xCenter += Block.SIZE;
			updateBlocks();
		}
	}
	
	
	public void moveRight(){
		xCenter += Block.SIZE;
		updateBlocks();
		
		if(!isLegal()){
			xCenter -= Block.SIZE;
			updateBlocks();
		}
	}
	

	public void mirror(){
		//for(int i=0; i<blocks.length; i++){
		//	blocks[i].mirror();
		//}
		//updateBlocks();
	}
	
	
	public void rotateClockwise(){
		//for(int i=0; i<blocks.length; i++){
		//	blocks[i].rotateClockwise();
		//}
		//updateBlocks();
	}
	
	
	
	public void updateBlocks(){
		for(int i=0; i<blocks.length; i++){
			blocks[i].findAbsoluteXY(xCenter, yCenter);
		}
	}



	public void draw(DrawingBoard board){
		for(int i=0; i<blocks.length; i++){
			blocks[i].draw(board);
		}
	}


	public void keyPressed(KeyEvent e){

		int key = e.getKeyCode();

		if(key==KeyEvent.VK_LEFT){
			shiftSound.play();
			moveLeft();
		}
		else if(key==KeyEvent.VK_RIGHT){
			shiftSound.play();
			moveRight();
		}
		else if(key==KeyEvent.VK_Q){
			arrowSound.play();
			rotateClockwise();
		}
		else if(key==KeyEvent.VK_W){
			arrowSound.play();
			mirror();
		}
		else if(key==KeyEvent.VK_DOWN){
			kChingSound.play();
			hardDrop();
		}

	}



	public void keyTyped(KeyEvent e){ }
	public void keyReleased(KeyEvent e){ }

}



