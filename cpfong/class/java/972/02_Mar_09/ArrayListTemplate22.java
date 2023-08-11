import java.util.*;
import java.io.*;

public class ArrayListTemplate22{
	public static void main(String[] args){
		ArrayList l = new ArrayList();

		l.add("apple"); l.add("grape"); l.add("pine apple"); l.add("banana"); l.add("pear");
		for (int i=1; i<=l.size(); i++){
			System.out.println("Fruit "+ i + " is " + l.get(i-1));
		}
		System.exit(0);
	}
}
