public class Sales{
	public static void main(String args[]){
		int[][] sales={
			{22,49, 4,93,0,12,32},
			{ 3, 8,67,51,5, 3,63},
			{14, 8,23,14,5,23,16},
			{54, 0,76,31,4, 3,99}
		};

		Sales ss = new Sales();
		int sum=0, shop, day;

		final int days=7;
		days=6;

		sum=ss.summ(sales);
/*
		for (shop=0; shop < sales.length ; shop++){
			for (day=0; day < sales[0].length; day++){
				sum=sum + sales[shop][day];
			}
		}
*/
		System.out.println("sum = " + sum );

		for (shop=0; shop<sales.length; shop++){
			sum=0;
			for (day=0; day<sales[0].length; day++){
				sum += sales[shop][day];
			}
			System.out.println("company " + (shop+1) + " sales=" + sum);
		}

		for (day=0; day<sales[0].length; day++){
			sum=0;
			for (shop=0; shop < sales.length; shop++){
				sum += sales[shop][day];	
			}
			System.out.println("day " + day + " sales=" + sum);
		}
	}

	private int summ(int [][] array){
		int t=0,r,c;
		for (r=0; r < array.length; r++){
			for (c=0; c < array[0].length; c++){
				t += array[r][c];
			}
		}
		return t;
	}
}
