package com.vvy.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryNode<T extends Comparable<T>> extends Node<T> {

	public BinaryNode(T value) {
		super(value);
		children = new ArrayList<Node<T>>(2);
		children.add(null);
		children.add(null);		
	}

	@Override
	public List<Node<T>> getChildren() {
		List<Node<T>>ret = new LinkedList<>();
		if (getLeft()!=null)
			ret.add(getLeft());
		if (getRight()!=null)
			ret.add(getRight());
		return ret;
	}
	
	@Override
	public void addNode(Node<T> node) {
		if (getRight()==null) {
			if (getLeft()==null)
				setLeft(node);
			else
				setRight(node);
		}
		else
			throw new RuntimeException("error adding 3rd node to a binary tree");
	}
	
	public Node<T> getLeft() {
		return children.get(0);
	}

	public void setLeft(Node<T> left) {
		children.set(0, left);
	}

	public Node<T> getRight() {
		return children.get(1);
	}

	public void setRight(Node<T> right) {
		children.set(1, right);
	}
}
