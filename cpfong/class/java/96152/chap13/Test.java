import java.text.*;
import java.io.*;

public class Test{
	public static void main(String args[]){
		System.out.println("input name: ");

		String in="";
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
                try { 
                        in = br.readLine(); 
                } catch (IOException ioe) { 
                        System.out.println("IO error trying to read your name!"); 
                        System.exit(1); 
                } 

		String[] name   = { "Alex", "Megan", "John", "END" };
		String[] number = { "111", "222", "333" };

		int i=0;
		for (String xxx : name){
			if (in.equals(xxx)){ 
                        	System.out.println("" + in + " -> " + number[i]); 
                        	System.exit(0); 
			}
			i++;
		}
		System.out.println("not Found");
	}
}
