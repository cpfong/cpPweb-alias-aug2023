import java.awt.*;
public class OverLoading {
	public static void main(String[] args){
	  	OverLoading o = new OverLoading();
		int bi=8, hi=6;
		double bd= 8.0, hd=6.0;
	
		int    a=o.areaTriangle(bi, hi);
		double b=o.areaTriangle(bd, hd);
		double c=o.areaTriangle(bd, hd,0.7);

		System.out.println("a=" + a);	
		System.out.println("b=" + b);	
		System.out.println("c=" + c);	
	}
	private int    areaTriangle(int    b , int h   ){ return (b * h)/2;    }
	private double areaTriangle(double b , double h){ return (b * h) * 0.5;}
	private double areaTriangle(double s1, double s2, double an){return 0.5+s1*s2*Math.sin(an);}
} // end class
