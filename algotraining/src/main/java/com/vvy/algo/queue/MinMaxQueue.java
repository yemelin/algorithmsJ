package com.vvy.algo.queue;

public interface MinMaxQueue<E extends Comparable<E>> extends SimpleQueue<E>{	
	E min();
	E max();
}
