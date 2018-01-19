package jrJava.networkPingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import resources.DrawingBoard;


public class Deflector implements MouseListener, MouseMotionListener {

	
	public static final int WIDTH = 30, HEIGHT = 150;
	
	private int x, y;
	private Color color;
	private int lastY;
	private MessageSender mS;
	
	public Deflector(int _x, int _y, Color _color){
		x = _x;
		y = _y;
		color = _color;
	}
	
	public int getX(){ return x; }
	public int getY(){ return y; }

	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x, y, WIDTH, HEIGHT);
	}

	
	public void mouseDragged(MouseEvent e) {
		int mouseY = e.getY();
		y += mouseY - lastY;
		lastY = mouseY;
		
		if(y<0) y = 0;
		else if(y>Pingpong.SCREEN_HEIGHT-HEIGHT) y = Pingpong.SCREEN_HEIGHT-HEIGHT;
		
		mS.send("D:" + y);
	}

	
	
	public void mousePressed(MouseEvent e) {
		lastY = e.getY();
	}

	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


	public void setMessageSender(MessageSender _mS) {
		mS = _mS;
	}
	
	public void setY(int _y){
		y = _y;
	}
	
}