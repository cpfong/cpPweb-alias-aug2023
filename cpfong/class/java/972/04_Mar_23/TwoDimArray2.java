public class TwoDimArray2{
	public static void main(String args[]){
		int a[][]=new int[2][2];
		int b[][]={{11,12,13},{21,22,23}};

		for (int i=0; i<b.length; i++){
			for (int j=0; j<b[0].length; j++){
				System.out.print(""+b[i][j]+" ");
			}
			
			System.out.print("\n");
		}
	}
}
