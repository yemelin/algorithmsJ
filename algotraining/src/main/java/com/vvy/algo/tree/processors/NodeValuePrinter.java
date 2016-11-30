package com.vvy.algo.tree.processors;

import java.util.function.Consumer;

import com.vvy.algo.tree.Node;

public class NodeValuePrinter<T> implements Consumer<Node<T>> {

	@Override
	public void accept(Node<T> t) {
		System.out.print(t.getValue()+" ");
	}

}
