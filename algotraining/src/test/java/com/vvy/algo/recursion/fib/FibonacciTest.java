package com.vvy.algo.recursion.fib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class FibonacciTest {
	
	private static List<Object[]> data;
	private static List<Function<Integer,Long>> funcs;
//	private Function<Integer, Long> fib;
	
	@BeforeClass
	public static void setup() {
		funcs = new ArrayList<>();
		funcs.add(Fibonacci::dumbRecFib);
		funcs.add(Fibonacci::fib);
		funcs.add(Fibonacci::recFibNoMemo);
//		funcs.add(Fibonacci::recFibMemo);
		
		data = Arrays.asList(new Object[][] {
				{0,0l},
				{1,1l},
				{2,1l},
				{5,5l},
				{6,8l},
				{8,21l}
		});
	}

	@Test
	public void testFib() {
		for (Function<Integer, Long> fib : funcs) {
			for (Object[] tuple : data) {
				int n = (int)tuple[0];
				long ret = (long)tuple[1];
				Assert.assertEquals((long)ret, (long)fib.apply(n));
			}
		}
	}
}
