package mergeSort;

public class MergeSortNonRecursive implements Comparable<Integer> {
	
	Comparable[] array;
	long s;
	
	public MergeSortNonRecursive(Comparable[] a) {
		array = a;
		s = System.currentTimeMillis();
		sort(array);
		s = System.currentTimeMillis() - s;
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			 aux[k] = a[k];
		}
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}
	
	private static boolean less(Comparable comparable, Comparable comparable2) {
		if(comparable.compareTo(comparable2) > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Comparable[] getArray() {
		return array;
	}
	
	@Override
	public int compareTo(Integer o) {
		return this.compareTo(o);
	}

	public static void sort(Comparable[] a) {
		int n = a.length;
		Comparable[] aux = new Comparable[n];
		for (int s = 1; s < n; s = s+s) {
			for (int l = 0; l < n-s; l += s+s) {
				merge(a, aux, l, l+s-1, Math.min(l+s+s-1, n-1));
			}
		}
	}
}
