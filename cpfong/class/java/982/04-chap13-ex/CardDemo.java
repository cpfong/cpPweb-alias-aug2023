import java.util.*;

public class CardDemo{
	public static void main(String args[]){
		Card[] deck=new Card[52];
		Random r = new Random();

		int i,j;
		String[] color={"heart", "diamond", "club", "spade"};
		for (i=0; i<4; i++){
			for (j=0; j<13; j++){
				deck[i*13+j]=new Card();
				deck[i*13+j].setRank(j+1);
				deck[i*13+j].setSuit(color[i]);
			}
		}

		int rr;
		rr = r.nextInt(52);

		int rank = deck[rr].getRank();

		System.out.println("random number rr = " + rr);
		System.out.println("rank = " + rank);
		
		String s = Integer.toString(deck[rr].getRank());

		System.out.println("suit is " + deck[rr].getSuit() + " rank is " + s);
	}
}
