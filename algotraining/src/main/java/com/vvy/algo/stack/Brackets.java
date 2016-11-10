package com.vvy.algo.stack;

import java.util.Stack;

public class Brackets {

	private static final String LEFT = "{[(";
	private static final String RIGHT = "}])";
	private static final String BRACKETS = LEFT+RIGHT;
	
	public static boolean isBalanced (String input) {
		if (input == null || input.isEmpty())
			return true;
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<input.length(); i++) {
			char c=input.charAt(i);
			if (isNotBracket(c))
				continue;
			if (isLeft(c)) {
				stack.push((char)c);
			}
			else {
				if (stack.empty() || !isMatch(stack.pop(), c)) {
					return false;
				}
			}
		}
		return stack.empty();
	}

	private static boolean isMatch(char pop, char c) {
		return (LEFT.indexOf(pop)==RIGHT.indexOf(c));
	}

	private static boolean isLeft(int c) {
		return LEFT.indexOf(c)!=-1;
	}

	private static boolean isNotBracket(char c) {
		return BRACKETS.indexOf(c)==-1;
	}
	
}
