package com.vvy.algo.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.vvy.algo.AbstractConsumerTest;

public class SortTest extends AbstractConsumerTest<int[]> {

	@Override
	protected Map<String, Consumer<int[]>> functions() {
		Map<String, Consumer<int[]>> map = new HashMap<String, Consumer<int[]>>();
		map.put("embedded", Arrays::sort);
		map.put("bubble", Sort::bubble);
		map.put("recursive bubble", Sort::bubbleRec);
		map.put("merge top down", Sort::mergeSortTD);
		map.put("merge bottom up", Sort::mergeSortBU);
		map.put("quickSort", Sort::quickSort);
		return map;
	}

	@Override
	protected Collection<int[]> data() {
		return Arrays.asList(new int[][] {
				{1,3,5,6,4,4,2},
				{1},
				{1,4,6,3,3,4,9,0},
				{}
		});
	}

	@Override
	protected boolean checkResult(int[] param) {
		return Sort.isSorted(param);
	}

}
