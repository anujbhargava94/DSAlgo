package com.practice.java;

interface IFuncModi {
	String f(int n, String a);
}
interface IFunc {
	int f(int n);
}

interface ITest {
	boolean p(int n);
}

public class Lambda {
	public static void main(String[] args) {
		
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for(String x : map(a, (int n, String b) -> b+n*n)) 
			System.out.println(x);
		System.out.println("-----Modi---------");
		
		for(int x : map(a, (int n) -> n*n)) 
			System.out.println(x);
		System.out.println("--------------");
		
		System.out.println("mapsum = " + mapsum(a, n -> n * n));
		System.out.println("--------------");

		System.out.print("filter = [" );
		for(int x : filter(a, n -> n % 3 == 0))
			System.out.print(x + " ");
		System.out.println("]" );
	}
	
	static int[] map(int[] a,  IFunc o) {
		  int[] b = new int[a.length];                     
		  for(int i=0;  i < a.length;  i++) {
		       b[i] = o.f(a[i]);
		  }
		  return b;
		}
	
	static String[] map(int[] a,  IFuncModi o) {
		  String[] b = new String[a.length];   
		  String random = "abdc";
		  for(int i=0;  i < a.length;  i++) {
		       b[i] = o.f(a[i], random);
		  }
		  return b;
		}
	

	static int mapsum(int[] a, IFunc o) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + o.f(a[i]);
		}
		;
		return sum;
	}
	
	static int[] filter(int[] a,  ITest o) {
		  int len = 0; 
		  int i, j;
		  for (i=0;  i < a.length;  i++) 
		           if ( o.p(a[i]) ) 
		        	   len++;
			  
		  int[] b = new int[len]; 

		  j = 0;
		  for (i=0;  i < a.length;  i++) 
		           if ( o.p(a[i]) ) {
		        	   b[j] = a[i];	
		        	   j++;
		           }  
		  return b;
	}
}
