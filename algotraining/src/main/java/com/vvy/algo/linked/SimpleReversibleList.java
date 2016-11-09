package com.vvy.algo.linked;

import com.vvy.algo.list.ReversibleList;

public class SimpleReversibleList<E> extends SimpleBaseList<E> implements ReversibleList<E> {

	private int size = 0;
	
	@Override
	public void append(E e) {
		super.append(e);
		size++;
	}
	
	@Override
	public void insert(E e, int position) {
		if (position==1) {
			Node<E>node = new Node<>(e);
			node.next = head;
			head = node;
			size++;
			return;
		}			
		Node<E>previous = getNode(position-1);
		if (previous!=null) {
			Node<E>node = new Node<>(e);
			node.next = previous.next;
			previous.next = node;
			size++;
		}	
	}
	
	@Override
	public void delete(E e) {
		if (head==null)
			return;
		Node<E> current = head, previous = null;
		while (current.value!=e && current.next!=null) {
			previous = current;
			current = current.next;
		}
		if (current.value == e) {
			if (previous!=null) {
				previous.next = current.next;
			}
			else {
				head = current.next;
			}
			size--;
		}
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void reverse() {
		if (size<2)
			return;
		Node<E> first = head, second = first.next, third = null;
		first.next = null;
		do {
			third = second.next;
			second.next = first;
			first = second;
			second = third;
		} while (second!=null);
		head = first;
	}

}
