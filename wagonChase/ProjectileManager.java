package jrJava.wagonChase;

import java.util.ArrayList;

import resources.DrawingBoard;


public class ProjectileManager {

	//	private static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	private static final int numberOfProjectiles = 10;

	private static LinkedList actives = new LinkedList();
	private static LinkedList inActives = new LinkedList();

	static{
		for(int i=0;i<numberOfProjectiles;i++){
			inActives.insert(new Projectile(0, 0, 0, 0));
		}
	}
	
	public static void move(){
		Link link;
		Projectile each;
		for(Iterator iter = actives.iterator(); iter.hasNext();){
			link = iter.next();
			each = (Projectile) link.obj;
			each.move();
			
			if(each.toBeRemoved()){
				iter.remove()
				inActives.insert(link);
			}
		}
	}

	/*
	public static void add(Projectile p){
		projectiles.add(p);
	}
	 */

	/*
	public static void move(){
		Projectile each;
		for(int i=projectiles.size()-1; i>=0; i--){
			each = projectiles.get(i);
			each.move();
			if(each.toBeRemoved()) projectiles.remove(i);
		}
	}
	 */

	/*
	public static void draw(DrawingBoard board){
		for(int i=0; i<projectiles.size(); i++){
			projectiles.get(i).draw(board); 
		}
	}
	 */

	/*
	//private static LinkedList actives, inActives;

	public static void prepare(int size){
		// creates total size number of Projectiles.
		// put them into the inActives.
	}


	public static void shoot(double xStart, double yStart, double vx, double vy){
		// remove the first projectile from inActives.
		// set the projectile's states with the parameters.
		// insert that at the beginning of the actives.
	}

	public static void move(){
		// iterate thru the actives.
		// make each to move.
		// if found it is labeled 'toBeRemoved', we remove it and put into the inActives.
	}


	public static void draw(DrawingBoard board){
		// iterate thru the actives.
		// make each to draw.
	}
	 */
}


