package tests;
import static problems.Strings.*;

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
	
	
}
