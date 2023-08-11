import java.awt.*;
import java.io.*;

public class AddOverLoading{
	public static void main(String[] args){

		int in=0;

		System.out.println("please input a integer:");

      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		System.out.print("you have input: " + in + "\n");
		System.exit(0);
	}
}
