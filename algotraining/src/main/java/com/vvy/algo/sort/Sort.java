package com.vvy.algo.sort;

public class Sort {

	private static void swap (int[]a, int i, int j) {
		int tmp = a[i]; a[i] = a[j]; a[j] = tmp;	
	}
	
	public static boolean isSorted (int[] a) {
		int i = 0;
		while (i<=a.length-2 && a[i]<=a[i+1])
			i++;
		return (i==a.length-1 || a.length==0);
	}
	

/** notorious bubble sort */	
	public static void bubble(int[] a) {
		for (int i=0; i<a.length-1; i++) {
			for (int j=0; j<a.length-i-1; j++) {
				if (a[j]>a[j+1]) {
					swap(a, j,j+1);
				}
			}
		}
	}
	
/** recursive bubble */	
	private static void bubbleRec(int[] a, int top) {
		for (int j=0; j<top; j++) {
			if (a[j]>a[j+1]) {
				swap(a, j,j+1);
			}
		}
		if (top>0)
			bubbleRec(a, top-1);
	}
	public static void bubbleRec(int[] a) {
		bubbleRec(a,a.length-1);
	}
	
/** merge sort */
	private static void mergeSortedParts (int[] a, int lo, int mid, int hi) {
		int i=lo; int j = mid+1; int k=0;
		int[] tmp = new int[hi-lo+1];
		while (i<mid+1 && j<hi+1) {
			if (a[i]>a[j]) {
				tmp[k++] = a[j];
				j++;
			}
			else {
				tmp[k++] = a[i];
				i++;
			}
		}
		if (i<mid+1) {
			System.arraycopy(a, i, a, lo+k, mid-i+1);
		}
		System.arraycopy(tmp, 0, a, lo, k);
	}
	
	private static void mergeSort (int[] a, int lo, int hi) {
		if (lo<hi) {
			int mid = lo+(hi-lo)/2;
			
			mergeSort(a, lo, mid);
			mergeSort(a, mid+1, hi);
			
			mergeSortedParts(a, lo, mid, hi);
		}
	}
	
	public static void mergeSort (int[] a) {
		mergeSort(a,0,a.length-1);
	}
	
	public static void main(String[] args) {
		int[]a = {1,3,5,8,2,4,6,7};
//		int[]a = {1,3,5,6,4,4,2};
//		mergeSortedParts(a, 0, 4, 7);
		mergeSort(a, 0, a.length-1);
		for (int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
