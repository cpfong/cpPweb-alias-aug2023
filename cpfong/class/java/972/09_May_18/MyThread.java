public class MyThread extends Thread{

	String threadName="";
	final int big=999;
	boolean keepGoing=true;
	// public MyThread(String name){ this.threadName=name; }
	public MyThread(){ }

	public void run(){
		int i=0,j=0,k=0;
		for (i=0; i<big; i++){
			for (j=0; j<big; j++){
				for (k=0;k<big; k++){
				}
			}
			if ( i%100==0 ){
				// System.out.println(threadName);
				System.out.println(this.getName() + " " + this.toString());
			}
		}
	} // end run
}
