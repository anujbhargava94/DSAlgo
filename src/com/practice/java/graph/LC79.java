package com.practice.java.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC79 {
	public boolean exist(char[][] board, String word) {
		List<String> source = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					source.add(i + "" + j);
				}
			}
		}
		for (String edge : source) {
			return DFS(board, edge, word);
		}
		return false;
	}

	private boolean DFS(char[][] board, String edge, String word) {
		// TODO Auto-generated method stub
		Stack<String> adj = new Stack<>();
		List<String> visited = new ArrayList<>();
		adj.add(edge);
		while (!adj.isEmpty()) {
			String current = adj.pop();
			visited.add(current);
			return DFS_visit(board, current, word.substring(1), adj, visited);
		}
		return false;

	}

	private boolean DFS_visit(char[][] board, String edge, String word, Stack<String> adj, List<String> visited) {
		// TODO Auto-generated method stub
		if (edge.length() == 0) {
			return true;
		}
		int i = Integer.parseInt(edge.substring(0, 1));
		int j = Integer.parseInt(edge.substring(1, 2));
		visited.add(edge);
		adj.add(edge);
		while(!adj.isEmpty()) {
			
			if (i - 1 >= 0 && !visited.contains((i - 1) + "" + j) && board[i - 1][j] == word.charAt(0)) {
				adj.add((i - 1) + "" + (j));
				DFS_visit(board, (i - 1) + "" + j, word.substring(1), adj, visited);
			}
			if (j - 1 >= 0 && !visited.contains(i + "" + (j - 1)) && board[i][j - 1] == word.charAt(0)) {
				adj.add(i + "" + (j - 1));
				DFS_visit(board, (i) + "" + (j - 1), word.substring(1), adj, visited);
			}
			if (j + 1 < board[0].length && !visited.contains(i + "" + (j + 1)) && board[i][j + 1] == word.charAt(0)) {
				adj.add(i + "" + (j + 1));
				DFS_visit(board, (i) + "" + (j + 1), word.substring(1), adj, visited);
			}
			if (i + 1 < board.length && !visited.contains((i + 1) + "" + (j)) && board[i + 1][j] == word.charAt(0)) {
				adj.add((i + 1) + "" + (j));
				DFS_visit(board, (i + 1) + "" + (j), word.substring(1), adj, visited);
			}
		}
//		if (i - 1 >= 0 && !visited.contains((i - 1) + "" + j) && board[i - 1][j] == word.charAt(0)) {
//			adj.add((i - 1) + "" + (j));
//			DFS_visit(board, (i - 1) + "" + j, word.substring(1), adj, visited);
//		}
//		if (j - 1 >= 0 && !visited.contains(i + "" + (j - 1)) && board[i][j - 1] == word.charAt(0)) {
//			adj.add(i + "" + (j - 1));
//			DFS_visit(board, (i) + "" + (j - 1), word.substring(1), adj, visited);
//		}
//		if (j + 1 < board[0].length && !visited.contains(i + "" + (j + 1)) && board[i][j + 1] == word.charAt(0)) {
//			adj.add(i + "" + (j + 1));
//			DFS_visit(board, (i) + "" + (j + 1), word.substring(1), adj, visited);
//		}
//		if (i + 1 < board.length && !visited.contains((i + 1) + "" + (j)) && board[i + 1][j] == word.charAt(0)) {
//			adj.add((i + 1) + "" + (j));
//			DFS_visit(board, (i + 1) + "" + (j), word.substring(1), adj, visited);
//		}
		return false;

	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		LC79 lc79 = new LC79();
		System.out.println(lc79.exist(board, "SEE"));

	}
}
