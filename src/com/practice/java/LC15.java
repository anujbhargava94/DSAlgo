package com.practice.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> mainAns2 = new ArrayList<List<Integer>>();
		Set<List<Integer>> mainAns = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {

			int target = 0 - nums[i];
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					int diff = target - nums[j];
					if (map.containsKey(diff) && map.get(diff) != j) {
						List<Integer> ans = new ArrayList<>();
						ans.add(nums[i]);
						ans.add(nums[j]);
						ans.add(diff);
						Collections.sort(ans);
						mainAns.add(ans);
					}
					map.put(nums[j], j);
				}

			}
		}
		for (List<Integer> ans : mainAns) {
			mainAns2.add(ans);
		}
		return mainAns2;
	}

	public static void main(String[] args) {
		LC15 lc = new LC15();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		@SuppressWarnings("unused")
		List<List<Integer>> ans = lc.threeSum(nums);
		System.out.println();
	}
}
