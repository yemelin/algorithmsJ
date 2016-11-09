package com.vvy.algo.linked;

import java.util.LinkedList;

import com.vvy.algo.list.BaseList;

public class DummyBaseList<E> implements BaseList<E> {

	protected LinkedList<E> list = new LinkedList<>();
	
	@Override
	public void append(E e) {
		list.add(e);
	}

	@Override
	public E getPosition(int i) {
		return list.get(i-1);
	}

	@Override
	public void insert(E e, int i) {
		list.add(i-1, e);
	}

	@Override
	public void delete(E e) {
		list.remove(e);
	}

}
