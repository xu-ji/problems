package z_more_problems;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Node {
 int node;
 Node left;
 Node right;
 
 public Node(int x, Node left, Node right) {
	 this.node = x;
	 this.left = left;
	 this.right = right;
 }
	
 public void iterativeInOrder(Node root) {
	 Node curr = root;
	 Stack<Node> s = new Stack<Node>();
	 while (curr != null || !s.isEmpty()) {
		 if (curr != null) {
			 s.push(curr);
			 curr = curr.left;
		 } else {
			 curr = s.pop();
			 System.out.println(curr);
			 curr = curr.right;
		 }
	 }
 }
 
 public void iterativePreOrder(Node root) {
 }
 
 public void iterativePostOrder() {
	 
 }
 
 public int height(Node n) {
	 // no children - leaf
	 if (n.left == null && n.right == null) {
		 return 1;
	 }
	 // only one child - 2 cases
	 
	 // both children
	 return height(n.left) + height(n.right);
 }
 
 public int dfs(Node n, int val) {
	 ArrayDeque<Node> q = new ArrayDeque<Node>();
	 q.addFirst(n);
	 int res = 0;
	 while (!q.isEmpty()) {
		 Node curr = q.poll();
		 if (curr.node == val) {
			 System.out.println("Found!");
			 res = curr.node;
			 break;
		 } else {
			 // add all its children
		 }
	 }
	 return res;
 }
}
