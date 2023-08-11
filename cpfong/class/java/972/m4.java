import java.io.*;

public class m4 {
	public static void main(String args[]){
		String s="";
		m4 m= new m4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("pls input string");
			s=br.readLine();
		}
		catch (IOException e){
			System.out.println("Buffer Reader error");
			System.exit(1);
		}
		try {
			m.i_can_throw_exception(s);
		} 

		catch (MyOwnException e){
			System.out.println("exception is inputed, pls change");
			System.exit(1);
		}
	}
 
	private void i_can_throw_exception(String s) throws MyOwnException {
		if (s.equals("exception")){
			throw new MyOwnException("except");
		}

		else {
			System.out.println("ok, the input string length is " + s);
		}
	}

	public class MyOwnException extends Exception {
		public MyOwnException(){}
		public MyOwnException(String txt) {
			super(txt);
		}
	}
}
