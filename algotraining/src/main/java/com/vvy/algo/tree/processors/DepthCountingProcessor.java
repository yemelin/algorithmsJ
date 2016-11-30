package com.vvy.algo.tree.processors;

import com.vvy.algo.tree.node.Node;

public class DepthCountingProcessor<T> implements RecursionProcessor<T>{
	private int recursionDepth = 0;
	private int maxDepth = 0;

	@Override
	public void onEnter(Node<T> node) {
		recursionDepth++;
		System.out.println("node:"+node.getValue()+", depth:"+recursionDepth);
		if (node.isLeaf() && recursionDepth>maxDepth)
			maxDepth = recursionDepth;
	}

	@Override
	public void onExit(Node<T> node) {
		recursionDepth--;		
	}

	@Override
	public Object getResult() {
		return maxDepth;
	}

}
