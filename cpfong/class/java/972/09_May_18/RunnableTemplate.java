public class RunnableTemplate implements Runnable {
	String name="";

	public void run(){
 		System.out.println(this.name);
	}
	public RunnableTemplate(String s){name=s;}
}
