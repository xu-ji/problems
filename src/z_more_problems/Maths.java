package z_more_problems;

import java.util.Arrays;
import java.util.HashMap;

public class Maths {
	public static int fibonacciIterative(int n) {
		int[] store = new int[]{0, 1};
		int curr = 2;
		//curr is the last thing that was correctly entered
		while (curr < n) {
			store[(curr % 2 == 0) ? 0 : 1] = store[0] + store[1];
			curr++;
		}
		
		return (n % 2 == 0) ? store[1] : store[0];
	}
	
	
	// nth fib number
	// 1: 0, 2: 1, 3: 1
	public static int recursiveFibonacci(int n) {	
		if (n <= 2) {
			return n - 1;
		}
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}
	
	public static int recursiveFibonacciWithMemos(int n) {
		return recursiveFibonacciWithMemosAccum(n, new HashMap<Integer, Integer>());
	}

	private static int recursiveFibonacciWithMemosAccum(int n, HashMap<Integer, Integer> lookup) {
		if (n <= 2) {
			return n - 1;
		}
		
		if (lookup.containsKey(n)) {
			return lookup.get(n);
		} else {
			int res1 = recursiveFibonacciWithMemosAccum(n - 1, lookup);
			int res2 = recursiveFibonacciWithMemosAccum(n - 2, lookup);
			int total = res1 + res2;
			lookup.put(n, total);
			return total;
		}
	}
	

	public int LCM(int a, int b) {
		return (a * b) / GCD(a, b);
		
	}
	
	public int GCD(int a, int b) {
		// always make sure larger is first
		if (b > a) {
			a = b ^ a;
			b = b ^ a;
			a = b ^ a;
		}
		
		if (b == 0) {
			return a;
		}
		
		return GCD(b, a % b);
	}
	
	// pre - arrays are of the same length
	// if they were not the same - loop up to the smaller one's length, and say it's zero for the rest.
	public static int[] bigAdditionBitwise(int[] a, int[] b) {
		int largestLength = Math.max(a.length, b.length);
		int[] carry = new int[largestLength + 1];
		int[] res = new int[largestLength + 1];
		
		// the topmost, most significant bit is zero for a and b and does not exist in their arrays
		// we must loop right up to but not including that
		int i;
		for (i = largestLength - 1; i >= 0 ; i--) {
			int sum = a[i] + b[i] + carry[i + 1];
			if ((sum % 2) == 1) { // either 1 or 3
				res[i] = 1;
			}
			if (sum > 1) {
				carry[i] = 1;
			}
		}
		// i is now -1
		res[i + 1] = carry[i + 1];
		return res;
	}
	
	public static int[] bigAddition(int[] a, int[] b) {
		return a;
	}
	
	public int[] bigSubtraction(int[] a, int[] b) {
		return a;
	}
	
	public int[] bigMultiplication(int[] a, int[] b) {
		return a;
		
	}
	
}
