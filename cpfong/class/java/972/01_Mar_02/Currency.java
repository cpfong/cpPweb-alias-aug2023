import java.io.*;

public class Currency{
	public static void main(String[] args){
		double in=0.0;
		int dollars,cents;

		System.out.println("input floating number: ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Double.parseDouble(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		dollars=(int)in;
		cents=(int) Math.round(100 * (in-dollars));

		System.out.println("ok, input " + dollars + " dollars " + cents + " cents");
		System.exit(0);
	}
}

