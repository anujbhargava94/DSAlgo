package com.practice.java.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC695 {
	
	public static void main(String[] args) {
		LC695 lc = new LC695();
		//int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		//int[][] grid = {{0,1},{1,1}};
		System.out.println(lc.maxAreaOfIsland(grid));
	}
	public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int curr=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] ==1){
                   curr = isIsland(grid, i, j);
                    if(curr>max){
                        max = curr;
                    }
                }
            }
        }
        return max;
        
    }
    
    private int isIsland(int[][] grid, int m, int n){
        Stack<Node> st = new Stack<>();
        Set<String> visited = new HashSet<>();
        
        st.add(new Node(m,n));
        visited.add(m+" "+n);
        int count =0;
        while(!st.isEmpty()){
            Node curr = st.pop();
            int i = curr.getRow();
            int j = curr.getCol();
            if(i-1>=0 && !visited.contains((i-1)+" "+j) && grid[i-1][j]==1){
            	visited.add((i-1)+" "+j);
                st.add(new Node(i-1,j));
            }
            if(j-1>=0 && !visited.contains((i)+" "+(j-1)) && grid[i][j-1]==1){
            	visited.add((i)+" "+(j-1));
                st.add(new Node(i,j-1));
            }
            if(i+1<grid.length && !visited.contains((i+1)+" "+j) && grid[i+1][j]==1){
            	visited.add((i+1)+" "+j);
                st.add(new Node(i+1,j));
            }
            if(j+1<grid[0].length && !visited.contains((i)+" "+(j+1)) && grid[i][j+1]==1){
            	visited.add((i)+" "+(j+1));
                st.add(new Node(i,j+1));
            }
            count+=1;
            
            grid[i][j] = -1;
        }
        return count;
    }
    
    class Node{
        private int r;
        private int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        public int getRow(){
            return this.r;
        }
        
        public int getCol(){
            return c;
        }
    }

}
