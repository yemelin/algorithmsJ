package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private List<Node> children;
	private String value;
	private static int autoInc = 0;

	public Node(String value) {
		this.value = value;
		System.out.println("node: "+value);
	}

	public Node() {
		this(Integer.toString(++autoInc));
	}

	public String getValue() {
		return value;
	}
	
	public void addNode(Node node) {
		if (children==null)
			children = new LinkedList<>();
		children.add(node);
	}
	
	@Override
	public String toString() {
		return value;
	}
}
