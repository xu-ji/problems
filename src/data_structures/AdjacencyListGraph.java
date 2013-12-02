package data_structures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

// directed - thing we map to does not necessarily know about us
public class AdjacencyListGraph<T> implements Graph<T>{
	List<Map<Integer, Integer>> map;
	List<T> elems;
	int nextIndex;
	
	public AdjacencyListGraph() {
		map = new ArrayList<Map<Integer, Integer>>(); // each cell in array list maps to a list of nodes
		elems = new ArrayList<T>();
		nextIndex = 0; // for clarity - also doubles as the size of the graph
	}

	
	public void insertEdge(Integer fromNode, Integer toNode, Integer weight) {
		if (fromNode >= nextIndex || toNode >= nextIndex) {
			throw new IllegalArgumentException("Attempting to link to a node that does not exist in the graph.");
		}
		Map<Integer, Integer> mappedTo = map.get(fromNode);
		mappedTo.put(toNode, weight);
	}
	
	public void makeNewNode(T elem) {
		map.add(nextIndex, new TreeMap<Integer, Integer>());
		elems.add(nextIndex, elem);
		nextIndex++;
	}
	
	@Override
	public T get(int nodeNumber) {
		if (nodeNumber >= nextIndex) {
			throw new IllegalArgumentException();
		}
		return elems.get(nodeNumber);
	}

	// assumes node 1 is root of graph
	public int getRoot() {
		return 1;
	}
	
	// returns a map from childnodes to their weights
	// use entrySet to get Set<Map.Entry<Integer, Integer>>.
	public Map<Integer, Integer> getChildrenOf(int node) {
		return map.get(node);
	}
	
	public T getNodeContents(int node) {
		return elems.get(node);
	}
	
	// could be static methods...
	@Override
	public int depthFirstSearchFor(T contents) {
		Stack<Integer> s = new Stack<Integer>(); // the backlog of nodes to visit
		s.push(this.getRoot());
		
		while (this.getNodeContents(s.peek()) != contents) {
			Integer currentNode = s.pop();
			//Iterator<Map.Entry<Integer, Integer>> si = this.getChildrenOf(currentNode).entrySet().iterator(); - then while has Prev - only works for listiterator
			Set<Map.Entry<Integer, Integer>> children = this.getChildrenOf(currentNode).entrySet();
			//Collections.reverse(children); - only for lists...
			for (Map.Entry<Integer, Integer> child : children) {
				
			} // in order??
		}
		
		return s.peek();
	}

	@Override
	public int breadthFirstSearchFor(T contents) {
		// TODO Auto-generated method stub
		return 0;
	}


}
