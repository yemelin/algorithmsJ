package com.vvy.algo.tree;

public class Token {
	public static final int LB=0, RB=1, COMMA=2, NAME=3; 
	
	int type;
	String value;
	
	public Token(String value) {
		this.value = value;
		switch (value) {
			case "(": type = LB; break;
			case ")": type = RB; break;
			case ",": type = COMMA; break;
			default: type = NAME;
		}
	}
}
