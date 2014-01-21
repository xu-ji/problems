package tests;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static z_more_problems.Maths.*;
import static z_more_problems.SortsAndSearches.*;

import java.util.Arrays;

import org.junit.Test;

public class ZMoreProblemsTests {
	
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
		System.out.println("Expected \"Integer 6 not found.\" message");
		assertEquals(res, 0);
	}
	
	@Test
	public void testMerge() {
		int[] a = {1, 4, 5};
		int[] b = {0, 3, 4, 10};
		
		int[] exp = new int[]{0, 1, 3, 4, 4, 5, 10};
		int[] res = merge(a, b);
		assertArrayEquals(res, exp);
		
	}
	
	@Test
	public void mergesortNonEmpty() {
		int[] a = {5, 1, 7, 8, 23, 100, 0};
		int[] res = mergeSort(a, 0, a.length - 1);
		int[] expRes = {0, 1, 5, 7, 8, 23, 100};
		assertArrayEquals(res, expRes);
	}

	@Test
	public void mergesortEmpty() {
		int[] a = {};
		mergeSort(a, 0, a.length - 1);
		System.out.println("Expected: error message");
		assertTrue(a.length == 0);
	}
	
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
	public void testFibonacci1() {
		int res = fibonacciIterative(1);
		assertTrue(res == 0);
	}
	@Test
	public void testFibonacci2() {
		int res = fibonacciIterative(9);
		assertTrue(res == 21);
	}

	@Test
	public void testFibonacci3() {
		int res = fibonacciIterative(10);
		assertTrue(res == 34);
	}
	
	@Test
	public void testBigAdditionBitwise() {
		int[] a = {1, 0, 1, 1};
		int[] b = {0, 1, 0, 1};
		int[] res = bigAdditionBitwise(a, b);
		int[] exp = {1, 0, 0, 0, 0};
		assertArrayEquals(res, exp);
	}
	
	
	//recursiveFibonacciWithMemos
	@Test
	public void testFibonacci4() {
		int res = recursiveFibonacciWithMemos(1);
		assertTrue(res == 0);
	}
	@Test
	public void testFibonacci5() {
		int res = recursiveFibonacciWithMemos(9);
		assertTrue(res == 21);
	}
	
	@Test
	public void testFibonacci6() {
		int res = recursiveFibonacciWithMemos(10);
		assertTrue(res == 34);
	}
	
	@Test
	public void testFibonacci7() {
		int res = recursiveFibonacci(1);
		assertTrue(res == 0);
	}
	@Test
	public void testFibonacci8() {
		int res = recursiveFibonacci(9);
		assertTrue(res == 21);
	}
	
	@Test
	public void testFibonacci9() {
		int res = recursiveFibonacci(10);
		assertTrue(res == 34);
	}
}