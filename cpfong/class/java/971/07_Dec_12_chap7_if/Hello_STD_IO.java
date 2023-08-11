import java.awt.*;
import java.io.*;

public class Hello_STD_IO{
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

		switch(in){
			case 1:
				System.out.print("you have input: 1\n");
				break;
			case 2:
				System.out.print("you have input: 2\n");
				break;
		}
		System.exit(0);
	}
}
