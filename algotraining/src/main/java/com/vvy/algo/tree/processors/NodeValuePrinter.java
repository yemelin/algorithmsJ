package com.vvy.algo.tree.processors;

import java.util.function.Consumer;

import com.vvy.algo.tree.Node;

public class NodeValuePrinter implements Consumer<Node> {

	@Override
	public void accept(Node t) {
		System.out.print(t.getValue()+" ");
	}

}
