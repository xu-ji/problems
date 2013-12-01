package data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

// directed - thing we map to does not necessarily know about us
public class AdjacencyListGraph<T> implements Graph<T>{
	List<List<Integer>> map;
	List<T> elems;
	int nextIndex;
	
	public AdjacencyListGraph() {
		map = new ArrayList<List<Integer>>(); // each cell in array list maps to a list of nodes
		elems = new ArrayList<T>();
		nextIndex = 0; // for clarity - also doubles as the size of the graph
	}

	
	public void insertEdge(Integer fromNode, Integer toNode) {
		if (fromNode >= nextIndex || toNode >= nextIndex) {
			throw new IllegalArgumentException("Attempting to link to a node that does not exist in the graph.");
		}
		List<Integer> mappedTo = map.get(fromNode);
		mappedTo.add(toNode);
	}
	
	public void makeNewNode(T elem) {
		map.add(nextIndex, new ArrayList());
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
	
	// cannot use array!
	@Override
	public int depthFirstSearchFor(T contents) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int breadthFirstSearchFor(T contents) {
		// TODO Auto-generated method stub
		return 0;
	}


}
