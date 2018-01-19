package jrJava.tetris;

import java.util.ArrayList;

import resources.DrawingBoard;
import resources.SoundPlayer;


public class Graveyard {

	public static SoundPlayer eerieSound = new SoundPlayer();
	private static TombStack[] stacks;
	private static ArrayList<Integer> fullRowYValues;
	

	static {
		stacks = new TombStack[(Wall.RIGHT-Wall.LEFT)/Block.SIZE];
		for(int i=0; i<stacks.length; i++){
			stacks[i] = new TombStack();
		}
		
		fullRowYValues = new ArrayList<Integer>();
		
		eerieSound.load(Coordinator.RESOURCE_PATH + "eerie.wav");
	}
	
	
	public static boolean isInside(Block block){
		for(int i=0; i<stacks.length; i++){
			if(stacks[i].isInside(block)) return true;
		}
		return false;
	}
	
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<stacks.length; i++){
			stacks[i].draw(board);
		}
	}
	
	
	public static void bury(Block block){
		int targetIndex = (block.getX()-Wall.LEFT)/Block.SIZE;
		stacks[targetIndex].add(block);
		
		checkFullRowFormed(block);  ////
	}
	
	
	public static void checkFullRowFormed(Block block){
		
		int y = block.getY();
		
		for(int i=0; i<stacks.length; i++){
			if(!stacks[i].contains(y)) return;
		}
		
		for(int i=0; i<stacks.length; i++){
			stacks[i].markAsFullRow(y);		
		}
		
		fullRowYValues.add( new Integer(y) );
	}
	
	
	public static void clearFullRowsIfAny(){
		
		if(fullRowYValues.size()==0) return;
		
		eerieSound.play();
		
		ArrayList<Integer> ordered = new ArrayList<Integer>();
		
		while(fullRowYValues.size()>0){
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			
			for(int i=0; i<fullRowYValues.size(); i++){
				int each = fullRowYValues.get(i).intValue();
				if(each<min){
					min = each;
					minIndex = i;
				}
			}
			ordered.add( fullRowYValues.remove(minIndex) );
		}
		
		
		for(int i=0; i<ordered.size(); i++){
			int each = ordered.get(i).intValue();
			for(int j=0; j<stacks.length; j++){
				stacks[j].remove(each);
				stacks[j].shiftAnyAbove(each);
			}
		}
		
		fullRowYValues.clear();
	}
}
















