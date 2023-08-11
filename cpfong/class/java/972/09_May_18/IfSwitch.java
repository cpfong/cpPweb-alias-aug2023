public class IfSwitch{
	public static void main(String args[]){
		IfSwitch t = new IfSwitch();

		int s = Integer.parseInt(args[0]);
		String suit="";
		
		if (s==1)
			suit = "hearts";
		else if (s==2)
			suit= "clubs";
		else if (s==3)
			suit="spades";
		else if (s==4)
			suit="diamonds";
		else 	suit="none";
		System.out.println("main suit is : " + suit);

		t.mySwitch(s);		
	}

	private void mySwitch(int ss){
		String suit;
		switch(ss){
			case 1	: suit="hearts"	; 	break;
			case 2	: suit="clubs"	; 	break;
			case 3	: suit="spades" ; 	break;
			case 4	: suit="diamonds"; 	break;
			default	: suit="none"	;	break; 
		}
		System.out.println("sub suit  is : " + suit);
	}
}

