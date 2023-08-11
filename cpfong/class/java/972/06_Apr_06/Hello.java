import java.io.*;

public class Hello{
	public static void main(String[] args){
		String s="";
		int in=0;

		System.out.println("input int number: ");
      	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		try { s=br.readLine(); } 
		catch (IOException e){ 
		  	System.out.println("ioception"); 
			System.exit(1);
		}

		try { in = Integer.parseInt(s); } 
		catch (NumberFormatException e){
			System.out.println("format is not right");
            System.exit(2); 
		}

		System.out.println("ok, input " + in);
		System.exit(0);
	}
}

