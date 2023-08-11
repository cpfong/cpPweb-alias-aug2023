public class StringTemplate{
	public static void main(String args[]){
		String x="this";	
		String y="this";
		String z="sum";

		// 注意: 變數 x 為 String 的物件, 所以可以繼承 equals 這個方法
		if (x.equals(y) == true) { System.out.println("相等"); }
		else { System.out.println ("no equal"); }

		// 注意: 有括號和沒括號的區別
		System.out.println(z + 2 + 3);
		System.out.println(z + (2 + 3));

		String SArray[]=new String[2];
		SArray[0]="this is a test";
		SArray[1]="that is a test";
	}
}
