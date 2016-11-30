package com.vvy.algo.tree.processors;

import com.vvy.algo.tree.Node;

public interface RecursionProcessor<T> {
	void onEnter(Node<T> node);
	void onExit (Node<T> node);
	Object getResult();
}
