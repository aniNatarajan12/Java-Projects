package jrJava.Algorithm;

public class Practice1 {

	public static void main(String[] args) {
		doSomething(0,12);
	}

	public static void doSomething(int a,int b){
		a++;
		System.out.println(a);
		if(a>=b) return;
		doSomething(a,b);
		System.out.println(a);
	}
}
