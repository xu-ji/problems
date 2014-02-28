package random;

import java.util.ArrayDeque;
import java.util.HashSet;

import data_structures.Pair;

public class StringRunner {

	public static void findSubstring(String s_orig, String sub_orig) {
		char[] s = s_orig.toCharArray();
		char[] sub = sub_orig.toCharArray();
		// <start index in s, index of sub so far>
		ArrayDeque<Pair<Integer, Integer>> soFar = new ArrayDeque<Pair<Integer, Integer>>();
		for (int i = 0; i < s.length; i++) {
			char currChar = s[i];
			while (!soFar.isEmpty()) {
				Pair<Integer, Integer> candidate = soFar.poll();
				System.out.println("Examining substring from: " + candidate.fst);
				if (candidate.snd == sub.length - 1) {
					System.out.println("Found substring from index: " + candidate.fst + "\n");
					continue;
				}
				if (currChar == sub[candidate.snd + 1]) {
					candidate.snd++;
					soFar.addLast(candidate);
				}
			}
			if (sub[0] == currChar) {
				soFar.add(new Pair<Integer, Integer>(i, 0));
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		findSubstring("cade", "cad");
	}

}
