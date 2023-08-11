public class Temperature {
	private int lowest=50, highest=50;

	public int	getLowestValue	(){ return lowest ; }
	public int	getHighestValue	(){ return highest; }
	public void	setNewValue(int val, int h){
		if (h == 1)	{ highest = val; }
		else 		{ lowest  = val; }
	}
}
