package jrJava.streaming;

import java.io.*;

public class TextReader {
	public static void main(String[] args) throws IOException {
		
		InputStream is = new FileInputStream("c:/temp/test1.txt");
		InputStreamReader isr = new InputStreamReader(is, "US-ASCII");
		BufferedReader br = new BufferedReader(isr);
		String line;
		
		while(true){
			line = br.readLine();
			if(line==null) break;
			System.out.print(line);
		}
		
		br.close();
		
	}

}
