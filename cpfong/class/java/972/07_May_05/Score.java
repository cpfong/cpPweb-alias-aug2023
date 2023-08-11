import java.io.*;
import java.util.*;

public class Score{
	public static void main(String args[]){
		String l;
		BufferedReader f;
		double d=0.0;
		int i=0,j=0,k=0;
		String name="";

		boolean found=false;
		try {
			f = new BufferedReader(new FileReader("s.data"));

			while (((l=f.readLine()) != null) && (!found)){
				StringTokenizer tokens = new StringTokenizer(l, " ,");
				name= tokens.nextToken();
				if (name.equals("961506103")){
					found = true;
					i=Integer.parseInt(tokens.nextToken());
					j=Integer.parseInt(tokens.nextToken()); 
					k=Integer.parseInt(tokens.nextToken());
					d = (i + j + k)/3;
				} 
			}
			f.close();
		} catch (IOException e){
			System.out.println("error");
			System.exit(1);
		}
		System.out.println(name + " = " + d);
	}
}
