package jrJava.memoryCardGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import resources.DrawingBoard;


public class Card {

	public static final int SIZE = 100;
	public static final int INSET = 10;
	public static final int PADDING = 5;
	public static final Image backSideImage;
	
	private Image image;
	private int x, y;
	private boolean selected;
	private boolean matched;
	
	static{
		backSideImage = new ImageIcon(Coordinator.RESOURCE_PATH + "toilet_bowl.png").getImage();
	}
	
	public Card(Image _image, int _x, int _y){
		image = _image;
		x = _x;
		y = _y;
	}
	
	
	public void show(){ selected = true; }
	public void hide(){ selected = false; }
	public void matched(){ matched = true; }
	public boolean hasBeenMatched(){ return matched; }
	
	
	public boolean isInside(int _x, int _y){
		return _x>x && _x<x+SIZE && _y>y && _y<y+SIZE;
	}
	
	
	public boolean isEqual(Card card){
		return image==card.image;
	}
	
	
	public void draw(DrawingBoard board){
		
		if(matched) return;
		
		Graphics2D canvas = board.getCanvas();
		if(selected){
			canvas.drawImage(image, x+INSET, y+INSET, SIZE-2*INSET, SIZE-2*INSET, board);
		}
		else {
			canvas.drawImage(backSideImage, x+INSET, y+INSET, SIZE-2*INSET, SIZE-2*INSET, board);
		}
		
		canvas.setColor(Color.LIGHT_GRAY);
		canvas.drawRect(x, y, SIZE, SIZE);
		canvas.setColor(Color.BLACK);
		canvas.drawRect(x+PADDING, y+PADDING, SIZE-2*PADDING, SIZE-2*PADDING);
	}
	
}