package com.vvy.algo.tree.consumers;

import com.vvy.algo.tree.node.NodeUtil;

public class CollectorProvider {

	public static<T> NodeCollector<T> getTotalNodeCollector() {
		return new NodeCollector<>(t->true);
	}
	
	public static<T> NodeCollector<T> getNonBinaryNodeCollector() {
		return new NodeCollector<>(NodeUtil::nodeIsNotBinary);
	}
	
	public static<T extends Comparable<T>> NodeCollector<T> getBSNodeCollector() {
		return new NodeCollector<T>(NodeUtil::nodeIsBS);
	}
}
