package com.vvy.algo.list.dummies;

import com.vvy.algo.list.ReversibleList;

/** for test purposes - testing the tests */
public class DummyReversibleList<E> extends DummyBaseList<E> implements ReversibleList<E> {

	@Override
	public int size() {		
		return list.size();
	}

	private void swap (int i, int j) {
		E tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
	@Override
	public void reverse() {
		int size = list.size();
		for (int i=0; i<size/2; i++) {
			swap(i,size-i-1);
		}
	}

}
