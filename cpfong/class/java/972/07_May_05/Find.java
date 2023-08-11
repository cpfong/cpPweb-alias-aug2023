import java.io.*;
import java.util.*;

public class Find{
	public static void main(String args[]){
		String l;
		BufferedReader f;

		boolean found=false;
		try {
			f = new BufferedReader(new FileReader("find.data"));

			while (((l=f.readLine()) != null) && (!found)){
				StringTokenizer tokens = new StringTokenizer(l, " ,");
				String name= tokens.nextToken();
				if (name.equals("john")){
					found = true;
					System.out.println(tokens.nextToken() + " " + tokens.nextToken());
				} 
			}
			f.close();
		} catch (IOException e){
			System.out.println("error");
		}
	}
}
