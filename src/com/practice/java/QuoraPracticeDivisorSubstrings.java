package com.practice.java;

import java.math.BigInteger;

public class QuoraPracticeDivisorSubstrings {

	public static void main(String args[]) {

		Integer givenNumber = 23456789;
		int k = 3;
		int div = (int) Math.pow(10, k);
		System.out.println(div);
		Integer current = givenNumber;
		Integer temp;
		do {
			temp = current % div;
			System.out.println(temp);
			current = current /10;
		} while ((current / div) > 0);
	}

}
