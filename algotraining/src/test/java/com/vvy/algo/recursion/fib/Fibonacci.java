package com.vvy.algo.recursion.fib;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vvy
 */

public class Fibonacci {

/** used in every implementation, thus simplifies the code */
	private static long base(int n) {
		return (n<0) ? -1 : n;
	}

/** iterative version */	
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

/** dumb recursion, calculates values multiple times */	
	public static long dumbRecFib (int n) {	
		return (n<2) ? base(n) : dumbRecFib(n-1)+dumbRecFib(n-2);
	}

/** recursion without memoization */	
	private static long recFibNoMemo (long prev1, long prev2, int n) {
		return (n>2) ? recFibNoMemo(prev2, prev1+prev2, --n) : prev1+prev2;
	}
	
	public static long recFibNoMemo (int n) {
		return (n<2) ? base(n) : recFibNoMemo(0,1,n);
	}

/** recursion with memoization */	
	private static Map<Integer, Long> memo = new HashMap<>();
	public static long recFibMemo(int n) {
		long ret;
		if (memo.containsKey(n))
			ret = memo.get(n);		
		else {
			ret = (n<2) ? base(n): recFibMemo(n-2)+recFibMemo(n-1);
			memo.put(n, ret);
		}
		return ret;
	}
}
