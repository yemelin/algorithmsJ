package com.vvy.algo.recursion.fib;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.vvy.algo.AbstractFunctionalTest;
import com.vvy.algo.recursion.fib.Fibonacci;

public class FibPTest extends AbstractFunctionalTest<Integer, Long> {	
	
	@Override
	protected Map<String, Function<Integer, Long>> functions() {
		Map<String, Function<Integer, Long>> ret = new HashMap<>();
		ret.put("iterating fib", Fibonacci::fib);
		ret.put("dumb recursive fib", Fibonacci::dumbRecFib);
		ret.put("no memo fib", Fibonacci::recFibNoMemo);
		ret.put("memo fib", Fibonacci::recFibMemo);
		return ret;
	}


	@Override
	protected Collection<Object[]> data() {		
		return Arrays.asList(new Object[][] {
				{0,0l},
				{1,1l},
				{2,1l},
				{5,5l},
				{6,8l},
				{8,21l}
		});
	}
}
