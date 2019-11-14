package elevensLab.third;

public class Shuffler {
	
	private static final int SHUFFLE_COUNT = 1;

	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
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
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		for(int j = 0, k = 0, l = 1; j < values.length; j++) {
			if(j < values.length/2) {
				shuffled[k] = values[j];
				k += 2;
			} else {
				shuffled[l] = values[j];
				l += 2;
			}
		}
	}

	public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
	}
}
