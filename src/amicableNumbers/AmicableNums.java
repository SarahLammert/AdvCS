package amicableNumbers;

import java.util.ArrayList;

public class AmicableNums {

	private static final int LIMIT = 1000000;
	private static ArrayList<Integer> checked1;
	private static ArrayList<Integer> checked2;
	private static long s1, f1, s2, f2;
	
	public static void main(String[] args) {
		
		/*
		s1 = System.currentTimeMillis();
		checked1 = new ArrayList<Integer>();
		
		for(int x = 1; x <= LIMIT; x++) {
			int p = sumOfAllFactors(x);
			if(p <= LIMIT && x != p) {
				if(x == sumOfAllFactors(p)) {
					checked1.add(x);
				}
			}
		}
		f1 = System.currentTimeMillis();
		System.out.println(checked1);
		System.out.println("All Done");
		System.out.println("The total time was " + (f1-s1) + " milliseconds");
		
		*/
		
		
		//This is way faster than the one up top: finds the sum of the factors way faster
		//Also, the numbers are in order from smallest to largest -> Some pairs are not next to each other
		//Two systems
		s2 = System.currentTimeMillis();
		checked2 = new ArrayList<Integer>();
		
		for(int x = 2; x <= LIMIT; x++) {
			int p = sumOfFactorsFastVersion(x);
			if(p <= LIMIT && x != p) {
				if(x == sumOfFactorsFastVersion(p)) {
					checked2.add(x);
				}
			}
		}
		f2 = System.currentTimeMillis();
		System.out.println(checked2);
		System.out.println("All Done");
		System.out.println("The total time was " + (f2-s2) + " milliseconds");
		System.out.println(checked2.size());
	}
	
	//Finds the sum of all factors of a
	public static int sumOfAllFactors(int a) {
		int sum = 0;
		for(int x = 1; x < a; x++)
		{
			if(a % x == 0) {
				sum += x;
			}
		}
		return sum;
	}
	
	public static int sumOfFactorsFastVersion(int n)
	{
		int a = n;
	    int prod=1;
	    for(int k=2;k*k<=n;k++){
	        int p=1;
	        while(n%k==0){
	            p=p*k+1;
	            n/=k;
	        }
	        prod*=p;
	    }
	    if(n>1){
	    	prod*=1+n;
	    }
	    prod -= a;
	    return prod;
	}
}
