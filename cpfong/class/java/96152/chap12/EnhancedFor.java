import java.awt.*;
import java.util.*;

public class EnhancedFor{
	public static void main(String[] args){
		ArrayList <Integer> list = new ArrayList<Integer>();
		int i;

		for (i=0; i<3; i++) {
			list.add(i+5); 
		}

		for (Integer xxx : list){
			System.out.print(""+ xxx + "\t");
		}

		System.exit(0);
	}
}

