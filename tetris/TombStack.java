package jrJava.tetris;

import java.util.ArrayList;

import resources.DrawingBoard;



public class TombStack {


	private ArrayList<Block> blocks;


	public TombStack(){
		blocks = new ArrayList<Block>();
	}


	public void add(Block block){
		blocks.add(block);
	}
	
	
	public boolean isInside(Block block){
		int x = block.getX();
		int y = block.getY();
		for(int i=0; i<blocks.size(); i++){
			if(blocks.get(i).getX()==x && blocks.get(i).getY()==y) return true;
		}
		return false;
	}



	public void draw(DrawingBoard board){
		for(int i=0; i<blocks.size(); i++){
			blocks.get(i).draw(board);
		}
	}

	
	public boolean contains(int y){
		for(int i=0; i<blocks.size(); i++){
			if(blocks.get(i).getY()==y) return true;
		}
		return false;
	}
	
	
	public void markAsFullRow(int y){
		for(int i=0; i<blocks.size(); i++){
			Block each = blocks.get(i);
			if(each.getY()==y){
				each.markAsFullRowBlock();
				return;
			}
		}
	}
	
	
	public void remove(int y){
		for(int i=0; i<blocks.size(); i++){
			if(blocks.get(i).getY()==y){
				blocks.remove(i);
				return;
			}
		}
	}
	
	
	public void shiftAnyAbove(int y){
		for(int i=0; i<blocks.size(); i++){
			Block each = blocks.get(i);
			if(each.getY()<y){
				each.moveDown();
			}
		}
	}
}





















