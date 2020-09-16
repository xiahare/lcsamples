package com.xl.study.lc;

import java.util.HashMap;
import java.util.Map;

public class No3LengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbb";
		int ret = lengthOfLongestSubstring(s);
		System.out.print(ret);

	}
	
    public static int lengthOfLongestSubstring(String s) {
    	if(s==null || s.length() == 0) {
    		return 0;
    	}
    	Map<Character,Integer> tempLastPositionMap = new HashMap<Character,Integer>();
    	int len = s.length();
    	int[] currentEndCharLongestSubstringLength = new int[len];
    	int[] allLeftLongestSubstringLength = new int[len];
    	// init
    	tempLastPositionMap.put(s.charAt(0), 0);
    	currentEndCharLongestSubstringLength[0] = 1;
    	allLeftLongestSubstringLength[0]=1;
    	for(int i=1; i<len; i++) {
    		Integer c = tempLastPositionMap.get( s.charAt(i) );

    		if( c == null || i-c>currentEndCharLongestSubstringLength[i-1]) {
    			currentEndCharLongestSubstringLength[i] = currentEndCharLongestSubstringLength[i-1] + 1;
    		} else {
    			currentEndCharLongestSubstringLength[i] = i-c;
    		}
    		
    		tempLastPositionMap.put( s.charAt(i), i );
    		
    		allLeftLongestSubstringLength[i] = Math.max(allLeftLongestSubstringLength[i-1], currentEndCharLongestSubstringLength[i]);
    		
    	}
		return allLeftLongestSubstringLength[len-1];
    	
    }

}
