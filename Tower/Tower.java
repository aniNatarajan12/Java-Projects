package jrJava.Tower;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import resources.DrawingBoard;


public class Tower {

	private static int baseY = 500;
	private static int width = 250;
	private static int height = 200;
	private static int thickness = 10;
	private static Color baseColor = Color.black;
	private static Color stemColor = Color.darkGray;
	
	private ArrayList<Disk> disks;
	private int centerX;
	
	
	public Tower(int _centerX){
		centerX = _centerX;
		disks = new ArrayList<Disk>();
	}
	
	
	public void push(Disk disk){
		disks.add(disk);
	}
	
	
	public Disk pop(){
		if(isEmpty()) return null;
		return disks.remove(disks.size()-1);
	}
	
	
	public Disk peek(){
		if(isEmpty()) return null;
		return disks.get(disks.size()-1);
	}
	
	
	public int size(){
		return disks.size();
	}
	
	
	public boolean isEmpty(){
		return disks.size()==0;
	}
	
	
	public void draw(DrawingBoard board){
		
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(stemColor);
		canvas.fillRect(centerX-thickness/2, baseY-height, thickness, height);
		canvas.setColor(baseColor);
		canvas.fillRect(centerX-width/2, baseY, width, thickness);
		
		for(int i=0; i<disks.size(); i++){
			disks.get(i).draw(board, centerX, baseY-(i+1)*Disk.thickness);
		}
	}
	
	
}
