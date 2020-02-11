package com.practice.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapPractice {

	public static void main(String args[]) {
		Map<Character, Integer> freqMap = new HashMap();

		String givenStr = "aaaabbbbcccc";
		String comparableString = "bcdeeefff";
		char[] strChar = givenStr.toCharArray();
		System.out.println(strChar[8]);
		for (int i = 0; i < strChar.length; i++) {
			if (freqMap.containsKey(strChar[i])) {
				Integer count = freqMap.get(strChar[i]);
				count++;
				freqMap.put(strChar[i], count);
			} else {
				freqMap.put(strChar[i], 1);
			}
		}

		Iterator mapIter = freqMap.entrySet().iterator();

		while (mapIter.hasNext()) {
			System.out.println(mapIter.next());
		}

	}

}
