import java.io.*;

public class Hello_cannot_compile{
	public static void main(String[] args){
		int in=0;

		System.out.println("input int number: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		in = Integer.parseInt(br.readLine()); 
		System.out.println("ok, input " + in);
		System.exit(0);
	}
}

