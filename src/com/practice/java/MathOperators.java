package com.practice.java;

import java.util.Random;

public class MathOperators {
	public static void main(String[] args) {
		int a =-5;
		int b = -2;
		
		Random ra = new Random();
		int temp = ra.nextInt((b-a)+1)+a;
		
		int ans = (temp)%b;
		System.out.println(temp);
	}

}
