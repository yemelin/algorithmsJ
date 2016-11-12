package com.vvy.algo.recursion;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DigitCounterTest {

	private int input;
	private int expected;

	public DigitCounterTest(int input, int expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(new Object[][] {
				{15,2},
				{105,3},
				{15105,5},
		});
	}
	
	@Test
	public void testSequences() {
		Assert.assertEquals(expected, DigitCounter.countDigits(input));
	}
}
