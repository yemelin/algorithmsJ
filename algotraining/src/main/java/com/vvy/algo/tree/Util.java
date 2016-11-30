package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

import com.vvy.algo.tree.processors.DepthCountingProcessor;
import com.vvy.algo.tree.processors.NodeBinaryChecker;
import com.vvy.algo.tree.processors.NodeValuePrinter;
import com.vvy.algo.tree.processors.RecursionProcessor;

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
	
	/** stack-based non-recursive DFS */
	public static void traverseDFSWithStack(Node node, Consumer<Node>action) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node curNode = stack.pop();
			action.accept(curNode);
			if (!curNode.isLeaf())
				for (Node child : curNode.getChildren())
					stack.push(child);
		}
	}
		
	public static boolean treeIsBinary(Node node) {
		NodeBinaryChecker checker = new NodeBinaryChecker(); 
		traverseDFS(node, checker);
		return checker.getFoundNodes().isEmpty();
	}
	
	public static void processDFS(Node node, RecursionProcessor proc) {
		proc.onEnter(node);
		if (!node.isLeaf()) {
			for (Node t: node.getChildren())
				processDFS(t, proc);
		}
		proc.onExit(node);
	}	
	
	public static class BalanceInfo {
		boolean balanced;
		int height;
	}
	
	public static BalanceInfo balanceInfo (Node node) {
		BalanceInfo ret = new BalanceInfo();
		if (node.isLeaf()) {
			ret.height = 1;
			ret.balanced = true;
			return ret;
		}
		List<Node> children = node.getChildren();
		BalanceInfo left = balanceInfo(children.get(0));
		BalanceInfo right;
		if (children.size()>1)
			right = balanceInfo(node.getChildren().get(1));
		else {
			right = new BalanceInfo();
			right.height = 0;
			right.balanced = true;
		}
		ret.balanced = left.balanced && right.balanced && Math.abs(left.height-right.height)<2;
		ret.height = Math.max(left.height, right.height)+1;
		return ret;
	}
	
	
	public static void main(String[] args) {
		String t = "((,,(),,),(,,))";
		String t2 = "(((8,(10,11)9)4,5)2,(6,7)3)1";
		String t3 = "(((),),(,))";
		Node tree = new Newick().loadTree(Tokenizer.tokenize(t));
//		traverseBFS(tree, System.out::print);
		traverseBFS(tree, new NodeValuePrinter());
		System.out.println();
		traverseDFS(tree, new NodeValuePrinter());
		System.out.println();
		
		tree = new Newick().loadTree(Tokenizer.tokenize(t2));
		System.out.println(treeIsBinary(tree));
		
		RecursionProcessor depthCounter = new DepthCountingProcessor();
		processDFS(tree, depthCounter);
		System.out.println(depthCounter.getResult());
		
		BalanceInfo info = balanceInfo(tree);
		System.out.println(info.height+" "+info.balanced);
		
		tree = new Newick().loadTree(Tokenizer.tokenize(t3));
		info = balanceInfo(tree);
		System.out.println(info.height+" "+info.balanced);
	}
}
