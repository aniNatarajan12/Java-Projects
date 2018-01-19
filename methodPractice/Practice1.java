package jrJava.methodPractice;

public class Practice1 {

	public static void main(String[] args) {

		System.out.println("point1");
		MyFirstMethod();
		MySecondMethod();
		System.out.println("point2");

	}
	
	
	
	public static void MyFirstMethod(){
		MySecondMethod();
		System.out.println("point5");
	}
	
	public static void MySecondMethod(){
		System.out.println("point4");
	}

}
