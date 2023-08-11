import java.io.*;

public class ThrowMyOwnException{
	public static void main(String args[]){
		String s="";
		ThrowMyOwnException m= new ThrowMyOwnException();
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

		catch (MyOwnException e){
			System.out.println("5 chars is inputed, pls change");
			System.exit(1);
		}
	}
 
	private void i_can_throw_exception(String s) throws MyOwnException {
		if (s.length() == 5){
			throw new MyOwnException("xxxx");
		}

		else {
			System.out.println("ok, the input string length is not 5");
		}
	}


	public class MyOwnException extends Exception {
		public MyOwnException(){}
		public MyOwnException(String txt) {
			super(txt);
		}
	}
}
