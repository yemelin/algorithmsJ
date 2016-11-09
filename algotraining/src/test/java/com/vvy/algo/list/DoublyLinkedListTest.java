package com.vvy.algo.list;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vvy.algo.linked.DoubleSimpleBaseList;

public class DoublyLinkedListTest {
	private DoubleSimpleBaseList<Integer> list = new DoubleSimpleBaseList<>();
	private int e1, e2, e3, e4;

	@Before
	public void setup() {
		e1 = 1;
		e2 = 2;
		e3 = 3;
		e4 = 4;
		list.append(e1);
		list.append(e2);
		list.append(e3);
	}

	@Test
	public void simpleTest() {
		// list.append(e1);
		// list.append(e2);
		// list.append(e3);

		Assert.assertTrue(e3 == list.getPosition(3));
		list.insert(e4, 3);
		Assert.assertTrue(4 == list.getPosition(3));

		list.delete(1);
		Assert.assertTrue(2 == list.getPosition(1));
		Assert.assertTrue(4 == list.getPosition(2));
		Assert.assertTrue(3 == list.getPosition(3));
	}

	@Test
	public void testSizeAndReverse() {
		Assert.assertEquals(3, list.size());
		list.append(e4);
		Assert.assertEquals(4, list.size());
		list.delete(e4);
		Assert.assertEquals(3, list.size());
		list.reverse();
		Assert.assertTrue(3 == list.getPosition(1) && 1 == list.getPosition(3));
	}

	@Test
	public void testBackIterator() {
		int [] values = {1,2,3};
		int i=2;
		Iterator<Integer> backIt = list.backIterator();

		while (backIt.hasNext()) {
			int next = backIt.next();
//			System.out.println(next);
			Assert.assertTrue(values[i--] == next);
		}
	}
}
