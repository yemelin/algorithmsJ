package com.vvy.algo.tree.consumers;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import com.vvy.algo.tree.node.Node;
import com.vvy.algo.tree.node.NodeUtil;

public class NodeBSChecker<T extends Comparable<T>> implements Consumer<Node<T>> {

	private List<Node<T>> foundNodes = new LinkedList<>();
	
	@Override
	public void accept(Node<T> t) {
		if (!NodeUtil.nodeIsBS(t))
			foundNodes.add(t);
	}
	
	public List<Node<T>> getFoundNodes() {
		return foundNodes;
	}
}
