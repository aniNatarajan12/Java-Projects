package jrJava.wagonChase;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import resources.DrawingBoard;


public class Robot {

	public static final int Y = 420;
	private double x, y; // left, top
	private double vx, vy; 
	private double width, height;

	private Image image1, image2, buried;
	private int imageRepeatCycle;
	private int imageCounter;
	private boolean markedDead, isDead, toBeRemoved;

	private static Image explosionImage;
	private static int explosionWidth, explosionHeight;
	private double explosionX, explosionY;
	
	
	
	static{
		explosionImage = new ImageIcon(Coordinator.RESOURCE_PATH + "explosion.png").getImage();
		explosionWidth = explosionImage.getWidth(null);
		explosionHeight = explosionImage.getHeight(null);
	}
	
	
	public Robot(Image _image1, Image _image2, Image _buried, double _vx, double _vy){
		image1 = _image1;
		image2 = _image2;
		buried = _buried;
		vx = _vx;
		vy = _vy;

		imageRepeatCycle = (int)(20/vx);

		y = Y;
		width = image1.getWidth(null);
		height = image1.getHeight(null);
	}


	public boolean isHit(Projectile p){
		
		if(p.getX()>=x-p.RADIUS && p.getX()<=x+width+p.RADIUS && p.getY()>=y-p.RADIUS && p.getY()<=y+height){
			markedDead = true;
			explosionX = p.getX();
			explosionY = p.getY();
		}
		return false;
	}
	

	public boolean toBeRemoved(){
		return toBeRemoved;
	}
	
	
	public void move(/* ??? */){

		if(markedDead || isDead){
			if(x>0) x -= Coordinator.SCREEN_SPEED;
			else toBeRemoved = true;
		}
		else {
			x += vx;
			//if(x>=500) isDead = true;
		}
	}


	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();

		if(isDead){
			canvas.drawImage(buried, (int)x, (int)y, board);
		}
		else {
			imageCounter++;
			if(imageCounter>=imageRepeatCycle) imageCounter = 0;

			if(imageCounter<imageRepeatCycle/2){
				canvas.drawImage(image1, (int)x, (int)y, board);
			}
			else {
				canvas.drawImage(image2, (int)x, (int)y, board);
			}
			
			if(markedDead){
				canvas.drawImage(explosionImage, (int)explosionX-explosionWidth/2, (int)explosionY-explosionHeight/2, board);
				isDead = true;
			}
		}
	}

}















