package com.vvy.algo.tree.consumers;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.vvy.algo.tree.node.Node;

public class NodeCollector<T> implements Consumer<Node<T>>{
	
	private Predicate<Node<T>> condition;
	private List<Node<T>> foundNodes;

	public NodeCollector(Predicate<Node<T>> condition) {
		this.condition = condition;
		foundNodes = new LinkedList<>();
	}

	@Override
	public void accept(Node<T> t) {
		if (condition.test(t))
			foundNodes.add(t);
	}

	public List<Node<T>> getFoundNodes() {
		return foundNodes;
	}
}
