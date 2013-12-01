package data_structures;

/* Assuming all graphs are weighted
 * Directed graphs - adjacency lists or matrices
 * Undirected graphs - adjacency matrices (where values are mirrored) or set of edges between points
 */

// just matrix of weights between node numbers, and array mapping node number to contents?
public interface Graph<T> {
	public abstract T get(int nodeNumber);
	public abstract int depthFirstSearchFor(T contents); // returns node number
	public abstract int breadthFirstSearchFor(T contents); // returns node number
}
