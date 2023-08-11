public class hash_test{
	public static void main(String arg[]){
		String s1 = "this is a test ";
		String s2 = "this is a test";

		if (s1 == s2)	{ System.out.println("equal"); }
		else 		{ System.out.println("not equal"); }

		int h1 = s1.hashCode(); int h2 = s2.hashCode();
		if (h1 == h2)	{ System.out.println("hash equal"); }
		else 		{ System.out.println("not equal in hash"); }

	}
}
