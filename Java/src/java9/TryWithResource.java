package java9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResource {

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream file = new FileOutputStream("E:\\Java\\Eclipse\\Resource\\javatpoint.txt");
		// Java 7 --> try(FileOutputStream file = new FileOutputStream("E:\\Java\\Eclipse\\Resource\\javatpoint.txt");)
		try(file){
			file.write("Java 9 supports try with resource in unique way".getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
