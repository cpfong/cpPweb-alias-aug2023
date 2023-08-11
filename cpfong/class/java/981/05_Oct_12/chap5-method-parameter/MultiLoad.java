import java.awt.*;
import java.io.*;

public class MultiLoad {
	final double PI=3.14159;

	public static void main(String[] args){
		MultiLoad m=new MultiLoad();
		int in=0;

		System.out.println("radius:  ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
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

