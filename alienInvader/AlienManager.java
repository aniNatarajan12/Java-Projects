package jrJava.alienInvader;

import java.awt.Color;
import java.util.ArrayList;

import resources.DrawingBoard;


public class AlienManager {

	private static ArrayList<Alien> aliens = new ArrayList<Alien>();

	/*
	private static Color[] bodyColorMenu = new Color[]{ Color.red, Color.green, Color.blue,
		                                                Color.yellow, Color.cyan, Color.magenta,
		                                                Color.pink, Color.orange };

	private static Color[] eyeColorMenu = new Color[]{ Color.black, Color.darkGray, Color.gray };
	 */


	public static void create(){

		if(Math.random()>0.1) return;

		int x = (int) (Math.random()*Coordinator.GAME_AREA_WIDTH);
		int vx = (int) (Math.random()*10 - 5);
		int vy = (int) (Math.random()*5 + 3);

		double rand = Math.random();
		if(rand>0.5){
			Alien alien = new Alien(x, 30, vx, vy);    //, bodyColorMenu[index1], eyeColorMenu[index2]);
			aliens.add(alien);
		}
		else if(rand>0.25){
			Alien alien = 	new NastyAlien(x, 30, vx, vy);
			aliens.add(alien);
		}
		else{
			Alien alien = 	new CloakAlien(x, 30, vx, vy);
			aliens.add(alien);
		}
	}



	public static void move(Ship ship){

		create();

		for(int i=aliens.size()-1; i>=0; i--){
			Alien each = aliens.get(i);
			each.move(ship);

			// if it goes outside screen, we remove it.
			if(each.getY()>0.95*Coordinator.SCREEN_HEIGHT){
				aliens.remove(i);
			}

			// if it hits the target, we remove it.
		}
	}


	public static void draw(DrawingBoard board){
		for(int i=0; i<aliens.size(); i++){
			Alien each = aliens.get(i);
			each.draw(board);
		}
	}


	public static boolean isHit(Torpedo torpedo){

		for(int i=aliens.size()-1; i>=0; i--){
			Alien each = aliens.get(i);
			if(each.isHit(torpedo)){
				aliens.remove(i);
				return true;
			}
		}

		return false;
	}


}










