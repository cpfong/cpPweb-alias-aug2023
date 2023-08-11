import java.awt.*;
import java.util.*;

public class IntegerList{
	public static void main(String[] args){
		// this one does not work, you have to use Integer, Double
		//ArrayList <int> list = new ArrayList<int>();
		ArrayList <Integer> list = new ArrayList<Integer>();
		list.add(1); 

		int i;
		for (i=0; i<list.size(); i++){
			System.out.print(list.get(i) + "\n");
		}
		System.exit(0);
	}
}

