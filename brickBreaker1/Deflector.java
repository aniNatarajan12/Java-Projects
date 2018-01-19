package jrJava.brickBreaker1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import resources.DrawingBoard;
import resources.Timer;

public class Deflector implements KeyListener {

	private int x, y; //left, top corner
	private int width = 100, height = 15;
	private Color color = Color.magenta;

	public int getX() { return x;}
	public int getY() { return y;}
	public int getWidth() { return width;}
	public int getHeight() { return height;}
	private int small = 100;
	private int big = 500;
	private int CheatCount = 0;
	private int time = 0;

	private Timer timer;
	private Wall wall;

	public  Deflector(int _x, int _y){
		x = _x;
		y = _y;
	}

	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, width, height);

	}


	public void setWall(Wall _wall){
		wall=_wall;
	}
	public void keyPressed(KeyEvent e){

		char typed= e.getKeyChar();
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_LEFT || typed=='a'){
			x=x-5;
		}
		else if(keyCode==KeyEvent.VK_RIGHT || typed=='d'){
			x=x+5;
		}

		if(keyCode==KeyEvent.VK_UP && width==small&&CheatCount<5){
			width=big;
			color = Color.red;
		}
		else if(keyCode==KeyEvent.VK_UP&&CheatCount<5){
			width = small;
			color = Color.magenta;
			x=(wall.getLeft()+wall.getRight())/2 - width/2;
			CheatCount++;
		}
		if(x<wall.getLeft()){
			x = wall.getLeft();
		}
		else if(x>wall.getRight()-width){
			x = wall.getRight()-width;
		}


	}

	public void keyReleased(KeyEvent e){
		//System.out.println("I was in the keyReleased() method.");
	}

	public void keyTyped(KeyEvent e){
		//System.out.println("I was in the keyTyped() method.");
		
			
		
	}
}
