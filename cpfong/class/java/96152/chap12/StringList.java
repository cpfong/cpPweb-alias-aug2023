import java.awt.*;
import java.util.*;

public class StringList{
	public static void main(String[] args){
		// note ArrayList cannot declare as int, double, stead you have to use Integer or Double

		ArrayList <String> list = new ArrayList<String>();
		list.add("milk"); 
		list.add("bread"); 
		list.add("coffee");

		int i;
		for (i=0; i<list.size(); i++){
			System.out.print(list.get(i) + "\t");
		}
		System.exit(0);
	}
}

