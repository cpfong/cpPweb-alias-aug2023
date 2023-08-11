import java.util.*;
import java.awt.*;
import java.io.*;

public class Query {
	public static void main(String args[]){
		ArrayList <String> months = new ArrayList <String>();

		months.add("xxxx");
		months.add("一月");
		months.add("二月");
		months.add("三月");
		months.add("四月");
		months.add("五月");
		months.add("六月");

		int in=0;
		System.out.println("input 1-6");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		System.out.println("" + in + " --> " + months.get(in));
	}
}
