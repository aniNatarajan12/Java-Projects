package jrJava.streaming;

import java.io.*;

public class TextWriter {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = new FileOutputStream("c:/temp/test1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
		PrintWriter pw = new PrintWriter(osw);
		
		pw.println("9");
		pw.println("+");
		pw.println("10");
		pw.println("=");
		pw.println("21");
		
		pw.flush();
		pw.close();
	}

}
