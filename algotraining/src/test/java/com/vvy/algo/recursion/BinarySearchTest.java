package com.vvy.algo.recursion;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
	protected Map<String, BiFunction <int[], Integer, Integer>> functions() {
		Map<String, BiFunction <int[], Integer, Integer>> map = new HashMap<>();
		map.put("simple binary", BinarySearch::find);
		map.put("recursive binary", BinarySearch::findRec);
		return map;
	}
	protected Collection<Object[]> data() {
		int[] a1 = {1,2,3,4,5};
		int[] a2 = {};
		int[] a3 = {1,2,3,4,5};
		int[] a4 = {1,3,4,6};
		return Arrays.asList(new Object[][]{
				{a1,2,1},
				{a2,5,-1},
				{a3,3,2},
				{a4,7,-1},
		});
	}
	
		
	@Test
	public void test() {		
		for (Entry<String, BiFunction <int[], Integer, Integer>> fdata: functions().entrySet()) {
			BiFunction<int[], Integer, Integer> f = fdata.getValue();
			String name = fdata.getKey();
			System.out.println("test for: "+name);
			for (Object[] d : data()) {
				Object param1 = d[0];
				Object param2 = d[1];
				Object expected = d[2];
				Assert.assertEquals(expected, f.apply((int[])param1,(int)param2));
			}
		}
	}


}
