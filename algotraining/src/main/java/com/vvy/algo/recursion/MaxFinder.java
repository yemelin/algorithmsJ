package com.vvy.algo.recursion;

import java.util.List;

public class MaxFinder {
	
	public static int findMax (List<Integer> list) {
		int ret;
		if (list==null || list.isEmpty())
			ret = 0;
		else
			ret = (list.size()>1)? Math.max(list.get(0), findMax(list.subList(1, list.size()))) : list.get(0);
		return ret;
	}
}
