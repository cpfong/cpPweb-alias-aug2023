import java.io.*;

public class My_Own_Exception{
	public static void main(String args[]){
		String s="";
		My_Own_Exception m= new My_Own_Exception();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("pls input number");
			s=br.readLine();
		}
		catch (IOException e){
			System.out.println("Buffer Reader error");
			System.exit(1);
		}
		try {
			m.i_can_throw_exception(s);
		} 

		catch (NumberFormatException e){
			System.out.println("5 chars is inputed, pls change");
			System.exit(1);
		}
	}
 
	private void i_can_throw_exception(String s) throws NumberFormatException{
		if (s.length() == 5){
			throw new NumberFormatException();
		}

		else {
			System.out.println("ok, the input string length is not 5");
		}
	}
}
