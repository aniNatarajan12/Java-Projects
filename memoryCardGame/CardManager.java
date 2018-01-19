package jrJava.memoryCardGame;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import resources.DrawingBoard;
import resources.SoundPlayer;


public class CardManager implements MouseListener {

	public static int num, col, row;
	private static Card[] cards;

	private static boolean noneSelected=true, oneSelected, twoSelected;
	private static Card firstSelected, secondSelected;
	private static long twoSelectionTime;

	private static SoundPlayer buzz, chime, tick;
	

	private static String[] imageNames = new String[]{
		"apple.png",
		"backside.png",
		"bank.png",
		"basketball.png",
		"bubble_blue.png",
		"bubble_green.png",
		"bubble_red.png",
		"building.png",
		"cat.png",
		"cheese.png",
		"denture.png",
		"dog.png",
		"hockey_stick.png",
		"keys.png",
		"phone.png",
		"pizza.png",
		"santa.png",
		"soccer_ball.png",
		"sock.png",
		"toilet_bowl.png",
		"toilet_paper.png",
		"xmas_tree.png"			
	};



	static {
		col = Coordinator.COL_NUM;
		row = Coordinator.ROW_NUM;
		num = col*row;
		if(num%2==1) num++;

		ArrayList<String> names = new ArrayList<String>();
		for(int i=0; i<imageNames.length; i++)  names.add(imageNames[i]);
		
		ArrayList<Image> images = new ArrayList<Image>();
		for(int i=0; i<num/2; i++){
			String each = names.remove( (int)(Math.random()*names.size()) );
			Image image = new ImageIcon(Coordinator.RESOURCE_PATH + each).getImage();
			images.add(image);
			images.add(image);
		}
		
		
		cards = new Card[num];
		for(int i=0; i<num; i++){

			cards[i] = new Card( images.remove( (int)(Math.random()*images.size())), 
					             i%col*Card.SIZE + Coordinator.MARGIN, 
					             i/col*Card.SIZE + Coordinator.MARGIN);
		}

		buzz = new SoundPlayer();
		chime = new SoundPlayer();
		tick = new SoundPlayer();
		buzz.load(Coordinator.RESOURCE_PATH + "buzz.wav");
		chime.load(Coordinator.RESOURCE_PATH + "chime.wav");
		tick.load(Coordinator.RESOURCE_PATH + "tick.wav");
	}


	public static void update(){

		if(twoSelected){

			if(System.currentTimeMillis() > twoSelectionTime + 2000){

				if(firstSelected.isEqual(secondSelected)){
					firstSelected.matched();
					secondSelected.matched();
					twoSelected = false;
					noneSelected = true;
					chime.play();
				}
				else{
					firstSelected.hide();
					secondSelected.hide();
					twoSelected = false;
					noneSelected = true;
					buzz.play();
				}
			}
		}
	}


	public static void draw(DrawingBoard board){
		for(int i=0; i<cards.length; i++){
			cards[i].draw(board);
		}
	}


	public void mousePressed(MouseEvent e) {

		if(twoSelected) return;

		for(int i=0; i<cards.length; i++){
			if(cards[i].isInside(e.getX(), e.getY())){

				if(noneSelected){
					noneSelected = false;
					oneSelected = true;
					firstSelected = cards[i];
					firstSelected.show();
					tick.play();
				}
				else if(oneSelected && cards[i]!=firstSelected){
					oneSelected = false;
					twoSelected = true;
					secondSelected = cards[i];
					secondSelected.show();
					tick.play();
					
					twoSelectionTime = System.currentTimeMillis();
				}

			}
		}
	}


	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}












