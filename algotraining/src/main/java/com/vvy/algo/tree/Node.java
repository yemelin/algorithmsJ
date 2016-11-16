package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private List<Node> children;

	public Node(String value) {
		// TODO Auto-generated constructor stub
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public void addNode(Node node) {
		if (children==null)
			children = new LinkedList<>();
		children.add(node);
	}
}
