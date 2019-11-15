package elevensLab.third;

public class Shuffler {
	
	private static final int SHUFFLE_COUNT = 5;

	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {1, 2, 3, 4};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {1, 2, 3, 4};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Results of " + SHUFFLE_COUNT +
				 " consecutive efficient selection shuffles:");
		int[] values3 = {1, 2, 3, 4};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			efficientSelectionShuffle(values3);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values3.length; k++) {
				System.out.print(" " + values3[k]);
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		//Trying out the methods
		System.out.println("The coin is a " + flip());
		System.out.println("The coin is a " + flip());
		System.out.println("The coin is a " + flip());
		System.out.println("The coin is a " + flip());
		System.out.println("The coin is a " + flip());
		System.out.println("The coin is a " + flip());
		
		int[] p = {1, 2, 3, 9, 8};
		int[] l = {1, 2, 3, 8, 9};
		System.out.println(arePermutations(p, l));
		
		int[] x = {9, 3, 5, 2};
		int[] y = {3, 2, 9, 5};
		System.out.println(arePermutations(x, y));
		
		int[] z = {1, 3, 4, 2};
		int[] q = {3, 2, 9, 5};
		System.out.println(arePermutations(z, q));
		*/
	}
	
	//Int Array
	public static void perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		int k = 0;
		for(int j = 0; j < (values.length+1)/2; j++) {
			shuffled[j] = values[k];
			k += 2;
		}
		k = 1;
		for(int j = (values.length+1)/2; j < values.length; j++) {
			shuffled[j] = values[k];
			k += 2;
		}
		for(int x = 0; x < shuffled.length; x++) {
		values[x] = shuffled[x];
		}
	}
	
	//Int Array
	public static void selectionShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		for(int k = 0; k < values.length; k++) {
			boolean isEmpty = true;
			while(isEmpty) {
				int r = (int)(Math.random() * values.length);
				if(values[r] != -1)
				{
					shuffled[k] = values[r];
					values[r] = -1;
					isEmpty = false;
				}
			}
		}
		for(int x = 0; x < values.length; x++) {
			values[x] = shuffled[x];
		}
	}

	//Int Array
	public static void efficientSelectionShuffle(int[] values) {
		for(int k = values.length-1; k >= 0; k--) {
			//System.out.println("This is k: " + k);
			int r = (int)(Math.random() * (k+1));
			//System.out.println("This is r: " + r);
			int temp = values[r];
			values[r] = values[k];
			values[k] = temp;
			/*for(int i: values) {
				System.out.println(i);
			}
			*/
		}
	}
	
	public static String flip() {
		int chance = (int)((Math.random() * 3)+ 1);
		System.out.println(chance);
		if(chance == 1) {
			return "tails";
		} else {
			return "heads";
		}
	}
	
	
	
	
	
	public static boolean arePermutations(int[] a, int[] b) {
		boolean isPermutation = false;
		int howMany = a.length;
		int count = 0;
		int countOfNotAllTheSame = 0;
		
		for(int x = 0; x < a.length; x++) {
			for(int y = 0; y < b.length; y++) {
				if(a[x] == b[y]) {
					count += 1;
					if(x == y) {
						countOfNotAllTheSame += 1;
					}
					break;
				}
			}
		}
		if(count == howMany) {
			isPermutation = true;
		}
		if(countOfNotAllTheSame == howMany) {
			isPermutation = false;
		}
		return isPermutation;
		
	}
	
}
