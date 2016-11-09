package com.vvy.algo.list;

public interface BaseList<E> {
	void append (E e);
	E getPosition(int i);
	void insert(E e, int i);
	void delete(E e);
}
