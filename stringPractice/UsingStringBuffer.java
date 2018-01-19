package jrJava.stringPractice;

public class UsingStringBuffer {

	public static void main(String[] args) {
		
	//	String msg = "43," + "29," + "55," + "91," + "72";
		
		StringBuffer sb = new StringBuffer();
		sb.append("43");
		sb.append(",");
		sb.append("29");
		sb.append(",");
		sb.append("55");
		sb.append(",");
		sb.append("91");
		sb.append(",");
		sb.append("72");
		String msg = sb.toString();
		
		System.out.println(msg);
		
		
	}

}
