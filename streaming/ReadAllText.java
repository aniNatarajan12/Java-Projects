package jrJava.streaming;
import java.io.*;

public class ReadAllText {

	public static void main(String[] args) throws IOException{
		
		ReadAllText reader = new ReadAllText();
		String reply = reader.readAll(new FileInputStream("c:/temp/test1.txt"));
		System.out.println(reply);

	}

	public String readAll(InputStream is){

		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		String line;

		try{
			while(true){
				line = br.readLine();
				if(line==null) break;
				sb.append(line);
				sb.append(" ");
			}
			br.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return sb.toString();
	}

}
