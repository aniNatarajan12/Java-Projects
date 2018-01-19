package jrJava.wagonChase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import resources.DrawingBoard;


public class Heart implements MouseListener, MouseMotionListener {

	private Point[] refPoints, points;
	private GeneralPath path;
	private Color color;
	private int x, y;
	private Point pressed, current;
	
	
	public Heart(int x, int y, double scale, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
		
		refPoints = new Point[]{
				new Point( 0,     0),
				new Point(-0.02, -0.13),
				new Point(-0.25, -0.13),
				new Point(-0.25,  0.07),
				new Point(-0.25,  0.25),
				new Point( 0,     0.27),
				new Point( 0,     0.42),
				new Point( 0,     0),
				new Point( 0.02, -0.13),
				new Point( 0.25, -0.13),
				new Point( 0.25,  0.07),
				new Point( 0.25,  0.25),
				new Point( 0,     0.27),
				new Point( 0,     0.42),	
		};
		
		MathUtility.shift(refPoints, x, y);
		MathUtility.scale(refPoints, refPoints[0], scale); 
		
		points = new Point[refPoints.length];
		for(int i=0; i<points.length; i++){
			points[i] = new Point(refPoints[i].x, refPoints[i].y);
		}
		//points = refPoints.clone(); // can't do this because it's a shallow copying.
		
		
		path = new GeneralPath();
		
		pressed = new Point(0, 0);
		current = new Point(0, 0);
	}
	
	
	public void draw(DrawingBoard board){
		Graphics2D canvas = board.getCanvas();
		path.reset();
		path.moveTo(points[0].x, points[0].y);
		path.curveTo(points[1].x, points[1].y, points[2].x, points[2].y, points[3].x, points[3].y);
		path.curveTo(points[4].x, points[4].y, points[5].x, points[5].y, points[6].x, points[6].y);
		path.moveTo(points[7].x, points[7].y);
		path.curveTo(points[8].x, points[8].y, points[9].x, points[9].y, points[10].x, points[10].y);
		path.curveTo(points[11].x, points[11].y, points[12].x, points[12].y, points[13].x, points[13].y);
		
		canvas.setColor(color);
		canvas.fill(path);
	}

	public void mousePressed(MouseEvent e) {
		pressed.set(e.getX(), e.getY());
	}
	
	
	public void mouseDragged(MouseEvent e) {
		current.set(e.getX(), e.getY());
		double stretchX = (current.x-pressed.x)/100;
		double stretchY = (current.y-pressed.y)/100;

		for(int i=0; i<points.length; i++){
			points[i].x = refPoints[0].x + (1+stretchX)*(refPoints[i].x-refPoints[0].x);
			points[i].y = refPoints[0].y + (1+stretchY)*(refPoints[i].y-refPoints[0].y);
		}
	}
	
	
	public void mouseReleased(MouseEvent e) {
		for(int i=0; i<points.length; i++){
			points[i].set(refPoints[i]); 
		}
	}
	
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	
}







