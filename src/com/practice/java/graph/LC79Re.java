package com.practice.java.graph;

import java.util.ArrayList;
import java.util.List;

public class LC79Re {
	public boolean exist(char[][] board, String word) {
	       boolean ans = false;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == word.charAt(0)) {
						Index index = new Index(i, j);
						List<String> visited = new ArrayList<>();
				if(DFS(board, index, word, visited))
				{
					ans = true;
				}
					}
				}
			}
			
			return ans;
	}

	private boolean DFS(char[][] board, Index edge, String word, List<String> visited) {
		// TODO Auto-generated method stub
		if (word.length() == 0) {
			return true;
		}
		int i = edge.getI();
		int j = edge.getJ();
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited.contains(i + "" + j)
				|| board[i][j] != word.charAt(0)) {
			visited.remove(i+""+j);
			return false;
		}
		visited.add(edge.getI() + "" + edge.getJ());
		Index i1 = new Index(edge.getI(), edge.getJ() - 1);
		Index i2 = new Index(edge.getI(), edge.getJ() + 1);
		Index i3 = new Index(edge.getI() - 1, edge.getJ());
		Index i4 = new Index(edge.getI() + 1, edge.getJ());
		List<String> visited1 = new ArrayList<>(visited);
		List<String> visited2 = new ArrayList<>(visited);
		List<String> visited3 = new ArrayList<>(visited);
		List<String> visited4 = new ArrayList<>(visited);
		return DFS(board, i1, word.substring(1), visited1) || DFS(board, i2, word.substring(1), visited2)
				|| DFS(board, i3, word.substring(1), visited3) || DFS(board, i4, word.substring(1), visited4);

	}

	class Index {
		int i;
		int j;

		public Index(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

	}

	public static void main(String[] args) {

//		[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//				"ABCESEEEFS"
		// char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A',
		// 'D', 'E', 'E' } }; //SEE
		char[][] board = { { 'A', 'B', 'C', 'E' }, 
				{ 'S', 'F', 'E', 'S' }, 
				{ 'A', 'D', 'E', 'E' } };

		LC79Re lc79 = new LC79Re();
		System.out.println(lc79.exist(board, "ABCESEEEFS"));

	}
}
