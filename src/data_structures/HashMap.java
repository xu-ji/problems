package data_structures;

import java.util.ArrayList;
// no ordering by key!

public class HashMap<K, V> {

	private ArrayList<V> map;

	public HashMap() {
		map = new ArrayList<V>();	
	}
	
	public void put(K key, V val) {
		int hash = key.hashCode();
		map.add(hash, val);
	}
	
	public V get(K key) {
		return map.get(key.hashCode()); 
	}
	
}

// override equals - override hashCode
