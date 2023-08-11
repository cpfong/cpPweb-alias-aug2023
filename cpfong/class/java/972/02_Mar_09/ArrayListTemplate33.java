import java.util.*;
import java.io.*;

public class ArrayListTemplate33{
	public static void main(String[] args){
		boolean b=true;
		int in=0;
		String s="";
		ArrayList l = new ArrayList();

		System.out.println("input all fruit until -1 to stop: ");

		while (b){
      			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			try { 
				s = br.readLine(); 
				if (s.equals("-1")){	
					b=false;
				}
				else {
					l.add(s);
				}
			} catch (IOException ioe) { 
				System.out.println("IO error trying to read your name!"); 
				System.exit(1); 
			} 
		} // end while	

		System.out.println("input #: ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		l.remove(in);
		for (int i=0; i<l.size(); i++){
			System.out.println("" + l.get(i));
		}
		System.exit(0);
	}
}
