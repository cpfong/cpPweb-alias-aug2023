import java.text.*;
import java.io.*;

public class SearchInt{
	public static void main(String args[]){
		System.out.println("input an int ");

		String in="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        try { 
        	in = br.readLine(); 
        } catch (IOException ioe) { 
        	System.out.println("IO error trying to read your name!"); 
        	System.exit(1); 
        } 

		int[] inta = { 2, 9, 8, 6, 7 };

		int i=0, inint;
		inint = Integer.parseInt(in);

		for (int n : inta){
			if ( inint == n){ 
            	System.out.println("" + inint + " located at " + i); 
            	System.exit(0); 
			}
			i++;
		}
		System.out.println("not Found");
	}
}
