public class Chap5_ex510{
	public static void main(String argv[]){
		Chap5_ex510 t = new Chap5_ex510();

		int totalSecs=t.secsIn(1,1,2);
		System.out.println("sec = " + totalSecs);
	}

	private int secsIn(int h, int m, int s){
		return (h*3600+m*60+s);
	}
}
