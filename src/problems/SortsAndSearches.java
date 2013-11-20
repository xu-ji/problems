package problems;

// nlgn only sorts :)
public class SortsAndSearches {

	// in place
	public static void quicksort(int[] a, int i, int j) {
		System.out.println("(" + i + ", " + j + ")");
		// REMEMBER THE BASE CASE!
		if (j <= i) {
			return;
		}
		
		int res = partition(a, i, j);
		/*
		// pick the first element
		int fst = a[i];
		System.out.println(fst);
		// partition
		int curr_i = i;
		int curr_j = j;
		// in place - lots of swaps
		while (curr_i + 1 < curr_j) {
			int curr_elem = a[curr_i + 1];
			if (curr_elem < fst) {
				a[curr_i] = curr_elem; // move backwards! 
				curr_i++;
			} else {
				swap(a, curr_i, curr_j);
				curr_j--;
			}
		}
		System.out.println("currs: (" + curr_i + ", " + curr_j + ")");
		// insert 
		if (curr_i != curr_j) {
			System.err.println("not the same index!");
		}
		
		
		a[curr_i + 1] = fst;
		*/
		// call recursively
		quicksort(a, i, res - 1);
		quicksort(a, res + 1, j);
	}
	
	
	public static void partition(int[] a, int i, int j) {
		// paritions array around a[i], returning final position of a[i]
		
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// not in place
	public static void mergesort(int[] a) {
		
	}
	
	// in place
	public static void heapsort(int[] a) {
		
	}
	
	public static int binarySearch(int[] a, int x) {
		return 0;
	}
}
