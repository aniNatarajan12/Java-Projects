package jrJava.objectPractice2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;
import resources.SoundPlayer;

public class Ball {
	int x = 500;
	int y = 300;
	int radius = 80;
	int vx = 5;
	int vy = 3;
	
	Wall wall;
	SoundPlayer sound;
	Image image;
	
	Ball(int _x,int _y, int _vx, int _vy, String filePath){
		x = _x;
		y = _y;
		vx = _vx;
		vy = _vy;
		sound = new SoundPlayer();
		sound.load("imagesAndSounds/Boing.wav");
		
		image = new ImageIcon(filePath).getImage();
		radius = image.getWidth(null)/2;
	}

	void setWall(Wall _wall){
		wall = _wall;
	}


	void move(){
		x = x+ vx;
		y = y + vy;

		if(x<=wall.left+radius || x>= wall.right-radius){
			vx = -vx;
			sound.play();
		}
		if(y<=wall.top+radius || y>=wall.bottom-50){
			vy = -vy;
			sound.play();
		}
	}

	void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.drawImage(image,x-radius,y-radius,board);
	}
}