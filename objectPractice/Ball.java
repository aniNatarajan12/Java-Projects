package jrJava.objectPractice;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import resources.SoundPlayer;

public class Ball {
	int x = 500;
	int y = 300;
	int radius = 80;
	Color color = Color.red;
	int vx = 5;
	int vy = 3;
	Wall wall;
	SoundPlayer sound;

	Ball(){
		sound = new SoundPlayer();
		sound.load("imagesAndSounds/Boing.wav");
	}

	Ball(int _x,int _y, Color _color, int _vx, int _vy){
		x = _x;
		y = _y;
		color = _color;
		vx = _vx;
		vy = _vy;
		sound = new SoundPlayer();
		sound.load("imagesAndSounds/Boing.wav");
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
		if(y<=wall.top+radius || y>=wall.bottom-30){
			vy = -vy;
			sound.play();
		}
	}

	void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
}