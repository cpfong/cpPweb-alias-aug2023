public class Test{
	public static void main(String agrs[]){
		int x=12;
		int y=34;
		int z=56;

		System.out.println("" + x + "+" + y + "=" + x + y);
		System.out.println("" + x + "+" + y + "=" + (x + y));
		System.out.println("" + x + "+" + y + "+" + z + "=" + (x + y + z));

		String s = new String("I am a string");
		if (s.equals("I am a string")){
			System.out.println("equal");
		}
		else {
			System.out.println("NOT equal");
		}

		String[] cities = {"LA", "SanFo", "Washington DC", "Columbia"}; 

/*
		cities[0]="Los Angeles";
		cities[1]="San Franscisco";
*/
		for (int i=0; i<cities.length; i++){
			System.out.println(cities[i]);
		}
	}
}
