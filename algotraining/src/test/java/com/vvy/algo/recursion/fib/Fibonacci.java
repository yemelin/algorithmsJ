package com.vvy.algo.recursion.fib;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
	
	private static long base(int n) {
		return (n<0) ? -1 : n;
	}
	
	public static long fib (int n) {
		if (n<0)
			return -1;
		if (n==1 || n==0)
			return n;
		long prev1 = 0, prev2 = 1, sum = 0;
		while (n-- >1) {
			sum = prev2+prev1;
			prev1 = prev2;
			prev2 = sum;
		}
		return sum;
	}
	
	public static long dumbRecFib (int n) {	
		return (n<2) ? base(n) : dumbRecFib(n-1)+dumbRecFib(n-2);
	}
	
	private static long recFibNoMemo (long prev1, long prev2, int n) {
		return (n>2) ? recFibNoMemo(prev2, prev1+prev2, --n) : prev1+prev2;
	}
	
	public static long recFibNoMemo (int n) {
		return (n<2) ? base(n) : recFibNoMemo(0,1,n);
	}
	
/** not yet implemented */	
	static List<Long> memo = new ArrayList<Long>();
	public static long recFibMemo(int n) {
		if (memo.size()>=n+1)
			return memo.get(n);
		else if (memo.size()==n) {
			long ret = memo.get(n-1)+memo.get(n-2);
			memo.add(ret);
			return ret;
		}
		else return recFibMemo(n-2)+recFibMemo(n-1);		
	}
}
