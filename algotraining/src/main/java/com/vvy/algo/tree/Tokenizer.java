package com.vvy.algo.tree;

import java.util.LinkedList;

public class Tokenizer {
	private static final String TOKENS = "(),";
	public static LinkedList<Token> tokenize (String text) {
		text = text.replaceAll("\\s", "");
		LinkedList<Token>ret = new LinkedList<>();
		int i=0;
		int j=i;
		while (i<text.length()) {
			if (TOKENS.indexOf(text.charAt(i))!=-1) {
				if (j<i) {
					ret.add(new Token(text.substring(j,i)));
				}
				ret.add(new Token(text.substring(i,i+1)));				
				j=i+1;
			}
			i++;
		}
		if (j<i)
			ret.add(new Token(text.substring(j,i)));
		return ret;
	}
	
	public static void main(String[] args) {
		String s = "(A,B(),AB C)";
		LinkedList<Token> toks = tokenize(s);
		for (Token t: toks) {
			System.out.println(t.value+" "+t.type);			
		}
//		System.out.println();
	}
}
