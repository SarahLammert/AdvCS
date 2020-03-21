package mergeSort;

public class Runner {
	public static void main(String[] args) {
		int numInArray = 100;
		Comparable[] array = new Comparable[numInArray];
		for(int x = 0; x < numInArray; x++) {
			array[x] = Integer.valueOf((int)(Math.random() * 1000 + 1));
		}
		
		Comparable[] array2 = array.clone();
		
		System.out.println("Before: ");
		for(Comparable c: array) {
			System.out.print(c + " ");
		}
		
		MergeSort ms = new MergeSort(array);
		array = ms.getArray(); 
		
		System.out.println("After: ");
		for(Comparable c: array) {
			System.out.print(c + " ");
		}
		
		System.out.println("Before: ");
		for(Comparable c: array2) {
			System.out.print(c + " ");
		}
		
		MergeSortNonRecursive ms2 = new MergeSortNonRecursive(array2);
		array2 = ms.getArray(); 
		
		System.out.println("After: ");
		for(Comparable c: array2) {
			System.out.print(c + " ");
		}
		
		System.out.println();
		System.out.println("Merge Sort recursive: " + ms.s);
		System.out.println("Merge Sort nonrecursive: " + ms2.s);
	}
}
