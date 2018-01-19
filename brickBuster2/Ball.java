package jrJava.brickBuster2;

import java.awt.Color;
import java.awt.Graphics2D;

import resources.DrawingBoard;
import resources.SoundPlayer;


public class Ball {

	private static int radius = 10;
	private static double rateOfRadiusChange = 0.1;
	private static double maxRadius = 20.0;
	private static double minRadius = 3.0;
	private static double radiusInDouble = 5.0;
	
	private SoundPlayer sound;

	int x = 300, y = 500; 
	private int vx = 1, vy  = -2;
	private Color color = Color.red;
	private Wall wall;
	private Deflector deflector;

	private BrickManager[] brickManagers;


	public Ball(int _vx, int _vy, Color _color){ 
		vx = _vx;
		vy = _vy;
		color = _color;
		
		sound = new SoundPlayer();
		sound.load("imagesAndSounds/Boing.wav");
	}

	public static void growAndShrink(){
		radiusInDouble += rateOfRadiusChange;

		if(radiusInDouble>=maxRadius || radiusInDouble<=minRadius){
			rateOfRadiusChange = -rateOfRadiusChange;
		}
		radius = (int) radiusInDouble;
	}

	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getVX(){ return vx; }
	public int getVY(){ return vy; }
	public int getRadius(){ return radius; }

	public void setX(int _x){ x = _x; }
	public void setY(int _y){ y = _y; }
	public void setVX(int _vx){ vx = _vx; }
	public void setVY(int _vy){ vy = _vy; }


	public void setWall(Wall _wall){
		wall = _wall;
	}

	public void setDeflector(Deflector _deflector){
		deflector = _deflector;
	}

	public void setBrickManagers(BrickManager[] _brickManagers){
		brickManagers = _brickManagers;
	}


	public void move(){
		x = x + vx;
		y = y + vy;

		if(x<=wall.getLeft()+radius){
			vx = -vx;
			x = wall.getLeft()+radius;
		}
		else if(x>=wall.getRight()-radius){
			vx = -vx;
			x = wall.getRight()-radius;
		}

		if(y<=wall.getTop()+radius){
			vy = -vy;
			y = wall.getTop()+radius;
		}

		if(x>=deflector.getX()-radius &&
				x<=deflector.getX()+deflector.getWidth()+radius &&
				y>=deflector.getY()-radius &&
				y<=deflector.getY()+deflector.getHeight()){

			vy = -vy;
			y = deflector.getY()-radius;
		}


		for(int i=0; i<brickManagers.length; i++){
			boolean hit = brickManagers[i].isHit(this);
			if(hit){
				//Coordinator.score = Coordinator.score + 5;
				Coordinator.score += 5;
				sound.play();
			}
		}

	}


	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		canvas.setColor(color);
		canvas.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}

}











