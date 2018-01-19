package jrJava.methodPractice;

public class Practice3 {

	public static void main(String[] args) {

		//calculateSum();
		//System.out.println(getSum(7,212,1));
		//System.out.println(getSum(1,1000,1));
		//System.out.println(getSum(111,999,2));

		int total = getSum(1,500) + getSum(501,1000);
		System.out.println(total);
		
		double a = 2.0/3*3;
		System.out.println(a);
	}

	/*private static void calculateSum(){
		int total=0;
		for(int i=7; i<=212; i++){
			total=total+i;
		}
		System.out.println(total);
	}*/

	private static int getSum(int begin,int end){
		return getSum(begin,end,1);
	}

	private static int getSum(int begin,int end,int increment){
		int total=0;
		for(int i=begin; i<=end; i=i+increment){
			total=total+i;
		}
		return total;
	}

	private static int getSquaredSum(int begin,int end,int increment){
		int total=0;
		for(int i=begin; i<=end; i=i+increment){
			total=total+i*i;
		}
		return total;
	}

}
