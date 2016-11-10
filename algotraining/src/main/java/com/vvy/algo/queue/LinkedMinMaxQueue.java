package com.vvy.algo.queue;

import java.util.LinkedList;

public class LinkedMinMaxQueue<E extends Comparable<E>> implements
		MinMaxQueue<E> {

	private LinkedList<E> list = new LinkedList<>();
	private E min, max;

	@Override
	public void enqueue(E e) {
		if (list.isEmpty()) {
			min = e;
			max = e;
		} else {
			if (min().compareTo(e) > 0)
				min = e;
			if (max().compareTo(e) < 0)
				max = e;
		}
		list.add(e);

	}

	@Override
	public E dequeue() {
		E e = list.removeFirst();
		if (!list.isEmpty()) {
			if (e.compareTo(max()) >= 0)
				max = null;
			if (e.compareTo(min()) <= 0)
				min = null;
		}
		return e;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public E min() {
		if (min == null)
			min = findMin();
		return min;
	}

	@Override
	public E max() {
		if (max == null)
			max = findMax();
		return max;
	}

	private E findMin() {
		E min = null;
		for (E e : list) {
			if (min == null || e.compareTo(min) < 0)
				min = e;
		}
		return min;
	}

	private E findMax() {
		E max = null;
		for (E e : list) {
			if (max == null || e.compareTo(max) > 0)
				max = e;
		}
		return max;
	}

}
