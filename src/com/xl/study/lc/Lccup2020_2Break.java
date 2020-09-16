package com.xl.study.lc;

import java.util.Arrays;

public class Lccup2020_2Break {

	public static void main(String[] args) {
//		int[] staple = {10,20,5};
//		int[] drinks = {5,5,2};
//		int x = 15;
		
		int[] staple = {2,1,1};
		int[] drinks = {8,9,5,1};
		int x = 9;
		int ret = breakfastNumber(staple,drinks,x);
		System.out.println(ret);
	}
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
    	
    	int slen = staple.length;
    	int count = 0;
    	
    	Arrays.sort(staple);
    	Arrays.sort(drinks);
    	
    	
    	for(int i=0; i<slen; i++) {
    		int index = bsearchWithoutRecursion(drinks, x-staple[i]);
    		count = count + index +1;
    	}
    	
    	return count % 1000000007;
    }
    
    public static int bsearchWithoutRecursion(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] > key) {
            	while(mid-1>=0 && a[mid]==a[mid-1]) {
            		mid--;
            	}
                high = mid - 1;
            } else if (a[mid] < key) {
            	while(mid+1<a.length && a[mid]==a[mid+1]) {
            		mid++;
            	}
                low = mid + 1;
            } else {
            	while(mid+1<a.length && a[mid]==a[mid+1]) {
            		mid++;
            	}
                return mid;
            }
        }
        if (a[mid] > key) {
        	
        	return mid-1;
        }
        return mid;
    }
}
