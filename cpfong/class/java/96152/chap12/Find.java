import java.util.*;
import java.awt.*;
import java.io.*;

public class Find {
	public static void main(String args[]){
		ArrayList <Integer> list = new ArrayList <Integer>();

		int in=0;
		System.out.println("input 0-100");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		Random r = new Random();
		for (int i=0; i<50; i++){
			list.add(r.nextInt(101));
		}

		int c=0;
		for (Integer item : list){
			c++;
			if (item == in){
				System.out.println("Found " + in + " and index= " + c);
				System.exit(1); 
			}
		}
		System.out.println("not found");
	}
}
