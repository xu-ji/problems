package problems;

import java.util.Arrays;

public class Maths {
	// Normal recursive
	public static int inefficientFibonacci(int n) {
		if (n <=2) {
			return n -1;
		} else {
			return inefficientFibonacci(n - 1) + inefficientFibonacci(n - 2); 
		}
	}
	
	// MEMO IT!
	public static int inefficientFibonacciWithMemos(int n) {
		int[] fibStore = new int[n];
		Arrays.fill(fibStore, -1);
		return fibMemo(n, fibStore);
	}
	
	private static int fibMemo(int n, int[] fibStore) {
		if (fibStore[n - 1] != -1) {
			return fibStore[n - 1];
		} else if (n <= 2) {
			fibStore[n - 1] = n - 1;
			return n - 1;
		} else {
			fibStore[n - 1] = fibMemo(n - 1, fibStore) + fibMemo(n - 2, fibStore);
			return fibStore[n - 1];
		}
	}

	// WINNER: forwards iteratively
	public static int fibonacci(int n) {
		n--; // start from 0
		if (n <= 1) {
			return n;
		}

		int[] fib = new int[]{0, 1};
		int count = 1; // currently last inserted thing is 2nd
		
		int res = 0;
		System.out.println(fib[0]);
		System.out.println(fib[1]);
		while (count < n) {
			fib[0] = fib[0] + fib[1];
			System.out.println(fib[0]);
			count++;
			if (count == n) {
				res = fib[0];
				break;
			}
			fib[1] = fib[0] + fib[1];
			System.out.println(fib[1]);
			count++;
			if (count == n) {
				res = fib[1];
				break;
			}
		}
		return res;
	}
	
}
