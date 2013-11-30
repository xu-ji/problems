package problems;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Strings {
	
	public static void main(String[] args) {
	}
	
	/* Question 1*/
	public static boolean isAllUniqueChars(String s) {
	    boolean[] counts = new boolean[128]; // ascii char number
	    Arrays.fill(counts, false);
	       for (char c : s.toCharArray()) {
	        boolean hasMet = counts[(int) c];
	        if (hasMet) {
	            return false;
	        }
	          counts[(int) c] = true;
	       }

	return true;
	}
	
	/* Question 2*/
	public static void reverse(char[] sArray) {
	    //char[] sArray = s.toCharArray(); // char array is copied!
	    int partition = sArray.length / 2;
	    for (int i = 0; i < partition; ++i) {
	    	swap(sArray, i, sArray.length - i - 1);
	    }
	    //s = new String(sArray);
	    // fails - new reference to same object! reference is copied
	    
	}
	
	public static void swap(char[] a, int from, int to) {
	    char temp = a[from];
	    a[from] = a[to];
	    a[to] = temp;
	}
	
	/* Question 3*/
	public static boolean isPermutationOf(String fst, String snd) {
		if (fst.length() != snd.length()) {
			return false;
		}
		String sortedFst = sortString(fst);
		String sortedSnd = sortString(snd);		
		if (!sortedFst.equals(sortedSnd)) {
			return false;
		}
		return true;
	}

	public static String sortString(String fst) {
		char[] res = fst.toCharArray();
		Arrays.sort(res);
		return new String(res); 
	}
	
	/* Question 4*/
	public static void replaceSpaceWithPercentageTwenty(char[] string, int lengthOfStringExcludingEmptyEnd) {
		int numSpaces = countSpaces(string, lengthOfStringExcludingEmptyEnd - 1);
		int endOfFinalString = lengthOfStringExcludingEmptyEnd + 2*numSpaces - 1;
		for (int i = lengthOfStringExcludingEmptyEnd - 1; i >= 0; i--) {
			if (string[i] == ' ') {
				string[endOfFinalString--] = '0';
				string[endOfFinalString--] = '2';
				string[endOfFinalString--] = '%';			
			} else {
				string[endOfFinalString--] = string[i];
			}	
		}	
	}

	public static int countSpaces(char[] string, int to) {
		int count = 0;
		for (int i = 0; i <= to; i++) {
			if (string[i] == ' ') {
				count++;
			}
		}
		return count;
	}
	
	/* Question 5*/
	public static String compressString(char[] s) {
		StringBuilder sb = new StringBuilder();
		char currChar = s[0];
		int count = 1;

		for (int i = 1; i <= s.length; i++) {
			if (i == s.length - 1 || s[i] != currChar) { 	// need to add last one, lazy eval means no indexoutofboundserror.
				sb.append(currChar);
				sb.append(count);
				currChar = s[i];
				count = 1;
			} else {
				count++;
			}
		}
		return sb.toString();
	}
	
	/* Question 6*/

	public static void rotateMatrixFailed(int[][] m) {
		for (int i = 0; i < m.length / 2; i++) {
			rotateFrameAt(m, i);
		}
	}

	/* Rotate the frame given by (topLeft, topLeft) */
	private static void rotateFrameAt(int[][] m, int topLeft) {
		for (int i = topLeft; i < m.length - topLeft - 1; i++ ) {
			int row = topLeft;
			int col = i;
			int prevVal = m[row][col];
			int oldPrevVal = 0;
			
			for (int j = 0; j < 4; j++) {
				System.out.println("row:" + row + ", col: " + col);
			// swap the four cells in the frame
				
				
				oldPrevVal = prevVal;
				prevVal = m[row][col];
				m[row][col] = oldPrevVal;		
			}
		}
	}

	/* impossible - remember that you are SWAPPING elements - i.e. the 4th one becomes the 1st!
	public void rotateMatrix2(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
			// col becomes row
			// len - 1 - row becomes col
			}
		}
	}
	*/
	
	public static void rotateMatrixTranspose(int[][] m) {
		assert(m.length == m[0].length);
		// Transpose - i.e. swap elems in top right triangle with bottom left one
		for (int row = 0; row < m.length; row++) {
			for (int col = row + 1; col < m.length; col++) {
				swap(m, row, col, col, row);
			}
		}
		
		// reverse each row
		for (int row = 0; row < m.length; row++) {
			for (int col = 0; col < m.length / 2; col++) {
				swap(m, row, col, row, m.length - 1 - col);
			}
		}
	}
	
	private static void swap(int[][] m, int FstRow, int FstCol, int SndRow, int SndCol) {
		int Fst = m[FstRow][FstCol];
		int Snd = m[SndRow][SndCol];
		Fst = Fst ^ Snd;
		Snd = Fst ^ Snd;
		Fst = Fst ^ Snd;
		m[FstRow][FstCol] = Fst;
		m[SndRow][SndCol] = Snd;
	}
	
	// NOT in place! O(n^2) space complexity, n is length of matrix
	// try a 3 x 3 matrix, first row:
	// start from 0,0 and see what it's pulling
	public static int[][] rotateMatrixIndices(int[][] m) {
		if (m.length != m[0].length) {
			throw new IllegalArgumentException("Attempting to rotate non-square matrix.");
		}
		int[][] res = new int[m.length][m.length];
		
		for (int row = 0; row < m.length; row++) {
			for (int col = 0; col < m.length; col++) {
				res[row][col] = m[m.length - 1 - col][row];
			}
		}
		
		return res;
	}
	
	/* Question 7*/
	/* WRONG. You'll come across the zeros you set once again, meaning you'll end up 
	 * with entire matrix of zeros. 
	public void setColAndRowOfZeroElemToBeZero(int[][] m) {
		int height = m.length;
		int width = m[0].length;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				if (m[r][c] == 0) {
					setRowToBeZero(m, width, r);
					setColToBeZero(m, height, c);
				}
			}
		}
	}
	*/

	public static void setColAndRowOfZeroElemToBeZero(int[][] m) {
		Set<Integer> zeros = new HashSet<Integer>();
		// unique: 2^x(2y + 1)
		int height = m.length;
		int width = m[0].length;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				if (m[r][c] == 0) {
					zeros.add(1<<r * (c<<1 + 1));
				}
			}
		}
		
		//Iterator<Integer> points = zeros.iterator();
		
		for (Integer point : zeros) {
			Pair<Integer> XY = getXY(point);
			int row = XY.fst;
			int col = XY.snd;
			setRowToBeZero(m, width, row);
			setColToBeZero(m, height, col);
		}
	}
	
	private static Pair<Integer> getXY(int point) {
		int x = 0;
		while ((point & 1) == 1) {
			point /= 2;
			x++;
		}
		int y = point >> 1;
		return new Pair<Integer>(x, y);
	}
	
	private static void setRowToBeZero(int[][] m, int lengthOfRow, int row) {	
		for (int col = 0; col < lengthOfRow; col++) {
			if (m[row][col] != 0) {
				m[row][col] = 0;
			}
		}
	}
	
	private static void setColToBeZero(int[][] m, int lengthOfCol, int col) {
		for (int row = 0; row < lengthOfCol; row++) {
			if (m[row][col] != 0) {
				m[row][col] = 0;
			}
		}
	}
	
	// we don't care about specific points - we need rows, and cols, that contain a zero...
	public void bestSetRowColToZero(int[][] m) {
		int height = m.length;
		int width = m[0].length;
		boolean[] rowHasZero = new boolean[height];
		boolean[] colHasZero = new boolean[width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (m[row][col] == 0) {
					rowHasZero[row] = true;
					colHasZero[col] = true;
				}
			}
		}
		
		// now replace with zeros, testing for the condition
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (rowHasZero[row] || colHasZero[col]) {
					m[row][col] = 0;
				}
			}
		}
		
	}

	/* Question 8*/
	
	// one call to isSubstring only
	// GENIUS! See the big picture!
	public static boolean isRotationOf(String str, String rotatedStr) {
		// do not forget checks
		if (str.length() != rotatedStr.length()) {
			return false;
		}

		// decide empty strings are rotations of each other
		if (str.length() == 0) {
			return true;
		}

		rotatedStr += rotatedStr;
		return isSubstring(rotatedStr, str);
	}

	
	public static boolean isSubstring(String str, String sub) {
		if (sub.length() > str.length()) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, str.length() - 1).startsWith(sub)) {
				return true;		
			}
		}
		return false;
	}

	public static boolean isSubstringSimpler(String str, String sub) {
		if (sub.length() > str.length()) {
			return false;
		}

		for (int i = 0; i < str.length() - sub.length(); i++) {
			if (str.substring(i, str.length()).compareTo(sub) >= 0) {
				return true;
			}
		}

		return false;
	}

}