package com.sd.java.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Insertion in a Binary Tree in level order
 * 
 */
public class InsertionBinaryTreeLevelOrder {

	
	static class Node{
		int key;
		Node left, right;
		
		Node(int data){
			this.key = data;
			left = right = null;
		}
	}
	
	static Node root;
	
	static void inorderRec(Node temp) {
		
		if(temp == null)
			return;
		inorderRec(temp.left);
		System.out.print(temp.key+ " 	");
		inorderRec(temp.right);
		
	}
	
	static void insert(Node temp, int key) {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			temp = queue.peek();
			queue.remove();
			
			if(temp.left == null)
			{
				temp.left = new Node(key);
				break;
			}else {
				queue.add(temp.left);
			}
			
			
			if(temp.right == null) {
				temp.right = new Node(key);
				break;
			}else {
				queue.add(temp.right);
			}
			
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
		inorderRec(root);
		
		int key = 12;
		
		insert(root,key);
		System.out.println();
		System.out.println("Inorder Traversal after insertion");
		inorderRec(root);
			
	}
}
