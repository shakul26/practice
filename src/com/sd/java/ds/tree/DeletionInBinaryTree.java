package com.sd.java.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBinaryTree {

	static Node root;
	public static Node deleteBT(Node root, int key) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node temp = null , keyNode = null;
		
		while(!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			
			if(temp.data == key) {
				keyNode =  temp;
			}
			
			if(temp.left!=null)
				q.add(temp.left);
			
			if(temp.right!=null)
				q.add(temp.right);
			
		}
		// after the while loop completes since it's a level order traversal temp will be pointing to rightmost element
		if(temp== null)
			return null;
		int x = temp.data;
		deleteDeepest(root,temp);
		keyNode.data = x;
		return root;
	}

	private static void deleteDeepest(Node root, Node del) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node temp;
		while(!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			
			if(temp.right!=null) {
				
				if(temp.right == del)
					temp.right = null;
				else
					q.add(temp.right);
			}
			
			if(temp.left !=null)
			{
				if(temp.left == del)
					temp.left = null;
				else
					q.add(temp.left);
			}
			
		}
		
	}

	public static void inorderRec(Node root) {
		
		if(root == null)
			return;
		
		inorderRec(root.left);
		System.out.print(root.data+" ");
		inorderRec(root.right);
	}
	
	public static void main(String[] args) {
		root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);
		
		System.out.println("Inorder Traversal before insertion");
		inorderRec(root);
		deleteBT(root, 8);
		System.out.println("Inorder Traversal after insertion");
		inorderRec(root);
		
	}
}

class Node{
	int data;
	Node left, right;
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}