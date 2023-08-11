import java.util.Calendar;

public class Ex9_6 {
	// private int seed;

	public void Ex9_6(){
	//	seed = 1;
	}

	public int getRandom(int oldR){
		int nextR, seed;
		Calendar calendar=Calendar.getInstance();

		seed = calendar.get(Calendar.MILLISECOND);
		nextR = ((seed * 25173) + 13849) % 65536;
		return nextR;
	}
}
