package com.practice.java.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC79Practice {
	public static void main(String[] args) {

//		[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//				"ABCESEEEFS"
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }; // SEE
		// char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A',
		// 'D', 'E', 'E' } };

		LC79Practice lc79 = new LC79Practice();
		System.out.println(lc79.exist(board, "SEE")); //

	}

	private boolean exist(char[][] board, String string) {
		// TODO Auto-generated method stub
		boolean ans = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == string.charAt(0)) {
					Node node = new Node(i, j);
					Stack<Node> st = new Stack<>();
					Set<String> visited = new HashSet<>();
					st.add(node);
					if (visitDFS(board, string, st, visited)) {
						return true;
					}
				}
			}
		}
		return ans;
	}

	private boolean visitDFS(char[][] board, String string, Stack<Node> st, Set<String> visited) {
		if (st.isEmpty() && !string.isEmpty()) {
			return false;
		}
		Node node = st.pop();
		visited.add(node.toString());
		if (node.getCol() > board[0].length - 1 || node.getCol() < 0 || node.getRow() < 0
				|| node.getRow() > board.length - 1) {
			return false;
		}
		if (board[node.getRow()][node.getCol()] != string.charAt(0)) {
			return false;
		}
		if (string.isEmpty()) {
			return true;
		}

		

		Node node1 = new Node(node.getRow(), node.getCol() - 1);
		Node node2 = new Node(node.getRow() - 1, node.getCol());
		Node node3 = new Node(node.getRow() + 1, node.getCol());
		Node node4 = new Node(node.getRow(), node.getCol() + 1);
		if (!visited.contains(node1.toString()) && board[node1.getRow()][node1.getCol()] == string.charAt(1)) {
			st.add(node1);
		}
		if (!visited.contains(node2.toString()) && board[node2.getRow()][node2.getCol()] == string.charAt(1)) {
			st.add(node2);
		}
		if (!visited.contains(node3.toString()) && board[node3.getRow()][node3.getCol()] == string.charAt(1)) {
			st.add(node3);
		}
		if (!visited.contains(node4.toString()) && board[node4.getRow()][node4.getCol()] == string.charAt(1)) {
			st.add(node4);
		}
		return visitDFS(board, string.substring(1), st, visited);

	}

	class Node {
		int row;
		int col;

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Node [row=" + row + ", col=" + col + "]";
		}

	}

}
