package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Util {

	/** breadth first */
	public static void traverseBFS(Node node, Consumer<Node>action) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(node); //push
		while (!queue.isEmpty()) {
			Node next = queue.pollFirst(); //pop
			action.accept(next);
			if (!next.isLeaf()) {
				queue.addAll(next.getChildren()); //push children
			}
		}
	}
	
	/** depth first */
	public static void traverseDFS(Node node, Consumer<Node>action) {
		action.accept(node);
		if (!node.isLeaf()) {
			for (Node t: node.getChildren())
				traverseDFS(t, action);
		}
	}

	public static void main(String[] args) {
		String t = "((,,(),,),(,,))";
		Node tree = new Newick().loadTree(Tokenizer.tokenize(t));
		traverseBFS(tree, System.out::print);
		System.out.println();
		traverseDFS(tree, System.out::print);
		System.out.println();
	}
}
