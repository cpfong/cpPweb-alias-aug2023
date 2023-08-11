import java.awt.*;
import java.io.*;
public class Vending_Machine {
	public static void main(String[] args){
		int price, in, change;
		int a,b,c,d,e,f;

		Vending_Machine v = new Vending_Machine();
		System.out.println("請告知商品價格:  "); price=v.read_in();
		System.out.println("請告知投幣金額:  "); in   =v.read_in();

		change = in - price;
		a = change / 50; change %= 50;
		b = change / 20; change %= 20;
		c = change / 10; change %= 10;
		d = change /  5; change %=  5;
		e = change /  2; change %=  2;
		f = change;
		System.out.println("Number of 50 cent coins is " + a ); 
		System.out.println("Number of 20 cent coins is " + b ); 
		System.out.println("Number of 10 cent coins is " + c ); 
		System.out.println("Number of  5 cent coins is " + d ); 
		System.out.println("Number of  2 cent coins is " + e ); 
		System.out.println("Number of  1 cent coins is " + f ); 
		
		System.exit(0);
	}
	private int read_in(){
		int in_put=0;
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in_put = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 
		return in_put;
	}
}

