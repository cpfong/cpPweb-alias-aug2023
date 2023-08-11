public class Ex513{
	public static void main(String[] args){
		Ex513 t = new Ex513();

		double i=10000, r=1.5;

		double res = t.fiveYearResult(i, r);	
		System.out.println("init: " + i +  " five year later: " + res);
	}
	private double fiveYearResult(double amount, double interest){
		return (amount*(1+interest/1000));
	}
}
