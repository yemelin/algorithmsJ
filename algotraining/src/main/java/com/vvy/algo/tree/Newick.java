package com.vvy.algo.tree;

import java.util.LinkedList;
import java.util.Stack;

public class Newick {

	private Node root;
	Node curNode, newNode;
	Token curToken;
	Stack<Node> stack = new Stack<>();
	private boolean nameWait = true;
	
	public Node loadTree (LinkedList<Token> tokens) {
		//init
		curToken =tokens.getLast();
		root = newNode = (curToken.type==Token.NAME) ?
				new Node(tokens.removeLast().value) : new Node();
		nameWait = false;
		
		do {
			if (nameWait) {
				curToken=tokens.getLast(); //look ahead
				newNode = (curToken.type==Token.NAME) ?
						new Node(tokens.removeLast().value) : new Node();
				stack.peek().addNode(newNode);
				nameWait = false;
			}
			if (tokens.isEmpty() || (curToken=tokens.removeLast()).type==Token.COMMA) {
				nameWait = true;
			}
			else if (curToken.type==Token.RB) {
				stack.push(newNode);
				nameWait = true;
			}
			else if (curToken.type==Token.LB) {
				stack.pop();
			}
		} while (!tokens.isEmpty() && !stack.isEmpty());
		return (tokens.isEmpty() && stack.isEmpty()) ? root : null;
	}
	
	public static void main(String[] args) {
		String newick = "((b,),)a";		
		Node node = new Newick().loadTree(Tokenizer.tokenize(newick));
	}
}
