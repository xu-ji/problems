import java.util.Arrays;

public class Strings {
	
	public static void main(String[] args) {
		String s= "cat";
		System.out.println(s.charAt(3));
	}
	
	/* Question 1*/
	public boolean isAllUniqueChars(String s) {
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
	public void reverse(String s) {
	    char[] sArray = s.toCharArray();
	    int partition = sArray.length / 2;
	    for (int i = 0; i < partition; ++i) {
	    	swap(sArray, i, sArray.length - i - 1);
	    }
	}
	
	public void swap(char[] a, int from, int to) {
	    char temp = a[from];
	    a[from] = a[to];
	    a[to] = temp;
	}
	
	/* Question 3*/
	public boolean isPermutationOf(String fst, String snd) {
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

	public String sortString(String fst) {
		char[] res = fst.toCharArray();
		Arrays.sort(res);
		return new String(res); 
	}
	
	/* Question 4*/
	public void replaceSpaceWithPercentageTwenty(char[] string, int lengthOfStringExcludingEmptyEnd) {
		int numSpaces = countSpaces(string, lengthOfStringExcludingEmptyEnd - 1);
		int currStringInd = lengthOfStringExcludingEmptyEnd - 1;
		int endOfFinalString = lengthOfStringExcludingEmptyEnd + 2*numSpaces - 1;
		for (int i = currStringInd; i >= 0; i--) {
			if (string[currStringInd] == ' ') {
				string[endOfFinalString--] = '0';
				string[endOfFinalString--] = '2';
				string[endOfFinalString] = '%';			
			} else {
				string[endOfFinalString] = string[currStringInd];
			}	
		}	
	}

	int countSpaces(char[] string, int to) {
		int count = 0;
		for (int i = 0; i < string.length; i++) {
			if (string[i] == ' ') {
				count++;
			}
		}
		return count;
	}
	
	/* Question 5*/
	public String compressString(char[] s) {
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

	public void rotateMatrix(int[][] m) {
		for (int i = 0; i < m.length / 2; i++) {
			rotateFrameAt(m, i);
		}
	}

	private void rotateFrameAt(int[][] m, int topLeft) {

	}

	public void rotateMatrix2(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
			// col becomes row
			// len - 1 - row becomes col
			}
		}
	}
}