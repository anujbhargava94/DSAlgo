package com.practice.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC973 {
	public static void main(String[] args) {
		LC973 lc = new LC973();
		int[][] points = {{0,1},{1,0}};
		lc.kClosest(points, 2);
	}

	 public int[][] kClosest(int[][] points, int K) {
	        int[] dist = new int[points.length];
	        int[][] ans = new int[K][2];
	        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
	        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
	        int count =0;
	        for(int i =0; i<points.length; i++){
	            dist[i] = (int)(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
	            if(count<K){
	                que.add(dist[i]);
	            }else if(que.peek()>dist[i]){
	                que.remove();
	                que.add(dist[i]);
	            }
	            LinkedList<Integer> temp = new LinkedList<>();
	            temp.add(points[i][0]);
	            temp.add(points[i][1]);
	            
	            map.put(dist[i], temp);
	            count+=1;
	        }
	        int i =0;
	        while(!que.isEmpty()){
	            Integer d = que.poll();
	            LinkedList<Integer> temp = map.get(d);
	            
	            ans[i][0] = temp.get(0);
	            ans[i][1] = temp.get(1);
	            i+=1;
	        }
	        return ans;
	    }
}
