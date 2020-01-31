package carlProblem;

import java.util.Scanner;

public class Moo {
	private int totalNum;
	private int findNum;
	private int answer;
	private String[] s;
	
	public Moo(int tN, int fN) {
		totalNum = tN;
		findNum = fN;
		answer = 0;
		s = new String[tN];
		for(int i = 1; i <= tN; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				s[i-1] = "Moo";
			} else {
				s[i-1] = Integer.toString(i);
			}
		}
	}
	
	public void printTheProblem() {
		for(String t: s) {
			System.out.print(t + " ");
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int totalNum = s.nextInt();
		int findNum = s.nextInt();
		s.close();
		Moo m = new Moo(totalNum, findNum);
		m.printTheProblem();
	}
	

}
