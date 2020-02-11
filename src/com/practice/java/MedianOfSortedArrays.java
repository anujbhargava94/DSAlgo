package com.practice.java;

public class MedianOfSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double size = Math.floor((nums1.length + nums2.length) / 2);

		double count = 0.0;
		int i = 0, j = 0;
		double ans = 0.0;
		while (count < size && i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				if (i < nums1.length - 1)
					i += 1;
			} else {
				if (j < nums2.length - 1)
					j += 1;
			}
			count += 1;
		}

		if (count < size && i < nums1.length) {
			while (count >= size) {
				i = i + 1;
				count += 1;
			}
		} else if (count < size && j < nums2.length) {
			while (count >= size) {
				j = j + 1;
				count += 1;
			}
		}
		if (size % 2 == 0) {
			ans = (double) (nums1[i] + nums2[j]) / 2;
		} else {
			if (nums1[i] < nums2[j]) {
				ans = nums1[i];
			} else {
				ans = nums2[j];
			}
		}
		return ans;
	}

}
