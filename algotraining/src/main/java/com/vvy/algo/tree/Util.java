package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Util {

	/** breadth first */
	public static void traverseBFS(Node node, Consumer<Node>action) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(node); //enqueue root
		while (!queue.isEmpty()) {
			Node next = queue.pollFirst(); //dequeue
			action.accept(next);
			if (!next.isLeaf()) {
				queue.addAll(next.getChildren()); //enqueue children
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
	
	public static List<Node> searchDF(Node node, Predicate<Node> condition) {
		Stack<Node> stack = new Stack<>();
		List<Node> ret = new LinkedList<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node curNode = stack.pop();
			if (condition.test(curNode))
				ret.add(curNode);
			if (!curNode.isLeaf())
				for (Node child : curNode.getChildren())
					stack.push(child);
		}
		return ret;
	}
	
	public static boolean nodeIsBinary(Node node) {
		String s = (node.isLeaf()) ? " is a leaf" 
				: " has "+Integer.toString(node.getChildren().size())+" children";
		System.out.println(node.getValue()+s);
		return node.isLeaf() || node.getChildren().size()<3;
	}
	
	public static boolean nodeIsNotBinary(Node node) {
		return !nodeIsBinary(node);
	}
	
	public static boolean treeIsBinary(Node node) {
		List<Node> nonBinary = searchDF(node, Util::nodeIsNotBinary);
		return nonBinary.isEmpty();
	}
	
	public static void main(String[] args) {
		String t = "((,,(),,),(,,))";
		String t2 = "(((8,(10,11)9)4,5)2,(6,7)3)1";
		Node tree = new Newick().loadTree(Tokenizer.tokenize(t));
		traverseBFS(tree, System.out::print);
		System.out.println();
		traverseDFS(tree, System.out::print);
		System.out.println();
		
		tree = new Newick().loadTree(Tokenizer.tokenize(t2));
		System.out.println(treeIsBinary(tree));
	}
}
