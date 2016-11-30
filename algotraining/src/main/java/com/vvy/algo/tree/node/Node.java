package com.vvy.algo.tree.node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {

	protected List<Node<T>> children;
	private T value;

	public Node(T value) {
		this.value = value;
		System.out.println("node: "+value);
	}

	public T getValue() {
		return value;
	}
	
	public void addNode(Node<T> node) {
		if (children==null)
			children = new LinkedList<>();
		children.add(node);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	public List<Node<T>> getChildren() {
		return (children==null)? null:Collections.unmodifiableList(children);
	}

	public boolean isLeaf() {
		return (getChildren()==null || getChildren().isEmpty());
	}
}
