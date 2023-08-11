public class Chap5_ex515{
	public static void main(String argv[]){
		Chap5_ex515 t = new Chap5_ex515();

		int totalSecs=t.secsIn(1,1,2);
		System.out.println("sec = " + totalSecs);

		totalSecs=t.secsIn(1,2);
		System.out.println("sec = " + totalSecs);
	}

	private int secsIn(int h, int m, int s){ return (h*3600+m*60+s); }
	private int secsIn(       int m, int s){ return (       m*60+s); }
}
