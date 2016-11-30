package com.vvy.algo.tree.processors;

import com.vvy.algo.tree.Node;

public interface RecursionProcessor {
	void onEnter(Node node);
	void onExit (Node node);
	Object getResult();
}
