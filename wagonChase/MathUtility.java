package jrJava.wagonChase;


public class MathUtility {


	public static void shift(Point[] points, double xShift, double yShift){
		for(int i=0; i<points.length; i++){
			points[i].x = points[i].x + xShift;
			points[i].y = points[i].y + yShift;
		}
	}


	public static void scale(Point[] points, Point ref, double scaleFactor){
		for(int i=0; i<points.length; i++){
			points[i].x = ref.x + scaleFactor*(points[i].x - ref.x);
			points[i].y = ref.y + scaleFactor*(points[i].y - ref.y);
		}
	}

}
