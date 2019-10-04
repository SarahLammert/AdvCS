package AdvanceCSTest;

import java.util.Random;

public class Die extends Random{
	private int sides;
	private int roll;
	
	public Die(int s) {
		sides = s;
	}
	
	public int rollDie() {
		roll = 1 + (int)(Math.random() * sides);
		return roll;
	}
	
	public static void main(String[] args) {
		Die d1 = new Die(6);
		Die d2 = new Die(6);
		System.out.println("First Die: " + d1.rollDie());
		System.out.println("Second Die: " + d2.rollDie());
		int sum = d1.roll + d2.roll;
		System.out.println("The final sum is... \n" + sum + "!!!!!!!");
	}
}
