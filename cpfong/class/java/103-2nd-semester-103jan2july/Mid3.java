import java.awt.*;
import java.io.*;
import java.util.*;

public class Mid3{
        public static void main (String args[]){
		  		String in = "";

                System.out.println("input integer or double : ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                                in=br.readLine();
                } catch (IOException ioe) {
                                System.out.println("IO error trying to read your name!");
                                System.exit(1);
                }

                int i = in.indexOf('.',0);
				if (i == -1){
					System.out.println("Integer");
				}
				else{
					System.out.println("Floating");
				}
        }
}
