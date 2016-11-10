package com.vvy.algo.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Consumer;

public class ReverseInput {

	public static <T> void reverse (Iterator<T> it, Consumer<T> callBack) {
		Stack<T> stack = new Stack<>();
		while (it.hasNext()) {
			stack.push(it.next());
		}
		while (!stack.empty()) {
			callBack.accept(stack.pop());
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5};
		List<Integer> la = Arrays.asList(a);
		reverse(la.iterator(), System.out::println);
		reverse(new Scanner(System.in), System.out::println);
	}
}
