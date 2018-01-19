package jrJava.simpleGraphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


public class PenTool {

	private Pen pen;
	private Image penToolImage;

	private int x = 750, y = 50; // left, top
	private int size = 30;
	private int w = 3*size;
	private int h = 10*size;


	public PenTool(Pen _pen){
		pen = _pen;
		penToolImage = new ImageIcon("jrJava/simpleGraphics/penTool3.png").getImage();
	}


	public boolean isPressed(int mx, int my){

		if(mx<x || mx>x+w || my<y || my>y+h) return false;

		
		if(mx>=x+0*size && mx<x+1*size){

			if(my>=y+0*size && my<y+1*size) pen.setColor(Color.red);
			else if(my>=y+1*size && my<y+2*size) pen.setColor(Color.blue);
			else if(my>=y+2*size && my<y+3*size) pen.setColor(new Color(0, 150 ,0));
			else if(my>=y+3*size && my<y+4*size) pen.setColor(Color.yellow);
			else if(my>=y+4*size && my<y+5*size) pen.setColor(Color.cyan);
			else if(my>=y+5*size && my<y+6*size) pen.setColor(Color.green);
			else if(my>=y+6*size && my<y+7*size) pen.setColor(Color.magenta);
			else if(my>=y+7*size && my<y+8*size) pen.setColor(Color.black);
			else if(my>=y+8*size && my<y+9*size) pen.setColor(Color.gray);
			else if(my>=y+9*size && my<y+10*size) pen.setEraser();

		}
		else if(mx>=x+1*size && mx<x+2*size){
			
			if(my>=y+0*size && my<y+1*size) pen.setThickness(0.5f);
			else if(my>=y+1*size && my<y+2*size) pen.setThickness(1.0f);
			else if(my>=y+2*size && my<y+3*size) pen.setThickness(2.0f);
			else if(my>=y+3*size && my<y+4*size) pen.setThickness(3.0f);
			else if(my>=y+4*size && my<y+5*size) pen.setThickness(6.0f);
			else if(my>=y+5*size && my<y+6*size) pen.setThickness(10.0f);
			else if(my>=y+6*size && my<y+7*size) pen.clearTopLayer();
			else if(my>=y+7*size && my<y+8*size) pen.clearBottomLayer();
			else if(my>=y+8*size && my<y+9*size) pen.merge();
			else if(my>=y+9*size && my<y+10*size) pen.saveAsFile();
			
		}
		else if(mx>=x+2*size && mx<x+3*size){
			
			if(my>=y+0*size && my<y+1*size) pen.setAlpha(0.1f);
			else if(my>=y+1*size && my<y+2*size) pen.setAlpha(0.2f);
			else if(my>=y+2*size && my<y+3*size) pen.setAlpha(0.3f);
			else if(my>=y+3*size && my<y+4*size) pen.setAlpha(0.4f);
			else if(my>=y+4*size && my<y+5*size) pen.setAlpha(0.5f);
			else if(my>=y+5*size && my<y+6*size) pen.setAlpha(0.6f);
			else if(my>=y+6*size && my<y+7*size) pen.setAlpha(0.7f);
			else if(my>=y+7*size && my<y+8*size) pen.setAlpha(0.8f);
			else if(my>=y+8*size && my<y+9*size) pen.setAlpha(0.9f);
			else if(my>=y+9*size && my<y+10*size) pen.setAlpha(1.0f);
		}

		return true;
	}


	public void draw(Graphics2D canvas){
		canvas.drawImage(penToolImage, x, y, null);
	}

}










