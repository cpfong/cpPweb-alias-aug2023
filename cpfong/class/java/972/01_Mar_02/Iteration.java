public class Iteration{
	public static void main(String[] args){
		double d=0.0;

		Iteration i=new Iteration();
		d=i.mysin(2.1);
		System.out.println("return value: "+ d);
		System.out.println("using math:   "+ Math.sin(2.1));
		System.exit(0);
	}
	private double mysin(double x){
		double term, result;
		result=0.0;
		term=x;
		for (int n=1; Math.abs(term)>=0.0001; n+=2){
			result += term;
			term = -term*x*x/((n+1)*(n+2));
		}
		return result;
	}
}

