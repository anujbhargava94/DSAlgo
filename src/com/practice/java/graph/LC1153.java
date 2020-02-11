package com.practice.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LC1153 {
	public boolean canConvert(String str1, String str2) {
		Map<Character, ArrayList<Character>> graph = new HashMap<>();
		graph = makeGraph(str1, str2);
		boolean cyclePresent = isCycle(graph);
		return !cyclePresent;

	}

	private boolean isCycle(Map<Character, ArrayList<Character>> graph) {
		// TODO Auto-generated method stub
		for (Character vertex : graph.keySet()) {
			List<Character> visited = new ArrayList<>();
			Stack<Character> bucket = new Stack<>();
			bucket.add(vertex);
			visited.add(vertex);
			while (!bucket.isEmpty()) {
				Character curr = bucket.pop();
				List<Character> currV = graph.get(curr);
				if (currV != null) {
					for (Character node : currV) {
						if (visited.contains(node)) {
							return true;
						}
						bucket.add(node);
					}
					visited.add(curr);
				}
			}
		}
		return false;
	}

	private Map<Character, ArrayList<Character>> makeGraph(String str1, String str2) {
		Map<Character, ArrayList<Character>> graph = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			if (!graph.containsKey(str1.charAt(i))) {
				graph.put(str1.charAt(i), new ArrayList<>());
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			ArrayList<Character> temp = graph.get(str1.charAt(i));
			// if (!temp.isEmpty() && !temp.contains(str2.charAt(i))) {
			// return null;
			// } else {
			temp.add(str2.charAt(i));
		}
		// }
		return graph;
	}

	public static void main(String[] args) {
		LC1153 lc = new LC1153();
		System.out.println(lc.canConvert("aabcc", "ccdee"));
	}
}
