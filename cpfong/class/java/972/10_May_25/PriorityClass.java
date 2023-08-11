public class PriorityClass extends Thread{
	public PriorityClass(String s){ super(s); }
	public void run(){
		int i;

		for (i=0; i<5; i++){
			System.out.println("" + i + this.getName() + "pri=" + this.getPriority());
			if ((this.getName()).equals("Wong")){ this.yield(); }
			try {
				sleep((int)Math.random()*1000);
			}
			catch (InterruptedException e){}
		}
	}	
}

