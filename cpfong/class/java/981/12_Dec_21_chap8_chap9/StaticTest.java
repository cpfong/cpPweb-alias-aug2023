public class StaticTest{
	private static int i=0;
	private void method1(){
		int j=0;
		i++; 
		j++;
		System.out.println("i=" + i + " j=" + j);
	}
	public static void main(String args[]){
		StaticTest t = new StaticTest();
		t.method1(); t.method1();
	}
}
