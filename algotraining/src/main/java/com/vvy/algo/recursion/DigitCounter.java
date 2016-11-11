package com.vvy.algo.recursion;

public class DigitCounter {

	public static int countDigits(int n) {
		return (n<10) ? 1 : 1+countDigits(n/10);
	}
	
	public static void main(String[] args) {
		System.out.println(countDigits(15105));
	}
}
