import java.util.*;
import java.io.*;

public class ArrayListTemplate{
	public static void main(String[] args){
		String s = "";
		ArrayList l = new ArrayList();

		System.out.println("what do you want to buy? ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			s = br.readLine(); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		l.add(s);l.add("grape");
		System.out.println("ok, size of arraylist " + l.size());
		
		System.exit(0);
	}
}
