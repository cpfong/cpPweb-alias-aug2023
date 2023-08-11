import java.awt.*;
import java.io.*;

public class SwitchCase {
	public static void main(String[] args){
		int in=0;

		System.out.println("由 STDIO 輸入整數:  ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		switch (in){
			case 0:
			case 7: System.out.println("Sunday"   ); break;
			case 1: System.out.println("Monday"   ); break;
			case 2: System.out.println("Tuesday"  ); break;
			case 3: System.out.println("Wednesday"); break;
			case 4: System.out.println("Thursday" ); break;
			case 5: System.out.println("Triday"   ); break;
			case 6: System.out.println("Saturday" ); break;
		}
		System.exit(0);
	}
}

