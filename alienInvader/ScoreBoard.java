package jrJava.alienInvader;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;


public class ScoreBoard {

	public static final int SCORE_BOARD_WIDTH = 100;
	public static final int DISPLAY_X = 822;
	public static final int DISPLAY_W = 50;
	public static final int DISPLAY_H = 200;
	public static final int SCORE_BOARD_Y = 110;
	public static final int TORPEDO_LEVEL_Y = 400;

	private static int score = 0;
	private static int numOfTorpedos = 50;
	private static long lastTimeTorpedoDepleted;
	private static long currentTime = System.currentTimeMillis();

	public static int getScore(){ return score; }
	public static void draw(DrawingBoard board){

		Graphics2D canvas = board.getCanvas();

		canvas.setColor(Color.WHITE);
		canvas.fillRect(DISPLAY_X, SCORE_BOARD_Y, DISPLAY_W, DISPLAY_H);
		int barHeight = score/10;
		if(barHeight>200) barHeight = 200;
		else if(barHeight<0) barHeight = 0;
		canvas.setColor(Color.RED);
		canvas.fillRect(DISPLAY_X, SCORE_BOARD_Y+DISPLAY_H-barHeight, DISPLAY_W, barHeight); 
		canvas.drawString(String.valueOf(score), DISPLAY_X+5, SCORE_BOARD_Y+15);

		canvas.setColor(Color.WHITE);
		canvas.fillRect(DISPLAY_X, TORPEDO_LEVEL_Y, DISPLAY_W, DISPLAY_H);
		barHeight = numOfTorpedos*2;
		if(barHeight>200) barHeight = 200;
		else if(barHeight<0) barHeight = 0;
		canvas.setColor(Color.BLUE);
		canvas.fillRect(DISPLAY_X, TORPEDO_LEVEL_Y+DISPLAY_H-barHeight, DISPLAY_W, barHeight); 
		canvas.drawString(String.valueOf(numOfTorpedos), DISPLAY_X+5, TORPEDO_LEVEL_Y+15);
	}


	public static boolean torpedoAvailable(){
		if(numOfTorpedos>0) return true;
		return false;
	}


	public static void update(){
		if(numOfTorpedos==0){
			long currentTime = System.currentTimeMillis();
			long lapse = currentTime - lastTimeTorpedoDepleted;
			if(lapse>5000){
				numOfTorpedos = 1;
				score -= 50;
				lastTimeTorpedoDepleted = Long.MAX_VALUE;
			}

		}
		ScoreMax();
	}


	public static void consumeTorpedo(){
		if(numOfTorpedos>0){
			numOfTorpedos--;
			score--;
			if(numOfTorpedos==0){
				lastTimeTorpedoDepleted = System.currentTimeMillis();
			}
		}
		ScoreMax();
	}


	public static void alienshotDown(){
		numOfTorpedos += 2;
		score += 10;
		ScoreMax();
	}

	public static void ScoreMax(){
		if(score>=2000){
			Coordinator.Win = true;
			Coordinator.gameOver = true;
		}
	}

	public static void missileShotDown(){
		score += 5;
		ScoreMax();
	}

	public static void addTorpedo(){
		numOfTorpedos += 10;
	}

	public static void addScore(){
		score += 25;
		ScoreMax();
	}
	
	public static void didLose(){
		if(score<=-100){
			Coordinator.gameOver=true;
		}
	}
	
	public static void godMode(){
		if(Coordinator.godMode==true){
			long currentTime = System.currentTimeMillis();
			long lapse = currentTime - Coordinator.godModeOn;
			if(lapse>5000){
				score -= 50;
				Coordinator.godModeOn = Long.MAX_VALUE;
			}
			score -= 100;
		}
	}
}