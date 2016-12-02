package com.vvy.algo.tree.node;

public class BSNode<T extends Comparable<T>> extends BinaryNode<T> {

	public BSNode(T value) {
		super(value);
	}

	@Override
	public void addNode(Node<T> node) {
		if (getValue().compareTo(node.getValue())>0) {
			
		}
		super.addNode(node);
	}
}
