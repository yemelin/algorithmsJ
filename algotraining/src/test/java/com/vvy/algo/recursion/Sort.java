package com.vvy.algo.recursion;

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
	
}
