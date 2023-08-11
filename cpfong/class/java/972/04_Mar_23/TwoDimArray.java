public class TwoDimArray{
	public static void main(String args[]){
		int a[][]=new int[2][2];
		int b[][]={{00,01},{10,11},{20,21}};

		for (int r=0; r<3; r++){
			for (int c=0; c<2; c++){
				System.out.print(""+b[r][c]+" ");
			}
			
			System.out.print("\n");
		}
	}
}
