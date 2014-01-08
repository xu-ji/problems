package z_more_problems;

import java.util.ArrayList;
import java.util.HashMap;

public class SortsAndSearches {
	// everything between f and l have not yet been considered
	public static int binarySearch(int[] array, int l, int r, int x) {
		if (r < l || l < 0 || r >= array.length) {
			System.err.println(x + " not found in array.");
			return 0;
		}
		
		int mid = (l + r) / 2;
		if (array[mid] == x) {
			return mid;
		} else if (array[mid] > x) {
			return binarySearch(array, l, mid - 1, x);
		} else {
			return binarySearch(array, mid + 1, r, x);
		}
		
	}
	/*
	// two pointers, perhaps. But pointing to the same thing
	// in place mergesort!
	// merging must create new space though - think about the process!
	public static void mergeSort(int[] array, int l, int r) {
		int mid = (l + r) / 2; 
		mergeSort(array, l, mid);
		mergeSort(array, mid + 1, r);
		// 
		int[] totalSortedSection = mergeA(array, l, r);
		replace(array, l, r, totalSortedSection);
		
	}
	*/
	
	public static int[] mergeSort(int[] array, int l, int r) {
		if ( l < 0 || l >= array.length || r < 0 || r >= array.length) {
			System.err.println("Array bounds error");
			return null;
		}
		if (l == r) {
			return new int[]{array[l]};
		}
		
		int mid = (l + r) / 2;
		int[] lHalf = mergeSort(array, l, mid);
		int[] rHalf = mergeSort(array, mid + 1, r);
		
		return merge(lHalf, rHalf);
	}
	
	public static int[] merge(int[] lHalf, int[] rHalf) {
		if (lHalf == null) {
			return rHalf;
		}
		if (rHalf == null) {
			return lHalf;
		}
		// get up to the minimum of the two arrays
		int[] res = new int[lHalf.length + rHalf.length];
		int l = 0;
		int r = 0;
		int resInd = 0;
		while (l < lHalf.length && r < rHalf.length) {
			if (lHalf[l] < rHalf[r]) {
				res[resInd] = lHalf[l];
				l++;
			} else {
				res[resInd] = rHalf[r];
				r++;
			}
			resInd++;
		}
		//System.out.println("Exit main while loop : " + Arrays.toString(res));
		
		if (l < lHalf.length) {
			while (l < lHalf.length) {
				res[resInd] = lHalf[l];
				l++;
				resInd++;
			}
		} else if (r < rHalf.length) {
			while (r < rHalf.length) {
				res[resInd] = rHalf[r];
				r++;
				resInd++;
			}
		}
		
		return res;
	}
	
	
	public static void quicksort() {
		
		
	}
	
	// start with the same, ends with the same, same length
	public static String dictionaryFind(HashMap<Character, ArrayList<String>> dictionary) {
		return null;
	}
	
}