package problems;

import java.util.Arrays;

// nlgn only sorts :)
public class SortsAndSearches {
	/****************************************** QUICKSORT *******************************************/
	// in place
	public static void quicksort(int[] a, int i, int j) {
		//System.out.println("Called with i, j : (" + i + ", " + j + ")");
		//System.out.println(Arrays.toString(Arrays.copyOfRange(a, i, j + 1))); // copyOfRange does Not include the last index
		
		// REMEMBER THE BASE CASE!
		if (j <= i) {
			return;
		}
		
		int res = partition(a, i, j);
		quicksort(a, i, res - 1);
		quicksort(a, res + 1, j);
	}
	
	private static int partition(int[] a, int i, int j) {
		// paritions array around a[i], returning final position of a[i]
		int x = a[i];
		// everything behind a[i] is sorted
		while (i < j) {
			int currElem = a[i + 1];
			if (currElem < x) {
				a[i] = currElem;
				i++;
			} else {
				swap(a, i + 1, j);
				j--;
			}
		}
		a[i] = x;
		return i;
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/*
	public static int partitionfromtruestart(int[] a, int i, int j) {
		// paritions array around a[i], returning final position of a[i]
		int x = a[i];
		int start = i + 1;
		int end = j;
		// everything behind a[start - 1] is sorted
		while (start - 1 < end) {
			int currElem = a[start];
			if (currElem < x) {
				a[start - 1] = currElem;
				start++;
			} else {
				swap(a, start, end);
				end--;
			}
		}
		a[start - 1] = x;
		return start - 1;
	}*/
	
	/****************************************** MERGESORT *******************************************/
	// not in place
	public static int[] mergesort(int[] a, int i, int j) {
		// REMEMBER BASE CASE!
		if (j < i) {
			System.err.println("less!");
			return null;
		}
		if (i == j) {
			int[] res = new int[]{a[i]}; // don't need number of elems if you have initialiser
			return res;
		}
		
		// get two sorted halves
		int half = (j + i)/2; // think about the even case!! Want even split
		int[] firstHalf = mergesort(a, i, half); // fst half excludes middle element if there is one
		int[] sndHalf = mergesort(a, half + 1, j);
		
		// merge
		int[] res = new int[j - i + 1];
		merge(firstHalf, sndHalf, res);
		return res;
	}
	
	// Pre: res.length = fst.length + snd.length
	public static void merge(int[] fst, int[] snd, int[] res) {
		//System.out.println("merging" + Arrays.toString(fst) + " " + Arrays.toString(snd));
		int fstCurr = 0;
		int sndCurr = 0;
		int fstEnd = fst.length;
		int sndEnd = snd.length;
		
		int resCurr = 0; // res in array
		while (fstCurr < fstEnd || sndCurr < sndEnd) {
			if (fstCurr == fstEnd) {
				// just move all of snd into end of res
				while (sndCurr < sndEnd) {
					res[resCurr] = snd[sndCurr];
					resCurr++;
					sndCurr++;
				}
				break;
			} else if (sndCurr == sndEnd) {
				// move all of fst into end of res
				while (fstCurr < fstEnd) {
					res[resCurr] = fst[fstCurr];
					resCurr++;
					fstCurr++;
				}
				break;
			}
			
			if (fst[fstCurr] < snd[sndCurr]) {
				//System.out.println("added:" + fst[fstCurr]);
				res[resCurr] = fst[fstCurr];
				fstCurr++;
			} else {
				//System.out.println("added:" + snd[sndCurr]);
				res[resCurr] = snd[sndCurr];
				sndCurr++;
			}
			resCurr++;
		}
	}
	
	// Pre: array is sorted
	public static int binarySearch(int[] a, int i, int j, int x) {
		if (j < i) {
			System.err.println("Integer " + x + " not found.");
			return 0;
		}
		
		int middleInd = (i + j) / 2;
		int currMiddle = a[middleInd];
		if (currMiddle == x) {
			return middleInd;
		} else if (currMiddle > x) {
			return binarySearch(a, i, middleInd - 1, x);
		} else {
			return binarySearch(a, middleInd + 1, j, x);
		}
		
	}
}
