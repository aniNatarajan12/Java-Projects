package jrJava.blinkingBalls;

import java.awt.Color;
import java.awt.Graphics2D;
import resources.DrawingBoard;
import resources.SoundPlayer;

public class Ball {

	int radius = 80;
	int x = 100;
	int y = 150;
	Color color = Color.red;
	int vx = 2;
	int vy = 3;
	boolean overlap;
	
	
	Wall wall;
	SoundPlayer sound;
	Ball theOtherBall;
	
	Ball(Color _color, int _x, int _y, int _radius, int _vx, int _vy){
		x = _x;
		y = _y;
		radius = _radius;
		vx = _vx;
		vy = _vy;
		color = _color;
		sound = new SoundPlayer();
		sound.load("imagesAndSounds/Boing.wav");
	}
	
	
	void setWall(Wall _wall){
		wall = _wall;
	}
	
	void setTheOtherBall(Ball _theOtherBall){
		theOtherBall = _theOtherBall;
	}
	
	
	void move(){
		int distSq = (x-theOtherBall.x)*(x-theOtherBall.x) + (y-theOtherBall.y)*(y-theOtherBall.y);
		int radiiSumSq = (radius + theOtherBall.radius)*(radius + theOtherBall.radius);
		
		x = x + vx;
		y = y + vy;
		
		if(x<=wall.left + radius || x>=wall.right - radius){
			vx = -vx;
			sound.play();
		}
		if(y<=wall.top + radius || y>=wall.bottom - radius){
			vy = -vy;
			sound.play();
		}
		
		if(distSq<=radiiSumSq){
			overlap = true;
		}
		else{
			overlap = false;
		}
	}
	
	
	void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		if(overlap){
			canvas.setColor(Color.DARK_GRAY);
			//vx=-vx;
			//theOtherBall.vx=-theOtherBall.vx;
			//vy=-vy;
			//theOtherBall.vy=-theOtherBall.vy;
		}
		else{
			canvas.setColor(color);
		}
		canvas.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
}
