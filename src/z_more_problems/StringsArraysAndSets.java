package z_more_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringsArraysAndSets {
	
	public boolean isSubstring(char[] s, char[] sub) {
		if (sub.length > s.length || s == null || sub == null) {
			return false;
		}
		
		for (int i = 0; i <= s.length - sub.length; i++) {
			if (s[i] == sub[0]) {
				if (compare(s, i, sub)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean compare(char[] s, int ind, char[] sub) {
		for (int i = 0; i < sub.length; i++) {
			if (sub[i] != s[ind + i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isUniqueString(char[] s) {
		HashSet<Character> store = new HashSet<Character>();
		for (int i = 0; i < s.length; i++) {
			if (!store.contains(s[i])) {
				store.add(s[i]);
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void reverseString(char[] s) {
		int max = s.length % 2;
		if (s.length % 2 == 0) { // even, minus 1
			max--;
		}
		
		for (int i = 0; i <= max; i++) {
			swap(s, i, s.length - 1 - i);
		}
	}
	
	public void swap(char[] a, int x, int y){
		char temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	// same number of every character
	public boolean isPermutationOf(char[] s1, char[] s2) {
		if (s1.length != s2.length) {
			return false;
		}
		
		// make hashmap and add all s1, make 2nd hashmap + check s2, then compare hashmaps
		
		HashMap<Character, Integer> s1Map = null;
		HashMap<Character, Integer> s2Map = null;
		
		// populate
		
		for (Map.Entry<Character, Integer> e : s2Map.entrySet()) {
			if (s1Map.get(e.getKey()) != e.getValue()) {
				return false;
			}
		}
		return true;
	}
	
	
	public HashSet<StringBuilder> allPermutations(char[] a) {
		HashSet<StringBuilder> store = new HashSet<StringBuilder>();
		// init
		// how many permutations? 2^ a.length
		
		for (int i = 0; i < a.length; i++) {
			// for all strings in store, create two - one with, one without
			// have to copy the store to avoid concurrent modification exception?
			for (StringBuilder s: store) {
				store.add(new StringBuilder(s));
				s.append(a[i]);
			}
			
			// add a string that is just this char
			store.add(new StringBuilder(a[i]));
		}
		return store;
	}
	
	// add ( to queue
	// while queue is not empty - pop, and enter the 4 cases (open == closed? n reached?)
	public String allLegalBrackets(int n) {
		return null;
	}
	
	// if it were ordered = iterate from 1 to s.
	public HashSet<HashSet<Integer>> allSubsets(ArrayList<Integer> s) {
		HashSet<HashSet<Integer>> store = new HashSet<HashSet<Integer>>();
		int n = 2^s.size();
		for (int i = 0; i < n; i++) {
			HashSet<Integer> newEntry = new HashSet<Integer>();
			// each i is a unique combo of the integers...
			for (int bit = 0; bit < 32; bit++) {
				if ((i >> bit & 1) == 1){
					newEntry.add(s.at(bit));
				}
			}
			
			store.add(newEntry);
		}
		return store;
	}
	// if not ordered,iterate from 0 to length of list... 
	// For each integer in s, duplicate hashsets already in store, and then add itself as a new hashset
}
