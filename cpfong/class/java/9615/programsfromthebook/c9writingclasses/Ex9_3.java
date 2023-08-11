import java.awt.*;

public class Ex9_3 {

	private int cur;

	public void Ex9_3(){
		cur = 0;
	}

	public void deposit (int t) { cur += t; }
	public void withdraw(int t) { cur -= t; }
	public void setCurrentBalance(int t) { cur = t; }
	public int  getCurrentBalance() { return cur; }
}
