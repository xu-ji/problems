package random;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

import data_structures.Pair;

public class Multiplier {
	
	public static int SIZE_OF_MATRIX = 3;
	
	public static int[][] multiply() {
		int a = 1;
		int b = 1;
		int c = 1;
		int d = 1;
		int e = 1;
		int f = 1;
		int g = 1;
		int h = 1;
		int i = 1;
		
		int j = 1;
		int k = 1;
		int l = 1;
		int m = 1;
		int n = 1;
		int o = 1;
		int p = 1;
		int q = 1;
		int r = 1;
		
		
//		int[][] matrix_a = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
		int[][] matrix_a = {{a, b, c},
							{d, e, f},
							{g, h, i}};

		int[][] matrix_b ={{j, k, l},
		         			{m, n, o},
		         			{p, q, r}};

		int[][] result = new int[SIZE_OF_MATRIX][SIZE_OF_MATRIX];
		
		// queueArray[i] is the sorted queue
		Comparator<Pair<Integer, Integer>> comp = new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
				if (a.fst < b.fst) {
					return -1;
				} else if (a.fst == b.fst) {
					return 0;
				} else {
					return 1;
				}
			}
		};
		@SuppressWarnings("unchecked")
		PriorityQueue<Pair<Integer, Integer>>[] queueArray = (PriorityQueue<Pair<Integer, Integer>>[]) new PriorityQueue[SIZE_OF_MATRIX];
	    for (int rowACol = 0; rowACol < SIZE_OF_MATRIX; rowACol++) {
	    	queueArray[rowACol] = new PriorityQueue<Pair<Integer, Integer>>(SIZE_OF_MATRIX, comp);
	    }
	    System.out.println("Unfilled :" + queueArray.length);
	    // fill the queue[b_y] with matrix_b[b_y]'s elements
	    for (int b_y = 0; b_y < SIZE_OF_MATRIX; b_y ++) {
	    	for (int b_x = 0; b_x < SIZE_OF_MATRIX; b_x ++) {
	    		System.out.println(matrix_b[b_y][b_x] + ", " + b_x);
	    		queueArray[b_y].add(new Pair<Integer, Integer>(matrix_b[b_y][b_x], b_x));
	    		
	    	}
	    }
	    
	    print(queueArray);
	    // CALCULATE THE RESULT
		for (int y = 0; y < SIZE_OF_MATRIX; y++) {
		   for (int x = 0; x < SIZE_OF_MATRIX; x++) {
			   ArrayDeque<Pair<Integer,Integer>> addBack = new ArrayDeque<Pair<Integer, Integer>>();
			   int current_increment = matrix_a[y][x];
			  
			   int head = queueArray[x].poll().fst;
			   int accum = current_increment * head;
			   result[y][0] += accum;
			   addBack.push(queueArray[x].poll());
			   // start off as a * min(matrix_b's row corresponding to a)

			   int queue_max = findMax(queueArray[x]); // TODO - the max of the queueArray[x] - if only priorityqueue had a reference to it!
			   for (int queue_index = 1; queue_index <= queue_max; queue_index++) {
				   if (queue_index == queueArray[x].peek().fst) {
					   result[y][queueArray[x].peek().snd] += accum;
					   addBack.push(queueArray[x].poll());
				   }
				   accum += current_increment;
			   }
			   
			   // add addBack to queueArray[y] again
			   while (!addBack.isEmpty()) {
				   queueArray[x].add(addBack.pop());
			   }
		   }
		}
		return result;
	}
	
	
	private static void print(PriorityQueue<Pair<Integer, Integer>>[] qA) {
		for (int i = 0; i < qA.length; i++) {
			PriorityQueue<Pair<Integer, Integer>> q = qA[i];
			Iterator<Pair<Integer, Integer>> it = q.iterator();
			while (it.hasNext()) {
				System.out.print(" (" + it.next().fst + ", " + it.next().snd + ") ");
			}
			System.out.println();
		}
	}


	private static int findMax(
			PriorityQueue<Pair<Integer, Integer>> priorityQueue) {
		int max = priorityQueue.peek().fst;
		for (Pair<Integer, Integer> p : priorityQueue) {
			if (p.fst > max) {
				max = p.fst;
			}
		}
		return max;
	}


	private static void findMaxAnMin(int[][] a, int[] max_matrix,
			int[] min_matrix, int ind) {
		int[] array = a[ind];
		int max = array[0];
		int min = array[0];
		for (int i = 1; i < a.length; i++) {
			if (array[i] > max) {
				max = array[i];
			} else if (array[i] < min) {
				min = array[i];
			}
		}
		max_matrix[ind] = max;
		min_matrix[ind] = min;
	}


	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(multiply()));

	}

}
