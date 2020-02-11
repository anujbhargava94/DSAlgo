package com.practice.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class HashMapSortByValues {
	static class Node {
		String key;
		String value;

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}

	}

	private static HashMap<String, String> sorter(HashMap<String, String> map) {
		LinkedList<Map.Entry<String, String>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				// TODO Auto-generated method stub
				if (o1.getValue().compareTo(o2.getValue()) == 0) {
					return 1;
				}
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		HashMap<String, String> temp = new HashMap<>();
		for (Map.Entry<String, String> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("A", "defgh");
		map.put("B", "kefgh");
		map.put("C", "cefgh");
		map.put("D", "defgh");
		map.put("E", "aefgh");
		map.put("F", "lefgh");

		// If you want to avoid creating a new class then create a list using the entry set and
		// sort using the collections sort as described in above function.
		PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.value.compareTo(o2.value) == 0) {
					return 1;
				}
				return o1.value.compareTo(o2.value);
			}
		});

		for (String key : map.keySet()) {
			que.add(new Node(key, map.get(key)));
		}

		while (!que.isEmpty()) {
			Node a = que.poll();
			System.out.println(a.key + ' ' + a.value);
		}
	}

}
