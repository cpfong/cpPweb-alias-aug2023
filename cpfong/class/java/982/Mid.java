import java.awt.*;
import java.io.*;
import java.util.*;

public class Mid{
        public static void main (String args[]){
		Mid m= new Mid();

                ArrayList <String>  list = new ArrayList <String> ();
                int in=0, sum=0, n=0;

                System.out.println("how many number: ");

		n=m.getNumber();

                for (int i=0; i<n; i++){
			list.add(""+m.getNumber());
                }

                for (String item : list){
                        in = Integer.parseInt(item);
                        sum += in;
                }       
                System.out.println("Totoal is " + sum);
        }

	private int getNumber(){
		int i=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               	try {
               		i = Integer.parseInt(br.readLine());
               	} catch (IOException ioe) {
               		System.out.println("IO error trying to read your name!");
               		System.exit(1);
               	}
		return i;
	}
}
