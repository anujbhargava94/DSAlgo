package com.practice.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC438Re {
	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		LC438Re lc = new LC438Re();
		for(Integer a: lc.findAnagrams(s, p)) {
			System.out.print((int)a);
		}
		
	}
	
	
	
	 public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> ans = new LinkedList<>();
	        HashMap<Character, Integer> map2 = getMap(p);
	        HashMap<Character, Integer> map1 = getMap(s.substring(0,p.length()));
	        HashMap<Character, Integer> map = new HashMap<>();
            map.putAll(map1);
	        if(isAna(map, map2)){
	                ans.add(0);
	            }
	        for(int i=1; i<=(s.length()-p.length()); i++)
	        {
	            Character first = s.charAt(i-1);
	            if(map.containsKey(first)){
	                Integer c1 = map.get(first);
	                c1-=1;
	                map.put(first,c1);
	                if(c1==0){
	                    map.remove(first);
	                }
	            }
	            
	            Character last = s.charAt(i+p.length()-1);
	            if(map.containsKey(last)){
	                Integer c2 = map.get(last);
	                c2+=1;
	                map.put(last,c2);
	            }else{
	                map.put(last,1);
	            }
	            if(isAna(map, map2)){
	                ans.add(i);
	            }
	        }
	        return ans;
	    }
	    
	      private boolean isAna(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
		        
	            HashMap<Character, Integer> map = new HashMap<>();
	            map.putAll(map1);
		        for(Character c: map2.keySet()){
	                Integer a = map2.get(c);
	                Integer b = map.get(c);
	                
	                if(a.equals(b)){
	                    map.remove(c);
	                }else{
	                    return false;
	                }
	            }
		        return map.isEmpty();
		    }
	    
	    private HashMap<Character, Integer> getMap(String src){
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
	        
	        return map;
	    }

}
