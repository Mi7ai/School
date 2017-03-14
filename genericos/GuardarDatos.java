package genericos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collection;

public class GuardarDatos<E> {
	public boolean appendData(Collection<E> co){
		
		PrintWriter outputStream = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			outputStream = new PrintWriter(new FileOutputStream("datos.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file");
			System.exit(0);
		}
		//append into file
		
		
		outputStream.close();
		
		return false;
		
	}
	
	public static void main(String[] args) {

	}

}
