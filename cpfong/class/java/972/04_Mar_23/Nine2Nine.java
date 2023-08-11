public class Nine2Nine{
	public static void main(String args[]){
		int a[][]=new int[10][10];
		int t=0;
		for (int i=1; i<a.length; i++){
			for (int j=1; j<a[0].length; j++){
				t=i*j;
				System.out.print(""+ t +" ");
			}
			System.out.print("\n");
		}
	}
}
