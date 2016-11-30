package com.vvy.algo.tree.consumers;

import java.util.function.Consumer;

import com.vvy.algo.tree.node.Node;

public class NodeValuePrinter<T> implements Consumer<Node<T>> {

	@Override
	public void accept(Node<T> t) {
		System.out.print(t.getValue()+" ");
	}

}
