package com.vvy.algo.queue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class QueueTest {

	private SimpleQueue<Integer> queue = new DoubleStackedQueue<>();
	private MinMaxQueue<Integer> mmQueue = new LinkedMinMaxQueue<>();
	
	@Test
	public void test() {
		queue.enqueue(4);
		Assert.assertTrue(1==queue.size());
		Assert.assertTrue(4==queue.dequeue());
		queue.enqueue(4);
		queue.enqueue(3);
		queue.enqueue(2);
		Assert.assertTrue(4==queue.dequeue());
	}
	
	@Test
	public void testMMQueue() {
		
		mmQueue.enqueue(4);
		mmQueue.enqueue(3);
		mmQueue.enqueue(2);
		System.out.println(mmQueue.min()+" "+mmQueue.max());
		mmQueue.dequeue();
		mmQueue.enqueue(1);
		mmQueue.enqueue(5);
		mmQueue.dequeue();
		System.out.println(mmQueue.min()+" "+mmQueue.max());
	}

}
