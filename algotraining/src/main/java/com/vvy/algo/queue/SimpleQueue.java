package com.vvy.algo.queue;

public interface SimpleQueue<E> {
	void enqueue (E e);
	E dequeue();
	int size();
}
