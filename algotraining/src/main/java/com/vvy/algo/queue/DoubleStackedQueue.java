package com.vvy.algo.queue;

import java.util.Stack;

public class DoubleStackedQueue<E> implements SimpleQueue<E> {
	
	private Stack<E> in = new Stack<>(), out = new Stack<>();
	
	private void exchange (Stack<E> from, Stack<E> to) {
		while (!from.empty()) {
			to.push(from.pop());
		}
	}

	@Override
	public void enqueue(E e) {
		if (!out.empty())
			exchange(out, in);
		in.push(e);
	}

	@Override
	public E dequeue() {
		if (!in.empty())
			exchange(in, out);
		return out.pop();
	}

	@Override
	public int size() {
		return in.size()+out.size();
	}
	
}
