package jrJava.Tower;

import java.awt.Color;
import java.awt.Graphics2D;
import resources.DrawingBoard;


public class Disk {

	public static int thickness = 20;
	private int width;
	private Color color;
	
	
	public Disk(int _width, Color _color){
		width = _width;
		color = _color;
	}
	
	
	public void draw(DrawingBoard board, int x, int y){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillRect(x-width/2, y, width, thickness);
		canvas.setColor(Color.black);
		canvas.drawRect(x-width/2, y, width, thickness);
	}
}
