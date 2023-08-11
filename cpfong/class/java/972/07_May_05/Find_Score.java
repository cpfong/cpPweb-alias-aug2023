import java.io.*;
import java.util.*;

public class Find_Score{
	public static void main(String args[]){
		String l, in;
		BufferedReader f;
		boolean found=false;
		Find_Score t = new Find_Score();
                System.out.println("input sid: ");
		in = t.r();

		try {
			f = new BufferedReader(new FileReader("abc.txt"));

			while (((l=f.readLine()) != null) && (!found)){
				StringTokenizer tokens = new StringTokenizer(l, " ");
				tokens.nextToken();
				String name= tokens.nextToken();
				if (name.equals(in)){
					found = true;
					System.out.println(name + " " + tokens.nextToken() + " " + tokens.nextToken());
				} 
			}
			f.close();
		} catch (IOException e){
			System.out.println("error");
		}
	}

	private String r(){
		String in="";
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
                try { 
                        in = br.readLine(); 
                } catch (IOException ioe) { 
                        System.out.println("IO error trying to read your name!"); 
                        System.exit(1); 
                } 
		return in;
	}
}

