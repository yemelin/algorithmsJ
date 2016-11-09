package com.vvy.algo.linked;

import java.util.Iterator;

import com.vvy.algo.list.IterableBack;
import com.vvy.algo.list.ReversibleList;

public class DoubleSimpleBaseList<E> implements ReversibleList<E>, IterableBack<E>{

	private int size = 0;
	private Node<E> head;
	
	protected Node<E>getNode(int position) {
		if (position<1)
			return null;
		Node<E> current = head;
		int i=1;
		while (current!=null && i++ <position) {
			current = current.next;
		}
		return current;		
	}

	
	@Override
	public void append(E e) {
		Node<E>current = head;
		if (head!=null) {
			while (current.next!=null) {
				current = current.next;				
			}
			current.next=new Node<>(e);
			current.next.prev = current;
		}
		else {
			head = new Node<>(e);
		}
		size++;
	}
	
	@Override
	public void insert(E e, int position) {
		if (position==1) {
			Node<E>node = new Node<>(e);
			node.next = head;
			if (node.next!=null)
				node.next.prev = node;
			head = node;
			size++;
			return;
		}			
		Node<E>previous = getNode(position-1);
		if (previous!=null) {
			Node<E>node = new Node<>(e);
			node.next = previous.next;
			node.prev = previous;
			if (node.next!=null)
				node.next.prev = node;
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
				if (current.next!=null)
					current.next.prev = previous;
			}
			else {
				head = current.next;
				current.prev=null;
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
		Node<E> current = head;
		do {
			Node<E> tmp = current.next;
			current.next = current.prev;
			current.prev = tmp;
			head = current; //
			current = current.prev;
		} while (current!=null);
		
	}

	protected static class Node<E> {
		public Node<E> next;
		public Node<E> prev;
		public E value;
		public Node(E value) {
			this.value = value;
		}
	}

	@Override
	public E getPosition(int position) {
		if (position<1)
			return null;
		Node<E> current = head;
		int i=1;
		while (current!=null && i++ <position) {
			current = current.next;
		}
		return current.value;
	}


	@Override
	public Iterator<E> backIterator() {
		return new Iterator<E>() {
			private Node<E> current = getNode(size);

			@Override
			public boolean hasNext() {
				return current!=null;
			}

			@Override
			public E next() {
				E value = current.value;
				current = current.prev;
				return value;
			}
		};
	}
	
}
