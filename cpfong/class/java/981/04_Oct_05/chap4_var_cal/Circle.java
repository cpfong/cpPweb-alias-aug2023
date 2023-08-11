import java.awt.*;
import java.io.*;

public class Circle {
	public static void main(String[] args){
		final double pi=3.14159;
		double radius=0.0;

		System.out.println("input radius: ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			radius = Double.parseDouble(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		System.out.println("radius:" + radius + "\narea" + (pi * radius * radius));
		System.exit(0);
	}
}

