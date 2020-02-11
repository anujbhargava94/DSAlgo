package com.practice.java;

public class BinarySearch {

	public static void main(String[] args) {
		//int[] A = { 1,1,2,3,4,6,6,7,8,9};
		int[] A = {1};
		int num = 1;
		int low = 0;
		int high = A.length;
		System.out.print(binarySearch(A,num,low,high));
		int[] a = {1,2};
		int abc = 1/2;
		System.out.println(abc+"");

	}

	public static int binarySearch(int[] A, int num, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (A[mid] == num) {
			return mid;
		}

		if (A[mid] > num) {
			return binarySearch(A, num, low, mid - 1);
		} else {
			return binarySearch(A, num, mid + 1, high);
		}
	}
}
