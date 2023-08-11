/*
33. ½Ò¥» 5-31 ­¶ ²ßÃD 5.10
*/
import java.awt.*;
import java.io.*;

public class Mid9453 {
	public static void main(String[] args){
		Mid9453 t = new Mid9453();

		int d = t.secsIn(1,1,2);
		System.out.println(" 1h 1m 2s = " + d + " secs");
		System.exit(0);
	}
	private int secsIn(int h, int m, int s){
		return (3600*h+60*m+s);
	}
}

