package com.vvy.algo.tree.node;

import java.util.List;

public class NodeUtil {
	public static <T> boolean nodeIsBinary(Node<T> node) {
		String s = (node.isLeaf()) ? " is a leaf" : " has "
				+ Integer.toString(node.getChildren().size()) + " children";
		System.out.println(node.getValue() + s);
		return node.isLeaf() || node.getChildren().size() < 3;
	}

	public static <T> boolean nodeIsNotBinary(Node<T> node) {
		return !nodeIsBinary(node);
	}

	public static <T extends Comparable<T>> BinaryNode<T> toBinaryNode(
			Node<T> node) {
		if (!node.isLeaf() && node.getChildren().size() > 2)
			throw new RuntimeException("can't convert, too many children");

		BinaryNode<T> ret = new BinaryNode<T>(node.getValue());
		if (node instanceof BinaryNode) {
			ret.setLeft(((BinaryNode) node).getLeft());
			ret.setRight(((BinaryNode) node).getRight());
		} else {
			List<Node<T>> children = node.getChildren();
			if (!node.isLeaf()) {
				if (children.size() > 0) {
					ret.addNode(children.get(0));
					if (children.size() > 1)
						ret.addNode(children.get(1));
				}
			}
		}
		return ret;
	}

	public static <T extends Comparable<T>> boolean nodeIsBS(Node<T> node) {
		return nodeIsBS(toBinaryNode(node));
	}

	public static <T extends Comparable<T>> boolean nodeIsBS(BinaryNode<T> node) {
		boolean ret = (node.getLeft() == null || node.getLeft().getValue()
				.compareTo(node.getValue()) < 0)
				&& (node.getRight() == null || node.getRight().getValue()
						.compareTo(node.getValue()) >= 0);
		return ret;

	}

	public static <T extends Comparable<T>> boolean nodeIsNotBS(Node<T> node) {
		return !nodeIsBS(node);
	}
}
