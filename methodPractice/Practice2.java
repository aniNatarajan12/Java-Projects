package jrJava.methodPractice;

public class Practice2 {

	public static void main(String[] args) {
		myFavoriteMethod(5.0,5);
	}
	
	private static void myFavoriteMethod(){
		System.out.println("1");
	}
	
	private static void myFavoriteMethod(int a){
		System.out.println("2");
	}
	
	private static void myFavoriteMethod(double a){
		System.out.println("3");
	}
	
	private static void myFavoriteMethod(int a,int b){
		System.out.println("4");
	}
	
	private static void myFavoriteMethod(int a,double b){
		System.out.println("5");
	}
	
	private static void myFavoriteMethod(double a,int b){
		System.out.println("6");
	}
	
	private static void myFavoriteMethod(double a,double b){
		System.out.println("7");
	}

}
