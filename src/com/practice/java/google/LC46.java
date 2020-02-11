package com.practice.java.google;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
	public static void main(String[] args) {
		LC46 lc46 = new LC46();
		int[] input = { 1, 2, 3 };
		List<List<Integer>> ans = lc46.permute(input);
		
		System.out.println();
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0 ) {
			return ans;
		}
		for (int num : nums) {
			List<Integer> temp = new ArrayList<>();
			temp.add(num);
			iterate(temp, ans, nums);
		}
		return ans;
	}

	private void iterate(List<Integer> combination, List<List<Integer>> combinations, int[] nums) {
		if (combination.size() == nums.length) {
			combinations.add(combination);
		} else {
			for (int num : nums) {
				if (!combination.contains(num)) {
					List<Integer> temp = new ArrayList<>();
					temp.addAll(combination);
					temp.add(num);
 					iterate(temp, combinations, nums);
				}
			}
		}

	}
}
