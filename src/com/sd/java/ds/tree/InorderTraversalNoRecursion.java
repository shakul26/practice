package com.sd.java.ds.tree;

import java.util.Stack;

/**
 * @author Shakul.Dubey
 * 1. Create an Empty Stack S
 * 2. Initialize current node as root
 * 3. push the current node to S and set current = current.left until current is null
 * 4. if current is NULL and stack is not empty then
 *    a. pop the item from stack
 *    b. print the popped item, set the current = popped_item.right
 *    c. go to step 3
 * 5. if current is NULL and stack is empty stop
 */
public class InorderTraversalNoRecursion {

	public int add() {
		return 1;
	}
	
	static class Node{
		int key;
		Node left, right;
		
		Node(int data){
			this.key = data;
			left = right = null;
		}
	}
	
	static Node root;
	
	
	private static void inorderNoRec(Node root) {
		Node current = root;
		Stack<Node> s = new Stack<>();
	
		while(current!=null || !s.isEmpty())
		{	
			
			while(current != null) {
				s.push(current);
				current = current.left;
			}
			
			current = s.pop();
			
			System.out.print(current.key+" ");
			
			current = current.right;
					
		}
		
	}

	public static void main(String[] args) {
		
		root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		System.out.println("Inorder Traversal before insertion");
		inorderNoRec(root);
		
		System.out.println("Inorder Traversal after insertion");
		inorderNoRec(root);
			
	}



	
}
