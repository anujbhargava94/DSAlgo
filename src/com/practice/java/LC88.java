package com.practice.java;

public class LC88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i-=1;
                k-=1;
            }else if (nums1[i]<nums2[j]){
                nums1[k] = nums2[j];
                j-=1;
                k-=1;
            }else{
                nums1[k] = nums1[i];
                k-=1;
                nums1[k] = nums2[j];
                k-=1;
                i-=1;
                j-=1;
            }
        }
        while(j>=0){
            nums1[k] = nums2[j];
            k-=1;
            j-=1;
        }
    }
	
	public static void main(String[] args) {
		LC88 lc = new LC88();
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		
		lc.merge(nums1, 3, nums2, 3);
		
	}
}
