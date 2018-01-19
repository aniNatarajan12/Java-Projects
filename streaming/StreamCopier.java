package jrJava.streaming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopier {

	public void copy(InputStream is, OutputStream os) throws IOException{
		
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
