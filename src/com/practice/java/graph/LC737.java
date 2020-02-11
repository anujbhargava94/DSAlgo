package com.practice.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LC737 {
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

		if (words1.length != words2.length) {
			return false;
		}
		Map<String, List<String>> adj = makeGraph(pairs);
		int count = 0;
		for (int i = 0; i < words1.length; i++) {
			if (dfsNonRec(adj, words1[i], words2[i])) {
				count += 1;
			}
		}
		return count == words1.length;
	}

	private boolean dfs_visit(Map<String, List<String>> adj, String node1, String dest) {
		// TODO Auto-generated method stub
		List<String> temp = adj.get(node1);
		List<String> visited = new ArrayList<>();
		if (temp == null) {
			return false;
		}
		for (String source : temp) {
			if (source.equals(dest)) {
				return true;
			}
			visited.add(source);
			return dfs(adj, source, dest, visited);
		}
		return false;
	}

	private boolean dfs(Map<String, List<String>> adj, String source, String dest, List<String> visited) {
		// TODO Auto-generated method stub

		List<String> temp = adj.get(source);
		for (String node : temp) {
			if (node.equals(dest)) {
				return true;
			}
			if (!visited.contains(node)) {
				visited.add(node);
				boolean found = dfs(adj, node, dest, visited);
				if (found) {
					return found;
				}
			}
		}
		return false; // TODO correct this
	}

	private boolean dfsNonRec(Map<String, List<String>> adj, String source, String dest) {
		// TODO Auto-generated method stub
		List<String> visited = new ArrayList<>();
		List<String> temp = adj.get(source);
		if (temp == null) {
			return false;
		}
		Stack<String> bucket = new Stack<>();
		visited.add(source);
		for (String name : temp) {
			if (!visited.contains(name)) {
				bucket.add(name);
			}
		}

		while (!bucket.isEmpty()) {
			String current = bucket.pop();
			if (current.equals(dest)) {
				return true;
			} else {
				List<String> tempC = adj.get(current);
				visited.add(current);
				for (String name : tempC) {
					if (!visited.contains(name)) {
						bucket.add(name);
					}
				}
			}
		}
		return false;
	}

	private Map<String, List<String>> makeGraph(List<List<String>> pairs) {
		// TODO Auto-generated method stub
		Map<String, List<String>> adj = new HashMap<>();
		for (List<String> pair : pairs) {
			List<String> l1 = new ArrayList<>();
			if (!adj.containsKey(pair.get(0))) {
				l1.add(pair.get(1));
				adj.put(pair.get(0), l1);
			} else {
				l1 = adj.get(pair.get(0));
				l1.add(pair.get(1));
			}
			List<String> l2 = new ArrayList<>();
			if (!adj.containsKey(pair.get(1))) {
				l2.add(pair.get(0));
				adj.put(pair.get(1), l2);
			} else {
				l2 = adj.get(pair.get(1));
				l2.add(pair.get(0));
			}
		}
		String abc = new String();
		return adj;

	}

	public static void main(String[] args) {
		LC737 lc = new LC737();
		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		List<List<String>> pairs = new ArrayList<List<String>>();
		List<String> l1 = new ArrayList<>();
		l1.add("great");
		l1.add("good");
		pairs.add(l1);

		List<String> l2 = new ArrayList<>();
		l2.add("fine");
		l2.add("good");
		pairs.add(l2);

		List<String> l3 = new ArrayList<>();
		l3.add("acting");
		l3.add("drama");
		pairs.add(l3);

		List<String> l4 = new ArrayList<>();
		l4.add("skills");
		l4.add("talent");
		pairs.add(l4);
		System.out.println(lc.areSentencesSimilarTwo(words1, words2, pairs));
	}
}
