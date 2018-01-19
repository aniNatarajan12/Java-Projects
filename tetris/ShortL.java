package jrJava.tetris;


public class ShortL extends TetrisObject {

	
	protected void createTetrisObject(){
		
		int index =  (int) (Math.random()*colorMenu.length);
		color = colorMenu[index];
		
		blocks = new Block[3];
		
		blocks[0] = new Block( 0, -1, color);
		blocks[1] = new Block( 0,  0, color);
		blocks[2] = new Block( 1,  0, color);
		
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
	

	public void mirror(){
		for(int i=0; i<blocks.length; i++){
			blocks[i].mirror();
		}
		updateBlocks();
		
		if(!isLegal()){
			for(int i=0; i<blocks.length; i++){
				blocks[i].mirror();
			}
			updateBlocks();
		}
	}
	
}

