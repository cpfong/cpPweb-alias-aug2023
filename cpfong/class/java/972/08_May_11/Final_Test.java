public class Final_Test{
	public static void main(String args[]){
		final double taxRate=17.5;
		double x;

		// taxRate = 18.5;
		x = (1+taxRate/100) * 1980;
		System.out.println("total plus tax is " + x);
	}
}
