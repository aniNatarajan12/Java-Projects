package Sorting;

public class Ball implements Comparable{
	private int x,y;
	private int radius;
	private int r,g,b;
	
	public Ball(int _x, int _y, int _radius, int _r, int _g, int _b){
		x = _x;
		y = _y;
		radius = _radius;
		r = _r;
		g = _g;
		b = _b;
	}
	
	public String toString(){
		return "("+x+","+y+")("+radius+")("+r+","+g+","+b+")   ";
	}

	public int compareTo(Object o) {
		Ball tob = (Ball) o;
		if((radius>tob.radius) || 
				(radius==tob.radius && r+g+b>tob.r+tob.g+tob.b) || 
				(r+g+b==tob.r+tob.g+tob.b && x+y>tob.x + tob.y)) return 1;
		else if((radius<tob.radius) || 
				(radius==tob.radius && r+g+b<tob.r+tob.g+tob.b)|| 
				(r+g+b==tob.r+tob.g+tob.b && x+y<tob.x + tob.y)) return -1;
		return 0;
	}


}
