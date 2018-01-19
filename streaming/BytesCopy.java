package jrJava.streaming;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BytesCopy {

	public static void main(String[] args) throws IOException{
		copy("c:/temp/add.html" , "c:/temp2/addition.html");
	}

	public static void copy(String source, String destination) throws IOException{

		InputStream is = new FileInputStream(source);
		OutputStream os = new FileOutputStream(destination);

		byte[] bucket = new byte[500];

		while(true){
			int read = is.read(bucket);
			if(read<=0) break;
			os.write(bucket, 0, read);
		}

		is.close();
		os.flush();
		os.close();

	}

}








