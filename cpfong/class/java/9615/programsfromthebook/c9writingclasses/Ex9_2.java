import java.awt.*;

public class Ex9_2 {

	private int curVal, lVal, hVal;

	public void Ex9_2(){
		curVal = lVal = hVal = 0;
	}

	public void setNewValue    (int t) { curVal = t; }
	public void setHValue      (int t) { hVal = t; }
	public void setLValue      (int t) { lVal = t; }
	public int  getLowestValue () { return lVal; }
	public int  getHighestValue() { return hVal; }
}
