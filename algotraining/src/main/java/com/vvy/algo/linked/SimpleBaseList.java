package com.vvy.algo.linked;

import com.vvy.algo.list.BaseList;

public class SimpleBaseList<E> implements BaseList<E> {

	protected Node<E> head;
	
	@Override
	public void append(E e) {
		Node<E>current = head;
		if (head!=null) {
			while (current.next!=null) {
				current = current.next;				
			}
			current.next=new Node<>(e);
		}
		else {
			head = new Node<>(e);
		}
		
	}

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
	public void insert(E e, int position) {
		if (position==1) {
			Node<E>node = new Node<>(e);
			node.next = head;
			head = node;
			return;
		}			
		Node<E>previous = getNode(position-1);
		if (previous!=null) {
			Node<E>node = new Node<>(e);
			node.next = previous.next;
			previous.next = node;
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
		}
	}

	protected static class Node<E> {
		public Node<E> next;
		public E value;
		public Node(E value) {
			this.value = value;
		}
	}
}
