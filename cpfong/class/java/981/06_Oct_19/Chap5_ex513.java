public class Chap5_ex513{
	public static void main(String argv[]){
		Chap5_ex513 t = new Chap5_ex513();

		double total = t.fiveYearResult(1000, 1.5);
		System.out.println("amount = " + total);
	}

	private double fiveYearResult(double start, double interest){
		int i;
		double a=start;

		for (i=0; i<5; i++){
			a = a * (1+interest/100);
		}
		return a;
	}
}
