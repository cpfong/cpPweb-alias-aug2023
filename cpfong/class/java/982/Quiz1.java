import java.awt.*;
import java.io.*;

public class Quiz1{
	public static void main(String args[]){

		int area;
		int in=0, b=0, c=0;
		Quiz1 m = new Quiz1();
		System.out.println("input side:");

      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 


                try {
                        m.i_can_throw_exception(in, b);
                } 

                catch (MyOwnException e){
                        System.out.println("no minus number!! pls input plus number");
                        System.exit(1);
                }
	} 

        private void i_can_throw_exception(int i, int j) throws MyOwnException {
                if (i < 0){
                        throw new MyOwnException("xxxx");
                }

                else {
                        System.out.println("ok, area is " + (i * i));
                }
        }

} // end of class
