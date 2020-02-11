package com.practice.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
	int value;
	BinarySearchTree left;
	BinarySearchTree right;

	public BinarySearchTree(int value) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinarySearchTree getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTree left) {
		this.left = left;
	}

	public BinarySearchTree getRight() {
		return right;
	}

	public void setRight(BinarySearchTree right) {
		this.right = right;
	}

	public void insert(int value) {

		if (this.value > value) {
			if (this.left == null) {
				this.left = new BinarySearchTree(value);
			} else {
				this.left.insert(value);
			}

		} else {
			if (this.right == null) {
				this.right = new BinarySearchTree(value);
			} else {
				this.right.insert(value);
			}
		}
	}

	public void levelOrderTraversal() {
		List<ArrayList<Integer>> traversed = new ArrayList<ArrayList<Integer>>();
		Queue<BinarySearchTree> que = new LinkedList<>();
		que.add(this);
		que.add(null);
		ArrayList<Integer> curr = new ArrayList<>();
		while (!que.isEmpty()) {
			BinarySearchTree temp = que.poll();
			if (temp != null) {
				curr.add(temp.value);
				if (temp.left != null) {
					que.add(temp.left);
				}
				if (temp.right != null) {
					que.add(temp.right);
				}
			} else {
				traversed.add(curr);
				curr.clear();
				if (!que.isEmpty()) {
					que.add(null);
				}
			}
		}
		System.out.println("");

	}

}
