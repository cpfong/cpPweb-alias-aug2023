/*
32. ½Ò¥» 5-30 ­¶ ²ßÃD 5.7
*/
import java.awt.*;
import java.io.*;

public class Mid9451 {
	public static void main(String[] args){
		Mid9451 t = new Mid9451();

		double d = t.inchEquivalent(10.5);
		System.out.println(" 10.5cm = " + d + " inches");
		System.exit(0);
	}
	private double inchEquivalent(double cm){
		return (0.394*cm);
	}
}

