import java.util.*;

public class AnimalTemplate {
	public static void main(String args[]){
		Cow daisy = new Cow();
		Snake sid = new Snake();
		Pig wilbur= new Pig();
		
		ArrayList list = new ArrayList();
		list.add(daisy);
		list.add(sid);
		list.add(wilbur);

		Animal any = (Animal)list.get(0);
		System.out.println("the cow says " + any.says());
	} 
}
