public class time2{
	private int hour,min,sec;

	public time2(){
		this(0,0,0); // 叫三個參數的那個建構子
	}

	public time2(int h, int m, int s){
		setTime(h,m,s);
	}

	public void setTime(int h, int m, int s){
		hour = ((h >=0 && h < 24) ? h : 0);
		min  = ((m >=0 && m < 60) ? m : 0);
		sec  = ((s >=0 && s < 60) ? s : 0);
	}
}
