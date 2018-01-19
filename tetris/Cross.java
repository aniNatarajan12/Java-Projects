package jrJava.tetris;

public class Cross extends TetrisObject {


	protected void createTetrisObject(){

		int index =  (int) (Math.random()*colorMenu.length);
		color = colorMenu[index];

		blocks = new Block[5];

		blocks[0] = new Block(  0,  0, color);
		blocks[1] = new Block(  0, -1, color);
		blocks[2] = new Block(  0,  1, color);
		blocks[3] = new Block( -1,  0, color);
		blocks[4] = new Block(  1,  0, color);

		updateBlocks();
	}

}
