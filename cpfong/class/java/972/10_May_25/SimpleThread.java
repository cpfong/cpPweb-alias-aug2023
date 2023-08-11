public class SimpleThread extends Thread{
	public SimpleThread(String s){ super(s); }
	public void run(){
		int i;

		for (i=0; i<10; i++){
			System.out.println("" + i + this.getName());
/*
			try {
				sleep((int)Math.random()*1000);
			}
			catch (InterruptedException e){}
*/
		}
	}	
}

