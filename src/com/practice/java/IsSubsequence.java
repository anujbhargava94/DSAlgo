package com.practice.java;

public class IsSubsequence {
	public static void main(String[] args) {
		IsSubsequence sol = new IsSubsequence();
		System.out.println(sol.logic("xyazacbcsd", "xcsd"));
	}

	private boolean logic(String word, String sub) {
		if (sub.length() == 0) {
			return true;
		}
		if (word.length() == 0 && sub.length() > 0) {
			return false;
		}
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == sub.charAt(0)) {
				return logic(word.substring(i + 1), sub.substring(1));
			}
		}
		return false;
	}
}
