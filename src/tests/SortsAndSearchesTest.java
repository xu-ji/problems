package tests;
import static problems.SortsAndSearches.*;

import java.util.Arrays;

/* The imports! */
import org.junit.Test;

import problems.Strings;
import static org.junit.Assert.*;

public class SortsAndSearchesTest {
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
	public void mergesortNonEmpty() {
		int[] a = {5, 1, 7, 8, 23, 100, 0};
		mergesort(a, 0, a.length - 1);
		int[] expRes = {0, 1, 5, 7, 8, 23, 100};
		assertArrayEquals(a, expRes);
	}
	/* 
	@Test
	public void mergesortEmpty() {
		int[] a = {};
		mergesort(a, 0, a.length - 1);
		assertTrue(a.length == 0);
	}
	*/
	
}
