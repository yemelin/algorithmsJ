package com.vvy.algo.tree.loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.vvy.algo.tree.Util;
import com.vvy.algo.tree.consumers.NodeValuePrinter;
import com.vvy.algo.tree.node.BinaryNode;
import com.vvy.algo.tree.node.Node;
import com.vvy.algo.tree.node.NodeUtil;

public class BSTLoader {

	public static BinaryNode<Integer> load (List<Integer> input) {
		if (input==null || input.isEmpty())
			return null;
		BinaryNode<Integer> root = new BinaryNode<Integer>(input.get(0));
		for (int value : input.subList(1, input.size())) {
			BinaryNode<Integer> node = root;
			Node<Integer> nextNode = root;
			do {
				node = (BinaryNode<Integer>)nextNode;
				nextNode = (value<node.getValue()) ? node.getLeft() : node.getRight();				
			} while (nextNode!=null);
			if (value<node.getValue())
				node.setLeft(new BinaryNode<>(value));
			else
				node.setRight(new BinaryNode<>(value));
		}
		return root;
	}
	
	public static void main(String[] args) {
		Integer[] digs = {6,2,4,7,1,10,3};
		List<Integer> input = Arrays.asList(digs);
		Node<Integer> root = load(input);
		Util.traverseDFS(root, new NodeValuePrinter<>());
		System.out.println();
		System.out.println(Util.treeIsBinary(root));
		System.out.println(Util.collectNodesOnCondition(root, NodeUtil::nodeIsNotBS));
		System.out.println(Util.searchBSTForLowerThan(root, 5));
//		System.out.println(Util.t);
	}
}
