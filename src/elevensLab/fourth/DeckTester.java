package elevensLab.fourth;

public class DeckTester {
	
	private static Deck d1;
	
	public static void main(String[] args) {
		
		String[] r1 = {"ace", "king", "queen", "jack",
					   "ten", "nine", "eight", "seven",
					   "six", "five", "four", "three", "two"};
		String[] s1 = {"spades", "hearts", "diamonds", "clubs"};
		int[] p1 = {11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		d1 = new Deck(r1, s1, p1);
		System.out.println(d1.size());
		d1.shuffle();
		d1.printAllCards();
		System.out.println();
		for(int i = 0; i < 52; i++) {
			System.out.println(d1.deal());
		}
		System.out.println(d1.size());
		d1.shuffle();
		System.out.println(d1.size());
		d1.printAllCards();
		
		
	}
}
