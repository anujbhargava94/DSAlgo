package com.practice.java;

import java.util.ArrayList;

public class LC34 {
	public static void main(String[] args) {
		LC34 lc = new LC34();
		int[] nums = {2,2};
		int target = 3;
		lc.searchRange(nums, target);
		ArrayList<Integer> arr = new ArrayList<>();
	}
	
	
	public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length == 0){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        int curr = binarySearch(nums, target, 0, nums.length-1);
        if(curr==-1){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        int min =curr;
        int max =curr;
        int temp =min;
        int i=temp-1;
        while(temp!=-1 && i>0){
            temp = binarySearch(nums, target, 0, i);
            if(temp !=-1 && temp<min ){
               min = temp ;
            }
            i-=1;
        }
        temp=max;
        i=temp+1;
        while(temp!=-1 && i<nums.length){
            temp = binarySearch(nums, target, i, nums.length);
            if(temp !=-1 && temp>max){
               max = temp ;
            }
            i+=1;
        }
        ans[0]=min;
        ans[1]=max;
        return ans;
        
    }
    
    private int binarySearch(int[] nums, int target, int p, int q){
        if(p>q){
            return -1;
        }
        int mid = (p+q)/2;
        
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid]>target){
            return binarySearch(nums, target, p, mid-1);
        }
        else{
            return binarySearch(nums, target, mid+1, q);
        }
        
    }

}
