package tests;
import static problems.SortsAndSearches.*;
import static problems.Maths.*;

import java.util.Arrays;

/* The imports! */
import org.junit.Test;

import problems.Strings;
import static org.junit.Assert.*;

public class SortsSearchesAndMathsTest {
	@Test
	public void quicksortNonEmpty() {
		int[] a = {5, 1, 7, 8, 23, 100, 0};
		quicksort(a, 0, a.length - 1);
		int[] expRes = {0, 1, 5, 7, 8, 23, 100};
		assertArrayEquals(a, expRes);
	}
	
	@Test
	public void quicksortEmpty() {
		int[] a = {};
		quicksort(a, 0, a.length - 1);
		assertTrue(a.length == 0);
	}
	
	
	@Test
	public void testMerge() {
		int[] a = {1, 4, 5};
		int[] b = {0, 3, 4, 10};
		
		int[] res = new int[a.length + b.length];
		int[] exp = new int[]{0, 1, 3, 4, 4, 5, 10};
		merge(a, b, res);
		assertArrayEquals(res, exp);
		
	}
	
	@Test
	public void mergesortNonEmpty() {
		int[] a = {5, 1, 7, 8, 23, 100, 0};
		int[] res = mergesort(a, 0, a.length - 1);
		int[] expRes = {0, 1, 5, 7, 8, 23, 100};
		assertArrayEquals(res, expRes);
	}

	@Test
	public void mergesortEmpty() {
		int[] a = {};
		mergesort(a, 0, a.length - 1);
		System.out.println("Expected: \"less!\" message");
		assertTrue(a.length == 0);
	}

	@Test
	public void binarySearchNonEmpty() {
		int[] a = {0, 3, 5, 6, 8};
		int res = binarySearch(a, 0, a.length - 1, 6);
		assertEquals(res, 3);
	}
	
	@Test
	public void binarySearchLastCase() {
		int[] a = {0, 3, 5, 6, 8};
		int res = binarySearch(a, 0, a.length - 1, 8);
		assertEquals(res, 4);
	}
	
	@Test
	public void binarySearchFirstCase() {
		int[] a = {0, 3, 5, 6, 8};
		int res = binarySearch(a, 0, a.length - 1, 0);
		assertEquals(res, 0);
	}
	
	@Test
	public void binarySearchNonEmptyEven() {
		int[] a = {0, 3, 5, 6};
		int res = binarySearch(a, 0, a.length - 1, 3);
		assertEquals(res, 1);
	}
	
	@Test
	public void binarySearchLastCaseEven() {
		int[] a = {0, 3, 5, 6};
		int res = binarySearch(a, 0, a.length - 1, 6);
		assertEquals(res, 3);
	}
	
	@Test
	public void binarySearchFirstCaseEven() {
		int[] a = {0, 3, 5, 6};
		int res = binarySearch(a, 0, a.length - 1, 0);
		assertEquals(res, 0);
	}
	
	
	@Test
	public void binarySearchEmptyCase() {
		int[] a = {};
		int res = binarySearch(a, 0, a.length - 1, 6);
		System.out.println("Expected \" Integer 6 not found.\" message");
		assertEquals(res, 0);
	}
	
	@Test
	public void testFibonacci1() {
		int res = fibonacci(1);
		assertTrue(res == 0);
	}
	@Test
	public void testFibonacci2() {
		int res = fibonacci(9);
		assertTrue(res == 21);
	}
	
	@Test
	public void testFibonacci3() {
		int res = fibonacci(10);
		assertTrue(res == 34);
	}
	
	
	
	//inefficientFibonacciWithMemos
	@Test
	public void testFibonacci4() {
		int res = inefficientFibonacciWithMemos(1);
		assertTrue(res == 0);
	}
	@Test
	public void testFibonacci5() {
		int res = inefficientFibonacciWithMemos(9);
		assertTrue(res == 21);
	}
	
	@Test
	public void testFibonacci6() {
		int res = inefficientFibonacciWithMemos(10);
		assertTrue(res == 34);
	}
	
	@Test
	public void testFibonacci7() {
		int res = inefficientFibonacci(1);
		assertTrue(res == 0);
	}
	@Test
	public void testFibonacci8() {
		int res = inefficientFibonacci(9);
		assertTrue(res == 21);
	}
	
	@Test
	public void testFibonacci9() {
		int res = inefficientFibonacci(10);
		assertTrue(res == 34);
	}
}
