import java.awt.*;
import java.io.*;

public class MultiLoadD {
	final double PI=3.14159;

	public static void main(String[] args){
		MultiLoadD m=new MultiLoadD();
		double in=0.0;

		System.out.println("radius:  ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Double.parseDouble(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		System.out.println("area = " + m.CircleArea(in));

		System.exit(0);
	}

	private int CircleArea(int r){ int res = (int)PI * r * r;  return res;}
	private double CircleArea(double r){ return (PI * r * r); }
}

