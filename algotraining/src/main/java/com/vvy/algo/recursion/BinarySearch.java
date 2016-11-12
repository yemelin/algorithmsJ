package com.vvy.algo.recursion;

public class BinarySearch {

/** canonical binary search */	
	public static int find (int[] sorted, int n) {
		int lo = 0, hi = sorted.length-1;
		while (hi>=lo) {
			int mid = lo+(hi-lo)/2;
			if (n>sorted[mid])
				lo = mid+1;
			else if (n<sorted[mid])
				hi=mid-1;
			else return mid;
		}
		return -1;
	}
	
/** recursive binary search */	
	private static int _findRec(int[] sorted, int lo, int hi, int n) {
		int ret = -1;
		if (hi>=lo) {
			int mid = lo+(hi-lo)/2;
			if (n>sorted[mid])
				ret = _findRec(sorted, mid+1, hi, n);
			else if (n<sorted[mid])
				ret = _findRec(sorted,lo, mid-1, n);
			else return mid;			
		}
		return ret;
	}
	
	public static int findRec (int[] sorted, int n) {
		return _findRec(sorted,0,sorted.length-1,n);
	}
}
