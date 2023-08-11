import java.awt.*;
import java.io.*;

public class Test2{
	public static void main(String[] args){
		String in = new String("");
		System.out.println("play again");

      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = br.readLine(); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		for (;;){
			System.out.println("play again");
			if (in.equals("Yes")){
      				br = new BufferedReader(new InputStreamReader(System.in)); 
				try { 
					in = br.readLine(); 
				} catch (IOException ioe) { 
					System.out.println("IO error trying to read your name!"); 
					System.exit(1); 
				} 
				// next
			}
			else{
				break;
			}
		}
		System.exit(0);
	}
}

