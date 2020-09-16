package com.xl.study.lc;

public class Lccup2020_3Leaves {
	public static void main(String[] args) {
		String leaves = "rrryyyrryyyrr";
		int ret = minimumOperations(leaves);
//		String leaves = "ryr";
//		int ret = minimumOperations(leaves);
		System.out.println(ret);
	}
	
    public static int minimumOperations(String leaves) {

    	int len = leaves.length();
        int minCount = len;
    	
    	for(int indexA=1; indexA < len-1; indexA++) {
			// 0 ~ indexA
			int m1 = reverseCount(leaves, 0, indexA, 'y');
			
    		for(int indexB=indexA+1; indexB < len; indexB++) {

    			// indexA ~ indexB
    			int m2 = reverseCount(leaves, indexA, indexB, 'r');
    			// indexB ~ len
    			int m3 = reverseCount(leaves, indexB, len, 'y');
    			
    			int count = m1+m2+m3;
    			if ( minCount > count) {
    				minCount = count;
    			}
    		}
    	}
    	
    	return minCount;
    }
    
    public static int reverseCount( String leaves, int start, int end, char needReversingChar ) {

    	int count = 0;
    	
    	for ( int i = start; i< end; i++) {
    		if (leaves.charAt(i) == needReversingChar ) {
    			count++;
    		}
    		
    	}
    	
    	return count;
    }
}
