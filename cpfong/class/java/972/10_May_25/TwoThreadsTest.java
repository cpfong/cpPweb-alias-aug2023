public class TwoThreadsTest{
	public static void main(String args[]){
		SimpleThread t1 = new SimpleThread("John");
		SimpleThread t2 = new SimpleThread("Mary");
		t1.start();
		t2.start();
	}
}
