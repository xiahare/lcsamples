package com.xl.study.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] ret = twoSum(nums, target);
		System.out.print(Arrays.toString(ret));

	}

    public static int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> complementsMap = new HashMap<Integer, Integer>();
    	for(int i=0; i<nums.length; i++) {
    		if(complementsMap.get(nums[i])!=null) {
    			return new int[] {complementsMap.get(nums[i]),i};
    		} else {
    			complementsMap.put(target-nums[i], i);
    		}
    	}
    	return null;
    }
}
