package jrJava.stringPractice;

import java.util.StringTokenizer;

public class UsingStringTokenizer {

	public static void main(String[] args) {

		String msg = "43,29$55,91#92";

		StringTokenizer st = new StringTokenizer(msg,",$#");

		String token;

		int sum = 0;

		while(st.hasMoreTokens()){
			token = st.nextToken();
			System.out.println(token);
			
			int value = Integer.parseInt(token);
			sum += value;
		}
		
		System.out.print(sum);
	}

}

