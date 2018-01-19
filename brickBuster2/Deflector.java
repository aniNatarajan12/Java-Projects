package jrJava.brickBuster2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import resources.DrawingBoard;


public class Deflector implements MouseMotionListener, MouseListener, KeyListener {

	private int x, y;
	private int width = 100, height = 15;
	private Color color = Color.magenta;
	int CheatCount=0;
	static int time=0;
	int small=100;
	int big=500;
	
	private Wall wall;
	
	private int lastX;
	
	
	public Deflector(int _x, int _y){
		x = _x;
		y = _y;
	}
	
	
	public void setWall(Wall _wall){
		wall = _wall;
	}
	
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, width, height);
		
		canvas.setColor(Color.white);
		String scoreInString = String.valueOf( Coordinator.score );
		canvas.drawString(scoreInString, x+40, y+12);
	}


	
	public void mouseDragged(MouseEvent e) {
		int mouseX = e.getX();
		int diff = mouseX - lastX;
		x = x + diff;
		
		lastX = mouseX;
		
		if(x<wall.getLeft()){
			x = wall.getLeft();
		}
		else if(x+width>wall.getRight()){
			x = wall.getRight() - width;
		}
	}


	public void mouseMoved(MouseEvent e) { }
	public void mouseClicked(MouseEvent e) { }


	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
	}


	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	
	public void keyPressed(KeyEvent e){

		char typed= e.getKeyChar();
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_SPACE && width==small&&CheatCount<5){
			width=big;
			color = Color.red;
			if(time>1000){
				width=small;
				color = Color.magenta;
			}
		}
		else if(keyCode==KeyEvent.VK_SPACE&&CheatCount<5){
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











