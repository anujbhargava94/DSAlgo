package com.practice.java.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {

	private Map<String, String> keypad = new HashMap<>();

	public LC17() {
		keypad.put("2", "abc");
		keypad.put("3", "def");
		keypad.put("4", "ghi");
		keypad.put("5", "jkl");
		keypad.put("6", "mno");
		keypad.put("7", "pqrs");
		keypad.put("8", "tuv");
		keypad.put("9", "wxyz");
	}

	public List<String> letterCombinations(String digits) {
		String keys = keypad.get(digits.substring(0, 1));
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < keys.length(); i++) {
			makeCombination(digits.substring(1), keys.substring(i, i + 1), ans);
		}
		return ans;
	}

	private void makeCombination(String digits, String keyChar, List<String> combinations) {
		if (digits != null && !digits.isEmpty()) {
			String keys = keypad.get(digits.substring(0, 1));
			for (int i = 0; i < keys.length(); i++) {
				makeCombination(digits.substring(1), keyChar + keys.substring(i, i + 1), combinations);
			}
		} else {
			combinations.add(keyChar);
		}
	}

	public static void main(String[] args) {
		LC17 lc17 = new LC17();
		List<String> answers = lc17.letterCombinations("345");
		for(String ans:answers) {
			System.out.println(ans);
		}
	}
}
