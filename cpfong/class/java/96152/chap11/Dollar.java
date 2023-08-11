import java.awt.*;

public class Dollar{
	public static void main(String[] args){
		double f=127.2341;
		int d=(int) f;
		int c=(int) Math.round(100*(f-d));

		System.out.println("" + d);
		System.out.println("" + c);
	

		System.exit(0);
	}
}
