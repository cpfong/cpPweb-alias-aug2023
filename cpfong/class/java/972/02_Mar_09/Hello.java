import java.io.*;

public class Hello{
	public static void main(String[] args){
		int in=0;

		System.out.println("input int number: ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		System.out.println("ok, input " + in);
		System.exit(0);
	}
}

