public class test2_3 extends Object {
	private int i;

	public test2_3(){ // constructor
	}

	public String xxx (){
		i = 1;
		return "i = " + i;
	}

	public static void main(String a[]){
		test2_3 nnn = new test2_3();
		System.out.println(nnn.xxx());
	}
}

