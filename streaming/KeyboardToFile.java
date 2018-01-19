package jrJava.streaming;

import java.io.*;

public class KeyboardToFile {

	public static void main(String[] args) throws IOException{
		
		System.out.println("Type in your diary: ");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream os = new FileOutputStream("jrJava/Streaming/diary.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
		
		String line;
		
		while(true){
			line = br.readLine();
			if(line==null || line.length() == 0) break;
			pw.println(line);
		}
		
		br.close();
		pw.flush();
		br.close();
		
	}

}
