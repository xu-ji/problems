package tests;
import static problems.Strings.*;

import java.util.Arrays;

/* The imports! */
import org.junit.Test;
import static org.junit.Assert.*;

public class StringTests {
	@Test
	public void isAllUniqueCharsTrue() {
		assertTrue(isAllUniqueChars("abcde"));
	}
	@Test
	public void isAllUniqueCharsFalse() {
		assertFalse(isAllUniqueChars("allahmbr"));
	}
	@Test
	public void reverseString() {
		char[] s = {'a', 'b', 'c', 'a'};
		reverse(s);
		char[] expRes = {'a', 'c', 'b', 'a'};
		assertArrayEquals(s, expRes);
	}
	
	@Test
	public void isPermOfTrue() {
		assertTrue(isPermutationOf("trash", "harst"));
	}
	
	@Test
	public void isPermOfFalse() {
		assertFalse(isPermutationOf("trash", "trass"));
	}
	
	@Test
	public void replaceStringWithPercentageTwenty() {
		char[] string = {'c', ' ', 'a', ' ', 't', ' ', ' ',' ',' ',' ',' ',' '};
		replaceSpaceWithPercentageTwenty(string, 6);
		char[] expRes =  {'c', '%', '2', '0', 'a', '%', '2','0','t','%','2','0'};
		assertArrayEquals(string,expRes);
	}
	
	@Test
	public void rotateMatrixTestTran() {
		int[][] m = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
		rotateMatrixTranspose(m);
		System.out.println(Arrays.deepToString(m));
		int[][] rm = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertTrue(Arrays.deepEquals(m, rm));
		
	}
	
	@Test
	public void rotateMatrixTestInd() {
		int[][] m = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
		int[][] res = rotateMatrixIndices(m);
		System.out.println(Arrays.deepToString(res));
		int[][] rm = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertTrue(Arrays.deepEquals(res, rm));
		
	}
	
	
}
