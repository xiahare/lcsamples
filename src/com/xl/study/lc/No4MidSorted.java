package com.xl.study.lc;

public class No4MidSorted {

	public static void main(String[] args) {
		int[] nums1= {1,2};
		int[] nums2= {3};
//		int[] nums1= {1,3,5,11,13};
//		int[] nums2= {2,4,6,7,8,10};
		double ret = midSortedVal(nums1,nums2);
		System.out.println(ret);
	}
	
	public static double midSortedVal(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length;
		if( (totalLength & 1) == 0) {
			return getValKth(nums1,nums2,totalLength/2 - 1,true)/2.0;
			
		} else {
			return getValKth(nums1,nums2,totalLength/2,false)/1.0;
		}
	}
	
	public static int getValKth(int[] nums1, int[] nums2, int k, boolean sumNext) {
		int index1 = 0;
		int index2 = 0;
		
		int ret = -1;
		
		while(true)
		{
			if(index1+index2==k) {
				// k ==1 
				if(getArrayVal(nums1,index1)>getArrayVal(nums2,index2)) {
					ret = getArrayVal(nums2,index2++);
				} else {
					ret = getArrayVal(nums1,index1++);
				}
				
				if(sumNext) {
					if(getArrayVal(nums1,index1)>getArrayVal(nums2,index2)) {
						ret = ret + getArrayVal(nums2,index2++);
					} else {
						ret = ret + getArrayVal(nums1,index1++);
					}
				}
				
				return ret;
			} else {
				// binary search, (k+1)/2
				int move = (k-index1-index2+1)/2;
				if(getArrayVal(nums1,index1+move-1)>getArrayVal(nums2,index2+move-1)) {
					index2 = index2+move;
				} else {
					index1 = index1+move;
				}
			}
		}
	}
	
	public static int getArrayVal(int[] nums, int index) {
		if(index>=nums.length) {
			return Integer.MAX_VALUE;
		}
		return nums[index];
	}

}
