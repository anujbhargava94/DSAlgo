package com.practice.java;

public class LC5 {
	public String longestPalindrome(String s) {
		return findPalindromedp(s);
	}

	private String findPalindrome(String s, String pal) {
		String ans = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		if (s.length() <= 1) {
			return pal;
		}
		if (s.substring(0, 1).equals(s.substring(s.length() - 1, s.length()))) {
			if (s.length() <= 3)
				return pal;
			ans1 = findPalindrome(s.substring(1, s.length() - 1), pal);
			if (ans.length() < ans1.length())
				;
			ans = ans1;
		}
		if (!s.substring(0, 1).equals(s.substring(s.length() - 1, s.length()))) {
			ans2 = findPalindrome(s.substring(1, s.length()), pal.substring(1, s.length()));
			if (ans.length() < ans2.length())
				;
			ans = ans2;
			ans3 = findPalindrome(s.substring(0, s.length() - 1), pal.substring(0, s.length() - 1));
			if (ans.length() < ans3.length())
				;
			ans = ans3;
		}
		pal = ans;
		return ans;
	}

	private String findPalindrome2(String s, String pali) {
		String ans = "";
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		if (s.length() < 2) {
			return pali;
		}

		if (!s.substring(0, 1).equals(s.substring(s.length() - 1, s.length()))) {
			pali = s.substring(1, s.length());
			ans1 = findPalindrome2(pali, pali);
			if (ans.length() < ans1.length())
				;
			ans = ans1;
			pali = s.substring(0, s.length() - 1);
			ans2 = findPalindrome2(pali, pali);
			if (ans.length() < ans2.length())
				;
			ans = ans2;
			pali = s.substring(1, s.length() - 1);
			ans3 = findPalindrome2(pali, pali);
			if (ans.length() < ans3.length())
				;
			ans = ans3;
		} else {
			ans1 = findPalindrome2(s.substring(1, s.length()), pali);
			if (ans.length() < ans1.length())
				;
			ans = ans1;
			ans2 = findPalindrome2(s.substring(0, s.length() - 1), pali);
			if (ans.length() < ans2.length())
				;
			ans = ans2;
			ans3 = findPalindrome2(s.substring(1, s.length() - 1), pali);
			if (ans.length() < ans3.length())
				;
			ans = ans3;

		}
		return ans;

	}

	private String findPalindromedp(String s) {
		if (s.isEmpty()) {
			return s;
		}
		boolean[][] pali = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			pali[i][i] = true;
		}

		int start = 0;
		int end = 1;

		for (int i = 0; i < s.length() - 1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				pali[i][i + 1] = true;
				start = i;
				end = 2;
			}
		}
		for (int i = 2; i < s.length() + 1; i++) {
			for (int j = i - 1; j < s.length(); j++) {
				int k = j - i + 1;
				if (s.charAt(j) == s.charAt(k) && pali[k + 1][j - 1]) {
					pali[k][j] = true;
					if (i > end) {
						end = i;
						start = k;
					}
				}
			}
		}
		return s.substring(start, start + end);

	}

	public static void main(String[] args) {
		LC5 lc5 = new LC5();
		System.out.println(lc5.longestPalindrome(""));

	}
}
