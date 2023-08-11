public class str_val_intern{
	public static void main(String args[]){
		char arr[]={ 'a', 'r', 'r' };
		int i = 1;
		float f = 1.1f;

		System.out.println(arr);
		System.out.println(String.valueOf(i));
		System.out.println(String.valueOf(f));

		// intern 可以比較二字串
		String s1 = " test";
		String s2 = "test";
		if (s1.intern() == s2.intern()) { System.out.println("same"); }
		else { System.out.println("diff"); }
	}
}
