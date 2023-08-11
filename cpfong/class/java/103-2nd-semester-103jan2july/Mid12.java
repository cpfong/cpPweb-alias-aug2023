import java.awt.*;
import java.io.*;
import java.util.*;

public class Mid12{
        public static void main (String args[]){
                int[] list = new int[3];
                int i, in=0, sum=0;

                System.out.println("input 3 number: ");
                for (i=0; i<3; i++){
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        try {
                                in = Integer.parseInt(br.readLine());
                                list[i]=in;
                        } catch (IOException ioe) {
                                System.out.println("IO error trying to read your name!");
                                System.exit(1);
                        }
                }

                for (i=0; i< list.length; i++){
                        sum += list[i];
                }       
                System.out.println("Totoal is " + sum);
        }
}
