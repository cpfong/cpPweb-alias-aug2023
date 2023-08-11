public class str_char_test{
	public static void main(String args[]){
		char arr[]	= { 'c', 'h', 'a', 'r', '_', 'a', 'r', 'r', ' ', 'a', '[', ']' };		
		String  s	= new String("I am s which is a string");
		StringBuffer sb	= new StringBuffer("I am stringbuffer name by sb");

		System.out.println(s);
		System.out.println(sb);
		System.out.println(arr);
		System.out.println(arr[0]);

		// character arrry you can use String to reorganize it
		String pa = new String(arr, 0, 4);
		System.out.println(pa);

	}
}
