package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.Stack;

public class Newick {

	private Node root;
	Node curNode, newNode;
	Token curToken;
	Stack<Node> stack;
	private boolean nameWait = true;
	public Node loadTree (LinkedList<Token> tokens) {
		do {
			if (nameWait) {
				newNode = ((curToken=tokens.getLast()).type==Token.NAME) ? new Node(tokens.removeLast().value) : new Node();
				nameWait = false;
			}
			if (tokens.isEmpty() || (curToken=tokens.removeLast()).type==Token.COMMA) {
				curNode.addNode(newNode);
				nameWait = true;
			}
			else if (curToken.type==Token.RB) {
				//pushNode();
				//reset curNode down
			}
			else if (curToken.type==Token.LB) {
				//popNode()
				//reset curNode up
			}
		} while (!tokens.isEmpty());
		return null;
	}
}
