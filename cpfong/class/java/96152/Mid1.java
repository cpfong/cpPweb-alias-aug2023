import java.awt.*;
import java.io.*;
import java.util.*;

public class Mid1{
        public static void main (String args[]){
                ArrayList list = new ArrayList();
                int in=0;

                for (int i=0; i<3; i++){
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        try {
                                in = Integer.parseInt(br.readLine());
                                list.add(""+in);
                        } catch (IOException ioe) {
                                System.out.println("IO error trying to read your name!");
                                System.exit(1);
                        }
                }
		String s; 
		int sum=0, t=0, i;
		for (i=0; i < list.size(); i++){
			s = "" + list.get(i);
			t = Integer.parseInt(s);
			sum += t;
		}
		System.out.println("tot is " + sum);
        }
}
