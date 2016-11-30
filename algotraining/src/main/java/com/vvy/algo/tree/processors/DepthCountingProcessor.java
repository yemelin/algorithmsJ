package com.vvy.algo.tree.processors;

import com.vvy.algo.tree.Node;

public class DepthCountingProcessor implements RecursionProcessor{
	private int recursionDepth = 0;
	private int maxDepth = 0;

	@Override
	public void onEnter(Node node) {
		recursionDepth++;
		System.out.println("node:"+node.getValue()+", depth:"+recursionDepth);
		if (node.isLeaf() && recursionDepth>maxDepth)
			maxDepth = recursionDepth;
	}

	@Override
	public void onExit(Node node) {
		recursionDepth--;		
	}

	@Override
	public Object getResult() {
		return maxDepth;
	}

}
