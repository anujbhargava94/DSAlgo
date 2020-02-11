package com.practice.java;

public class CountingSort {
	public void docCountsort(int[] arr) {
		int[] count = new int[10];
		int[] sortArr = new int[arr.length];
		for (int i = 0; i < 10; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
		}

		for (int i = 1; i < 10; i++) {

			count[i] += count[i - 1];
		}

		for (int i = 0; i < arr.length; i++) {
			sortArr[count[arr[i]]-1] = arr[i];
			count[arr[i]]-=1;
		}

		arr = sortArr;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 5, 6, 6, 6, 1, 1, 1, 8, 9, 9, 9, 7, 7, 4, 4, 5 };
		CountingSort cs = new CountingSort();
		cs.docCountsort(arr);

	}

}
