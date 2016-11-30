package com.vvy.algo.tree.loader;

import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Function;

import com.vvy.algo.tree.node.Node;

public class Newick {

	private int autoInc = -1;
	private Node root;
	private Node newNode;
	private Token curToken;
	private Stack<Node> stack = new Stack<>();
	private boolean nameWait = true;
		
	private boolean validate(LinkedList<Token> tokens) {
		// TODO Auto-generated method stub
		return true;
	}

	public Node loadTree (LinkedList<Token> tokens) {
		return loadTree(tokens, Node::new);
	}
	
	public Node loadTree (LinkedList<Token> tokens, Function<String,Node> factory) {
		if (!validate(tokens))
			return null;
		//init
		curToken =tokens.getLast();
		root = newNode = (curToken.type==Token.NAME) ?
				factory.apply(tokens.removeLast().value) : factory.apply(Integer.toString(++autoInc));
		nameWait = false;
		
		do {
			if (nameWait) {
				curToken=tokens.getLast(); //look ahead
				newNode = (curToken.type==Token.NAME) ?
						factory.apply(tokens.removeLast().value) : factory.apply(Integer.toString(++autoInc));
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
		new Newick().loadTree(Tokenizer.tokenize(newick));
		newick = "((,,(),,),(,,))";
		new Newick().loadTree(Tokenizer.tokenize(newick));
	}
}
