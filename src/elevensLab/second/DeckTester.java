package elevensLab.second;

import elevensLab.second.Deck;

public class DeckTester {
	
	private static Deck d1;
	private static Deck d2;
	private static Deck d3;
	public static void main(String[] args) {
		
		String[] r1 = {"ace", "king", "queen", "jack", "ten"};
		String[] s1 = {"hearts", "spades", "diamonds", "clubs"};
		int[] p1 = {11, 10, 10, 10, 10};
		d1 = new Deck(r1, s1, p1);
		System.out.println(d1);
		d1.deal();
		System.out.println(d1);
		System.out.println("This deck is empty: " +  d1.isEmpty());
		
		String[] r2 = {"four", "five"};
		String[] s2 = {"hearts"};
		int[] p2 = {4, 5};
		d2 = new Deck(r2, s2, p2);
		System.out.println(d2);
		d2.deal();
		d2.deal();
		System.out.println(d2);
		System.out.println("This deck is empty: " +  d2.isEmpty());
		
		String[] r3 = {"seven", "nine", "jack"};
		String[] s3 = {"clubs", "diamonds"};
		int[] p3 = {7, 9, 11};
		d3 = new Deck(r3, s3, p3);
		System.out.println(d3);
		d3.deal();
		d3.deal();
		System.out.println(d3);
		System.out.println("This deck is empty: " +  d3.isEmpty());
		
	}
}
