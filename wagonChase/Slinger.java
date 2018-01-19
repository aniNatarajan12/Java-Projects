package jrJava.wagonChase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.ImageIcon;

import resources.DrawingBoard;


public class Slinger implements MouseListener, MouseMotionListener {

	private int x, y, refX, refY; 
	private Image[] wagons;
	private int imageIndex;
	private long nextTiltTime, tiltInterval = 150;
	
	private Point[] points;
	private static Point[] templates;
	private static Color weaponColor = new Color(90, 60, 70);
	private GeneralPath path, slingPath;
	private double angle, bendingFactor;
	private double x1, y1, x2, y2;
	
	private int mousePressedX, mousePressedY, dx, dy;
	private double dragDistance, stretchFactor;
	private boolean shouldDrawProjectile; 
	private int indexOfWeaponTop = 3;
	private double mouseActionScale = 0.3;
	private double shootingStrength = 0.09;
	
	
	static {
		templates = new Point[]{
				new Point( 0, 0),
				new Point( 3, -100),
				new Point( 3, -160),
				new Point( 1, -200),
				new Point(12, -200),
				new Point(11, -160),
				new Point(11, -100),
				new Point(15, 0)
		};
		
		MathUtility.shift(templates, 30, 20); 
		MathUtility.scale(templates, templates[0], 0.3);
	}
	
	
	public Slinger(int _refX, int _refY){
		refX = _refX;
		refY = _refY;
		wagons = new Image[3];
		wagons[0] = new ImageIcon(Coordinator.RESOURCE_PATH + "wagon1_dust.png").getImage();
		wagons[1] = new ImageIcon(Coordinator.RESOURCE_PATH + "wagon2_dust.png").getImage();
		wagons[2] = new ImageIcon(Coordinator.RESOURCE_PATH + "wagon3_dust.png").getImage();
		
		path = new GeneralPath();
		slingPath = new GeneralPath();
		points = new Point[templates.length];
		for(int i=0; i<points.length; i++)  points[i] = new Point(0, 0);
		
	}
	
	
	public void move(){
		long currentTime = System.currentTimeMillis();
		if(currentTime>=nextTiltTime){
			x = refX + (int)(Math.random()*4);
			y = refY + (int)(Math.random()*6);
			imageIndex = (int)(Math.random()*3);
			nextTiltTime = currentTime + tiltInterval;
		}
	}
	
	
	private void preparePoints(){
		for(int i=0; i<points.length; i++){
			bendingFactor = (templates[i].y-templates[0].y)/(templates[3].y-templates[0].y);
			angle = stretchFactor*Math.pow(bendingFactor, 3);
			x1 = templates[i].x - templates[0].x;
			y1 = templates[i].y - templates[0].y;
			x2 = -x1*Math.cos(angle) - y1*Math.sin(angle);
			y2 =  y1*Math.cos(angle) - x1*Math.sin(angle);
			points[i].set(x2 + templates[0].x + x, y2 + templates[0].y + y);
		}
	}
	
	
	private void drawWeapon(Graphics2D canvas){
		preparePoints();
		canvas.setColor(weaponColor);
		path.reset();
		path.moveTo(points[0].x, points[0].y);
		path.curveTo(points[1].x, points[1].y, points[2].x, points[2].y, points[3].x, points[3].y);
		path.lineTo(points[4].x, points[4].y);
		path.curveTo(points[5].x, points[5].y, points[6].x, points[6].y, points[7].x, points[7].y);
		path.lineTo(points[0].x, points[0].y);
		canvas.fill(path);;
	}
	
	
	private void drawProjectile(DrawingBoard board){
		if(!shouldDrawProjectile) return;
		
		Graphics2D canvas = board.getCanvas();
		//draw the sling.
		slingPath.reset();
		slingPath.moveTo(points[indexOfWeaponTop].x, points[indexOfWeaponTop].y);
		slingPath.lineTo(points[indexOfWeaponTop].x + mouseActionScale*dx, points[indexOfWeaponTop].y + mouseActionScale*dy);
		 
		canvas.setColor(Color.darkGray);
		canvas.draw(slingPath);
		
		//draw the projectile.
		canvas.drawImage(Projectile.image, 
				         (int)(points[indexOfWeaponTop].x + mouseActionScale*dx - Projectile.RADIUS), 
				         (int)(points[indexOfWeaponTop].y + mouseActionScale*dy - Projectile.RADIUS),
				         board);
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		// draw the weapon
		drawWeapon(canvas);
		// draw the sling and the projectile
		drawProjectile(board);
		// draw the wagon.
		canvas.drawImage(wagons[imageIndex], x, y, board);
	}


	public void mousePressed(MouseEvent e) {
		mousePressedX = e.getX();
		mousePressedY = e.getY();
		dx = 0;
		dy = 0;
		shouldDrawProjectile = true;
	}
	
	
	public void mouseDragged(MouseEvent e) {
		dx = e.getX() - mousePressedX;
		dy = e.getY() - mousePressedY;
		
		if(dx<0) dx = 0;
		if(dy<0) dy = 0;
		
		dragDistance = Math.sqrt(dx*dx + dy*dy);
		stretchFactor = dragDistance/200;
		if(stretchFactor>1) stretchFactor = 1;
	}
	
	
	public void mouseReleased(MouseEvent e) {
		stretchFactor = 0;
		shouldDrawProjectile = false;
		// create a Projectile. 
		ProjectileManager.add(new Projectile(points[indexOfWeaponTop].x + mouseActionScale*dx, 
				       						 points[indexOfWeaponTop].y + mouseActionScale*dy,
				       						 -shootingStrength*dx,
				       						 -shootingStrength*dy));
	}
	
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
}







