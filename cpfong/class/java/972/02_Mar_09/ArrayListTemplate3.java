import java.util.*;
import java.io.*;

public class ArrayListTemplate3{
	public static void main(String[] args){
		String s = "";
		ArrayList l = new ArrayList();

		System.out.println("what do you want to buy? ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			s = br.readLine(); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		l.add(s);l.add("grape");
/*		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
*/

		System.out.println("ok there are " + l.size() + " fruit and there are: ");
		String item;

		for (item : l){
			System.out.print(item + " ");
		}
		System.out.print("\n");
		
		System.exit(0);
	}
}
