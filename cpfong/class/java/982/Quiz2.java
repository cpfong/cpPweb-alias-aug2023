import java.io.*;
import java.util.*;

public class Quiz2{
	public static void main(String args[]){
		String l;
		BufferedReader f;
		String t;

		try {
			f = new BufferedReader(new FileReader("file1.txt"));
			while ((l=f.readLine()) != null){
				StringTokenizer data=new StringTokenizer(l, ",");
				int b=Integer.parseInt(data.nextToken());
				int e=Integer.parseInt(data.nextToken());
				System.out.println("" + b + "^" + e + "=" + Math.pow(b,e));
			}
			f.close();
		} catch (IOException e){
			System.out.println("error");
		}
	}
}
