public class Test1{
	public static void main(String agrs[]){

		int[][] xx = {{22,49,4,93,0,12,32},{3,8,67,51,5,3,63},{14,8,23,14,5,23,16},{54,0,76,31,4,3,99}};
		int r,c;	
		
		for (r=0; r < xx.length; r++){
			for (c=0; c < xx[0].length; c++){
				System.out.print(" " + xx[r][c]);
		  	}
			System.out.println("");
	    }
	}
}
