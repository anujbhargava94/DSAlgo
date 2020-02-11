package com.practice.java;

public class IsSubstring {
	public static void main(String[] args) {
		IsSubstring sol = new IsSubstring();
		System.out.println(sol.logic("xyabzabsdc", "abc"));
	}

	private boolean logic(String word, String sub) {
		boolean ans = false;
		int j = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == sub.charAt(j)) {
				j += 1;
				if(j>=sub.length()) {
					break;
				}
			} else {
				j = 0;
			}
		}
		if (j == sub.length())
			ans = true;
		return ans;
	}
}
