package jrJava.wagonChase;


public class Point {

	public double x, y;
	
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	public void set(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	public void set(Point p){
		this.x = p.x;
		this.y = p.y;
	}
	
	
	public double distance(Point p){
		return Math.sqrt( (x-p.x)*(x-p.x) + (y-p.y)*(y-p.y) );
	}
}

