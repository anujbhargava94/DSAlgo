package com.practice.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC438 {
	public static void main(String[] args) {
		String s = "baa";
		String p = "aa";
		LC438 lc = new LC438();
		for(Integer a: lc.findAnagrams(s, p)) {
			System.out.print((int)a);
		}
		
	}
	
	    public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> ans = new LinkedList<>();
	        for(int i =0; i<=(s.length()-p.length()); i++)
	        {
	            if(isAna(s.substring(i,i+p.length()), p)){
	                ans.add(i);
	            }
	        }
	        return ans;
	    }
	    
	    private boolean isAna(String src, String v){
	        HashMap<Character, Integer> map = new HashMap<>();
	        for(int i=0; i<src.length(); i++){
	            Character c = src.charAt(i);
	            if(map.containsKey(c)){
	                Integer val = map.get(c);
	                val+=1;
	                map.put(c, val);
	                
	            }else{
	                map.put(c,1);
	            }
	        }
	        
	        for(int i =0; i<v.length();i++){
	            Character c = v.charAt(i);
	            if(!map.containsKey(c)){
	                return false;
	            }
	            else{
	                Integer count = map.get(c);
	                count-=1;
	                map.put(c, count);
	                if(count==0){
	                    map.remove(c);
	                }
	                
	            }
	        }
	        return map.isEmpty();
	    }

}
