import java.awt.*;
import java.io.*;
import java.util.*;

public class Chap144 {
	public static void main(String[] args){
		int in=0;

		int r,c;
		int m[][]=new int[2][2];

		System.out.println("input " + Integer.toString(m.length) + "x" + Integer.toString(m[0].length) + "number");

		for (r=0; r<m.length; r++){
			for (c=0; c<m[0].length; c++){
      				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				try { 
					in = Integer.parseInt(br.readLine()); 
					m[r][c]=in;
				} catch (IOException ioe) { 
				System.out.println("IO error trying to read your name!"); 
				System.exit(1); 
				} 
			}
		}
		System.out.println("after transfer:");
		for (r=0; r<m.length; r++){
			for (c=0; c<m[0].length; c++){
				System.out.print(""+m[c][r]+" ");
			}
			System.out.println("");
		}
		System.exit(0);
	}
}

