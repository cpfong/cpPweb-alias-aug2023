public class str_misc{
	public static void main(String args[]){
		String s	= new String("hello world");
		char arr[]	= {'a', 'b', 'c', 'd', 'e'};
		String o	= "";

		System.out.println(s.length() );
		System.out.println(s.charAt(0));
		System.out.println(arr.length );

		String sp = new String(arr,0,arr.length);
		System.out.println(sp.length());

		for (int i = sp.length()-1; i >= 0; i--){
			o += sp.charAt(i);
		}
		System.out.println(o);
	}
}
