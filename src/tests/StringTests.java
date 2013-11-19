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
		assertTrue(isAllUniqueChars("allahmbr"));
	}
	@Test
	public void reverseString() {
		String s = "abca";
		reverse("abca");
		assertEquals(s, "acba");
	}
	
	@Test
	public void isPermOfTrue() {
		assertTrue(isPermutationOf("trash", "harst"));
	}
	
	@Test
	public void isPermOfFalse() {
		assertFalse(isPermutationOf("trash", "trass"));
	}
	
	
	
}
