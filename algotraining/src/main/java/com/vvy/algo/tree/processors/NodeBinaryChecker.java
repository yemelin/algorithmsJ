package com.vvy.algo.tree.processors;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import com.vvy.algo.tree.Node;

public class NodeBinaryChecker implements Consumer<Node> {

	private List<Node> foundNodes = new LinkedList<>();
	
	private boolean nodeIsBinary(Node node) {
		String s = (node.isLeaf()) ? " is a leaf" 
				: " has "+Integer.toString(node.getChildren().size())+" children";
		System.out.println(node.getValue()+s);
		return node.isLeaf() || node.getChildren().size()<3;
	}
	
	private boolean nodeIsNotBinary(Node node) {
		return !nodeIsBinary(node);
	}
	@Override
	public void accept(Node t) {
		if (nodeIsNotBinary(t))
			foundNodes.add(t);
	}
	
	public List<Node> getFoundNodes() {
		return foundNodes;
	}

}
