import java.awt.*;
import java.io.*;

public class Input_Sec_Output_Hour_Min_Sec {
	public static void main(String[] args){

		int in=0, s, m, h;

		System.out.println("input secs: ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		h=in/3600;s=in%3600;
		m= s/60  ;s%=60;

		System.out.print("" + h + ":" + m + ":" + s + "\n");
		System.exit(0);
	}
}

