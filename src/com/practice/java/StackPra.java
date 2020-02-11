package com.practice.java;

import java.util.Stack;

public class StackPra {

	
	public static void main(String args[]) {
		int ans = getConcat(23,455);
		System.out.println(ans);
	}
	
	
	static public int getConcat(int x,int y)
	{
	    Stack<Integer> remS = new Stack<>();
	    int temp = y;
	    if(y==0)
	    {
	        return x*10;
	    }
	    int rem = 0;
	    while(temp>0)
	    {
	        rem = temp%10;
	        remS.push(rem);
	        temp = temp/10;
	    }
	    while(!remS.isEmpty())
	    {
	        x= x*10+remS.pop();
	    }
	    return x;
	}
}
