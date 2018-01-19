package jrJava.wagonChase;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import resources.DrawingBoard;


public class RobotManager {

	private static final int numOfRobotTypes = 4, numOfRobotImages = 3;
	private static ArrayList<Robot> robots;
	private static final Image[] image1, image2, buried;
	
	static {
		robots = new ArrayList<Robot>();
		
		image1 = new Image[numOfRobotTypes];
		image2 = new Image[numOfRobotTypes];
		buried = new Image[numOfRobotTypes];
		
		for(int i=1; i<=numOfRobotTypes; i++){
			image1[i-1] = new ImageIcon(Coordinator.RESOURCE_PATH + "s_robot"+i+"_1.png").getImage();
			image2[i-1] = new ImageIcon(Coordinator.RESOURCE_PATH + "s_robot"+i+"_2.png").getImage();
			buried[i-1] = new ImageIcon(Coordinator.RESOURCE_PATH + "s_robot"+i+"_buried.png").getImage();
		}
	}
	
	
	
	private static void launch(){
		int randomIndex = (int) (Math.random()*numOfRobotTypes);
		robots.add(new Robot(image1[randomIndex], 
				             image2[randomIndex], 
				             buried[randomIndex], 
				             Math.random()*2+0.5, 
				             0));
	}
	
	
	
	public static void move(){
		
		if(Math.random()>0.98) launch();
		
		Robot each;
		for(int i=robots.size()-1; i>=0; i--){
			each = robots.get(i);
			each.move();
			
			if(each.toBeRemoved()){
				robots.remove(i);
			}
		}
	}
	
	
	public static void draw(DrawingBoard board){
		for(int i=0; i<robots.size(); i++){
			robots.get(i).draw(board);
		}
	}
	
	
	public static boolean isHit(Projectile p){
		for(int i=0; i<robots.size(); i++){
			if(robots.get(i).isHit(p)) return true;
		}
		return false;
	}
	
}














