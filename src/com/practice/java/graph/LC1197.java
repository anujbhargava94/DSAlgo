package com.practice.java.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC1197 {

	public int minKnightMoves(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		que.add(new Node(0, 0));
		int ans = 0;
		while (!que.isEmpty()) {

			int size = que.size();
			while (size > 0) {
				Node current = que.poll();

				if (current != null && current.getX() == x && current.getY() == y) {
					return ans;
				}
				if (current == null) {
					ans += 1;
					if (!que.isEmpty()) {
						current = que.poll();
					} else {
						return ans;
					}
				}
				int currX = current.getX();
				int currY = current.getY();

				addNode(currX - 2, currY + 1, visited, que);
				addNode(currX - 1, currY + 2, visited, que);
				addNode(currX + 1, currY + 2, visited, que);
				addNode(currX + 2, currY + 1, visited, que);
				addNode(currX + 2, currY - 1, visited, que);
				addNode(currX + 1, currY - 2, visited, que);
				addNode(currX - 1, currY - 2, visited, que);
				addNode(currX - 2, currY - 1, visited, que);
				size -= 1;
			}
			ans += 1;
		}
		return ans;
	}

	private void addNode(int x, int y, Set<String> visited, Queue<Node> que) {
		if (!visited.contains((new Node(x, y).toString()))) {
			visited.add((new Node(x, y).toString()));
			que.add(new Node(x, y));
		}
	}

	public static void main(String[] args) {
		LC1197 lc = new LC1197();
		System.out.println(lc.minKnightMoves(5, 5));
	}

	class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}

}
