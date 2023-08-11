public class Nest_If {
	public static void main(String args[]){
		int a=1, b=2, c=3;
		int largest;
	
		if (a>b){
			if (a>c){
				largest=a;
			}
			else {
				largest=c;
			}
		}
		else {
			if (b>c){
				largest=b;
			}
			else {
				largest=c;
			}
		}
		System.out.println("largest = " + largest);
	}
}
