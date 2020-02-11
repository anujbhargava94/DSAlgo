package com.practice.java.tree;

public class ValidateBST {

	public boolean isValidBST(BinarySearchTree root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		int min = findMin(root.right);
		int max = findMax(root.left);

		if (root.value <= min && root.value >= max) {
			return isValidBST(root.left) && isValidBST(root.right);
		} else {
			return false;
		}

	}

	private int findMin(BinarySearchTree root) {
		if (root == null) {
			return 10000;
		} else {
			if (root.left != null) {
				return findMin(root.left);
			} else {
				return root.value;
			}
		}
	}

	private int findMax(BinarySearchTree root) {
		if (root == null) {
			return -1;
		} else {
			if (root.right != null) {
				return findMax(root.right);
			} else {
				return root.value;
			}
		}
	}
}
