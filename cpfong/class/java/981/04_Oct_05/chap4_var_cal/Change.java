import java.awt.*;
import java.io.*;

public class Change {
	public static void main(String[] args){
		int in=0;

		System.out.println("how many coins?");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		int f500, o100, f50, t10, f5;

		f500 = in / 500; in = in % 500; 
		o100 = in / 100; in = in % 100;
		f50  = in /  50; in = in %  50;
		t10  = in /  10; in = in %  10;
		f5   = in /   5; in = in %   5;

		System.out.println(	"500:" + f500 +
					"100:" + o100 + 
					" 50:" +  f50 + 
					" 10:" +  t10 + 
					"  5:" +   f5 + 
					"  1:" +   in); 
		System.exit(0);
	}
}
