import java.awt.*;
import java.io.*;
import java.util.*;

public class Month{
	public static void main(String[] args){

		int in=0;
		System.out.println("pls input integer: ");

      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		ArrayList <String> list =  new ArrayList <String>();
		list.add("xxx"); list.add("Jan"); list.add("Feb"); list.add("Mar");
		list.add("Apr"); list.add("May"); list.add("Jun"); list.add("Jul");
		list.add("Aug"); list.add("Sep"); list.add("Oct"); list.add("Nov"); list.add("Dec");

		if (in > 0 && in < 13){
			System.out.println("" + in + " --> " + list.get(in));
		}
		else {
			System.out.println("" + in + " --> " + "Invalid");
		}
		System.exit(0);
	}
}
