package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

import com.vvy.algo.tree.consumers.NodeBSChecker;
import com.vvy.algo.tree.consumers.NodeBinaryChecker;
import com.vvy.algo.tree.consumers.NodeValuePrinter;
import com.vvy.algo.tree.loader.Newick;
import com.vvy.algo.tree.loader.Tokenizer;
import com.vvy.algo.tree.node.Node;
import com.vvy.algo.tree.processors.DepthCountingProcessor;
import com.vvy.algo.tree.processors.RecursionProcessor;

public class Util {

	/** breadth first */
	public static <T> void traverseBFS(Node<T> node, Consumer<Node<T>>action) {
		LinkedList<Node<T>> queue = new LinkedList<>();
		queue.add(node); //enqueue root
		while (!queue.isEmpty()) {
			Node<T> next = queue.pollFirst(); //dequeue
			action.accept(next);
			if (!next.isLeaf()) {
				queue.addAll(next.getChildren()); //enqueue children
			}
		}
	}
	
	/** depth first */
	public static <T> void traverseDFS(Node<T> node, Consumer<Node<T>>action) {
		action.accept(node);
		if (!node.isLeaf()) {
			for (Node<T> t: node.getChildren())
				traverseDFS(t, action);
		}
	}	
	
	/** stack-based non-recursive DFS */
	public static <T> void traverseDFSWithStack(Node<T> node, Consumer<Node<T>>action) {
		Stack<Node<T>> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node<T> curNode = stack.pop();
			action.accept(curNode);
			if (!curNode.isLeaf())
				for (Node<T> child : curNode.getChildren())
					stack.push(child);
		}
	}
		
	public static <T> boolean treeIsBinary(Node<T> node) {
		NodeBinaryChecker<T> checker = new NodeBinaryChecker<>(); 
		traverseDFS(node, checker);
		return checker.getFoundNodes().isEmpty();
	}
	
	public static<T> void processDFS(Node<T> node, RecursionProcessor<T> proc) {
		proc.onEnter(node);
		if (!node.isLeaf()) {
			for (Node<T> t: node.getChildren())
				processDFS(t, proc);
		}
		proc.onExit(node);
	}	
	
	public static class BalanceInfo {
		boolean balanced;
		int height;
	}
	
	public static <T>BalanceInfo balanceInfo (Node<T> node) {
		BalanceInfo ret = new BalanceInfo();
		if (node.isLeaf()) {
			ret.height = 1;
			ret.balanced = true;
			return ret;
		}
		List<Node<T>> children = node.getChildren();
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
		String bs = "((9,6)8,(4,(1)2)3)5";
//		String bs = "(8,3)5";
		Node<Integer> tree = new Newick().loadTree(Tokenizer.tokenize(t));
//		traverseBFS(tree, System.out::print);
		traverseBFS(tree, new NodeValuePrinter<>());
		System.out.println();
		traverseDFS(tree, new NodeValuePrinter<>());
		System.out.println();
		
		tree = new Newick().loadTree(Tokenizer.tokenize(t2));
		System.out.println(treeIsBinary(tree));
		
		RecursionProcessor<Integer> depthCounter = new DepthCountingProcessor<>();
		processDFS(tree, depthCounter);
		System.out.println(depthCounter.getResult());
		
		BalanceInfo info = balanceInfo(tree);
		System.out.println(info.height+" "+info.balanced);
		
		tree = new Newick().loadTree(Tokenizer.tokenize(t3));
		info = balanceInfo(tree);
		System.out.println(info.height+" "+info.balanced);
		
		System.out.println("======= BS check =========");
		System.out.println(treeIsBinary(tree));
		NodeBSChecker<Integer> checker = new NodeBSChecker<>(); 
		traverseDFS(tree, checker);
		System.out.println(checker.getFoundNodes());
		
		tree = new Newick().loadTree(Tokenizer.tokenize(bs));
		System.out.println("======= BS check =========");
		System.out.println(treeIsBinary(tree));
		checker = new NodeBSChecker<>(); 
		traverseDFS(tree, checker);
		System.out.println(checker.getFoundNodes());

	}
}
