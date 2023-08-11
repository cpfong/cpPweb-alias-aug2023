public class ThreadMain {
	public static void main (String args[]){

		MyThread t1= new MyThread(); t1.setName("t1");
		MyThread t2= new MyThread(); t2.setName("t2");
		RunnableTemplate t3=new RunnableTemplate("t3"); 

		System.out.println("start");
		t1.start(); 		// 1st thread
		t2.start(); 		// 2nd thread
		new Thread(t3).start(); // 3rd thread
	}
}
