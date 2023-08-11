import java.awt.*;
import java.io.*;

public class Test{
	public static void main(String[] args){
		double in=0;

		System.out.println("input number");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Double.parseDouble(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		System.out.println("ok you input: " + in);
		System.exit(0);
	}
}

