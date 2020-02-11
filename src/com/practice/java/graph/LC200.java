package com.practice.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC200 {
	public int numIslands(char[][] grid) {
		int ans = 0;
		Queue<Index> adjQ = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					Index index = new Index(i, j);
					adjQ.add(index);
					BFS(grid, adjQ);
					ans += 1;
				}
			}
		}

		return ans;
	}

	/*
	 * private void BFS(char[][] grid, Index index, Queue<Index> adjQ) { // TODO
	 * Auto-generated method stub int i = index.getI(); int j = index.getJ();
	 * grid[i][j] = '9'; if (i - 1 >= 0 && grid[i - 1][j] == '1') { Index indexT =
	 * new Index(i-1,j); adjQ.add(indexT); } if (j - 1 >= 0 && grid[i][j - 1] ==
	 * '1') { Index indexT = new Index(i,j-1); adjQ.add(indexT); } if (j + 1 <
	 * grid[0].length && grid[i][j + 1] == '1') { Index indexT = new Index(i,j+1);
	 * adjQ.add(indexT); } if (i + 1 < grid.length && grid[i + 1][j] == '1') { Index
	 * indexT = new Index(i+1,j); adjQ.add(indexT); } //grid[i][j] = '9'; while
	 * (!adjQ.isEmpty()) { BFS(grid, adjQ.poll(), adjQ); }
	 * 
	 * }
	 */

	private void BFS(char[][] grid, Queue<Index> adjQ) {
		// TODO Auto-generated method stub
		while (!adjQ.isEmpty()) {
			Index index = adjQ.poll();
			int i = index.getI();
			int j = index.getJ();
			grid[i][j] = '9';
			if (i - 1 >= 0 && grid[i - 1][j] == '1') {
				Index indexT = new Index(i - 1, j);
				adjQ.add(indexT);
			}
			if (j - 1 >= 0 && grid[i][j - 1] == '1') {
				Index indexT = new Index(i, j - 1);
				adjQ.add(indexT);
			}
			if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
				Index indexT = new Index(i, j + 1);
				adjQ.add(indexT);
			}
			if (i + 1 < grid.length && grid[i + 1][j] == '1') {
				Index indexT = new Index(i + 1, j);
				adjQ.add(indexT);
			}
			// grid[i][j] = '9';
		}

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
		LC200 lc200 = new LC200();

		char[][] grid = { { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1',
				'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
				'1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
				'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
				'1', '1', '1' } };
		System.out.println(lc200.numIslands(grid));
	}
}
