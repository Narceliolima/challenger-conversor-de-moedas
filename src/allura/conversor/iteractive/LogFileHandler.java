package allura.conversor.iteractive;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogFileHandler {
	
	private BufferedWriter bufferWritter = null;
	
	public LogFileHandler(String fileName) {
		
		try {
			bufferWritter = new BufferedWriter(new FileWriter(fileName,true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileDataWritter(String data) {
		
		try {
			bufferWritter.append(new Date()+" "+data+"\n");
			bufferWritter.flush();
			bufferWritter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
