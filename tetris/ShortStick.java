package jrJava.tetris;


public class ShortStick extends TetrisObject {

	
	protected void createTetrisObject(){
		
		int index =  (int) (Math.random()*colorMenu.length);
		color = colorMenu[index];
		
		blocks = new Block[3];
		
		blocks[0] = new Block( 0, -1, color);
		blocks[1] = new Block( 0,  0, color);
		blocks[2] = new Block( 0,  1, color);
		
		updateBlocks();
	}
	
	
	public void rotateClockwise(){
		for(int i=0; i<blocks.length; i++){
			blocks[i].rotateClockwise();
		}
		updateBlocks();
		
		if(!isLegal()){
			for(int i=0; i<blocks.length; i++){
				blocks[i].rotateCounterClockwise();
			}
			updateBlocks();
		}
		
	}
	
	
}
