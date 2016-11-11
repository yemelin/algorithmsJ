package com.vvy.algo.recursion;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MaxFinderTest {

	private Function<List<Integer>, Integer> findMax = MaxFinder::findMax;
	private List<Integer> list;
	private int max;
	
	public MaxFinderTest(List<Integer>list, int max) {
		this.list = list;
		this.max = max;
		System.out.println(list);
		System.out.println(max);
	}
	
	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(new Object[][] {
				{Arrays.asList(2),2},
				{Arrays.asList(5,2,3,4,5,1), 5}				
		});
	}
	
	@Test
	public void test() {
		Assert.assertEquals((Integer)max, findMax.apply(list));
	}
}
