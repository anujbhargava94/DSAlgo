package com.practice.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private void traversalBFS(int[][] Adj) {
		Map<Integer, Integer> distance = new HashMap<>();
		Map<Integer, Integer> parent = new HashMap<>();
		List<Integer> visited = new ArrayList<>();

		Queue<Integer> tobe = new LinkedList<>();
		distance.put(0, 0);
		parent.put(0, 0);

		tobe.add(0);
		while (!tobe.isEmpty()) {
			int tobeVisit = tobe.poll();

			for (int vertex : Adj[tobeVisit]) {
				if (!visited.contains(vertex)) {
					{
						tobe.add(vertex);
						distance.put(vertex, distance.get(tobeVisit) + 1);
						parent.put(vertex, tobeVisit);
					}
				}
			}
			visited.add(tobeVisit);
		}

	}

	private void traversalBFS(Map<Integer, List<Integer>> Adj) {
		Map<Integer, Integer> distance = new HashMap<>();
		Map<Integer, Integer> parent = new HashMap<>();
		List<Integer> visited = new ArrayList<>();

		Queue<Integer> tobe = new LinkedList<>();
		distance.put(0, 0);
		parent.put(0, 0);

		tobe.add(0);
		while (!tobe.isEmpty()) {
			int tobeVisit = tobe.poll();

			for (int vertex : Adj.get(tobeVisit)) {
				if (!visited.contains(vertex)) {
					{
						tobe.add(vertex);
						distance.put(vertex, distance.get(tobeVisit) + 1);
						parent.put(vertex, tobeVisit);
					}
				}
			}
			visited.add(tobeVisit);
		}
	}

	private void trversalDFS(Map<Integer, List<Integer>> Adj) {
		Map<Integer, Integer> distance = new HashMap();
		Map<Integer, Integer> parent = new HashMap();
		List<Integer> visited = new ArrayList<>();
		distance.put(0, 0);
		parent.put(0, 0);

		for (int vertex : Adj.keySet()) {

			if (!visited.contains(vertex)) {
				{
					visitDFS(vertex, Adj, visited, distance, parent);
				}

			}
		}

	}

	private void visitDFS(int vertex, Map<Integer, List<Integer>> Adj, List<Integer> visited,
			Map<Integer, Integer> distance, Map<Integer, Integer> parent) {

		for (int adjVertex : Adj.get(vertex)) {
			distance.put(vertex, distance.get(adjVertex) + 1);
			parent.put(vertex, adjVertex);
			if (!visited.contains(adjVertex)) {
				visitDFS(adjVertex, Adj, visited, distance, parent);
			}

		}
		visited.add(vertex);
	}

}
