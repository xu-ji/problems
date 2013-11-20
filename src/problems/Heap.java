package problems;

// maxheap!
public class Heap {

	int[] heap;
	int size;
	
	public Heap(int size) {
		heap = new int[size];
		this.size = size;
	}
	
	public Heap(int[] unsortedArray) {
		toHeap(unsortedArray);
		this.heap = unsortedArray;
		this.size = unsortedArray.length;
	}
	
	private void toHeap(int[] unsortedArray) {
		
	}
	
	// swaps the top element with smallest, and shrinks heap size by 1.
	// smallest then goes DOWN into right place
	public int pop() {
		if (size == 0) {
			System.out.println("Attempting to pop from empty heap!");
			return 0;
		}
		int res = heap[0];
		swap(heap, 0, size - 1); // swap with last element
		// move smallest element back down into correct place
		// keep swapping with the biggest of 2 children, until both children are smaller
		// or reach end of heap
		
		int curr_ind = 0;
		int indOfMaxChild = 0;
		while (heap[curr_ind] < heap[(indOfMaxChild = findMaxChild(heap, curr_ind))] && 
				!isLeaf(curr_ind)) {
			swap(heap, curr_ind, indOfMaxChild);
			curr_ind = indOfMaxChild;
		}
		size--;
		return res;
		
	}

	private boolean isLeaf(int ind) {
		return 2*ind + 1 >= size;
	}
	
	// pre: assumes curr_ind is inside heap
	private int findMaxChild(int[] heap, int curr_ind) {
		int maxChildInd = 0;
		// find max child - either one child, two children, or none
		if (curr_ind >= size) {
			// we're no longer in the heap
			System.err.println("ERROR - went beyond heap");
			return curr_ind - 1;
		} 
		if (2*curr_ind + 1 >= size) {
			// 1st child does not exist, we've reached the leaves
			maxChildInd = curr_ind;
		} else if (2*curr_ind + 2 >= size) {
			// 2nd child does not exist, but 1st does
			maxChildInd = 2*curr_ind + 1;
		} else {
			// has both children
			if (heap[2*curr_ind + 1] > heap[2*curr_ind + 2]){
				maxChildInd = 2*curr_ind + 1;
			} else {
				maxChildInd = 2*curr_ind + 2;
			}
		}
		return maxChildInd;
		
	}
	
	// inserts elem at bottom of heap, then goes UP into right place
	public void insert(int elem) {
		heap[size] = elem;
		int pos = size;
		size++;

		// move it up to correct place
		int parentInd = (pos - 1) /2;
		while (parentInd >= 0 && heap[parentInd] < elem) {
			swap(heap, parentInd, pos);
			pos = parentInd;
			parentInd = (parentInd - 1)/2;
		}
	}
	
	public void toSortedList() {
		// you have a heap
		// just need to iterate from ind 1 to size/2, swapping each pair if necessary!
		for (int i = 1; i < (size / 2); i++) {
			int fst = heap[i];
			int snd = heap[i + 1];
			if (snd > fst) {
				swap(heap, fst, snd);
				
			}
		}
	}
	
	// sorts any array by inserting each element into a heap
	// then removing the top one one by one to get a sorted list...
	// or in place? 
	public static void heapSort(int[] array) {
		int lastHeapIndex = 0;
		for (int i = 1; i < array.length; i++) {
			staticHeapInsert(array, lastHeapIndex, array[i]);
			lastHeapIndex++;
		}
	}
	
	private static void staticHeapInsert(int[] array, int lastHeapIndex, int elem) {
		array[lastHeapIndex + 1] = elem;
		int pos = lastHeapIndex + 1;
		int parentPos = (pos - 1) / 2;
		while (parentPos >= 0 && array[parentPos] < array[pos]) {
			swap(array, parentPos, pos);
			pos = parentPos;
			parentPos = (parentPos - 1)/2;
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[j] ^ a[i];
		a[i] = a[i] ^ a[j];
	}
	
}
