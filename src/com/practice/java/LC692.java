package com.practice.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC692 {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (map.containsKey(word)) {
				int freq = map.get(word);
				map.put(word, freq += 1);
			} else {
				map.put(word, 1);
			}
		}
		int count =0;
		map = sortByValue(map);
		List<String> ans = new ArrayList<>();
		for(String word: map.keySet()) {
			ans.add(word);
			count+=1;
			if(count == k) {
				break;
			}
		}
		//Collections.sort(ans);
		return ans;
		
	}

	public static HashMap<String, Integer> sortByValue(Map<String, Integer> map) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if(o1.getValue() > o2.getValue()) {
					return -1;
				}
				if(o1.getValue()<o2.getValue()) {
					return 1;
				}
				if(o1.getValue() == o2.getValue()) {
					return (o1.getKey().compareTo(o2.getKey()));
				}
				return 0;
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public static void main(String[] args) {
		LC692 lc = new LC692();
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		List<String> ans = lc.topKFrequent(words, 4);
		System.out.println();
	}

}
