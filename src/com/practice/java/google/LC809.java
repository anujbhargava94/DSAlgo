package com.practice.java.google;

public class LC809 {
	public int expressiveWords(String S, String[] words) {
		S = reduce(S);
		// System.out.println(S);
		int ans = 0;
		for (String word : words) {
			if (S.equals(reduce(word))) {
				ans += 1;
			}
		}
		return ans;
	}

	private String reduce(String word) {
		char curr = word.charAt(0);
		int count = 1;
		String ans = "";
		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) != curr) {
				if (count < 3) {
					while (count > 0) {
						ans += curr;
						count -= 1;
					}
				} else {
					ans += curr;
				}
				count = 1;
				curr = word.charAt(i);
			} else {
				count += 1;
			}
		}
		ans+=curr;
		//System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		String S = "heeellooo";
		String[] words = { "hello", "hi", "helo" };
		LC809 lc = new LC809();
		System.out.println(lc.expressiveWords(S, words));
	}
}
