import java.io.*;
import java.text.DecimalFormat;

public class DecimalTemplate{
	public static void main(String[] args){
		DecimalFormat f = new DecimalFormat("0.###E0");
		double in=0.0;

		System.out.println("input floating number: ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Double.parseDouble(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read from stdin!"); 
			System.exit(1); 
		} 

		System.out.println("ok, input " + f.format(in));
		System.exit(0);
	}
}

