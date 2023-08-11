public class Ex510{
	public static void main(String[] args){
		Ex510 t = new Ex510();

		int r = t.totalSecs(0,1,0);	
		System.out.println("" + r);
	}
	private int totalSecs(int h, int m, int s){
		return (h*60*60 + m*60 + s);
	}
}
