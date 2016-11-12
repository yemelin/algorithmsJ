package com.vvy.algo.stack;

import static com.vvy.algo.stack.Brackets.isBalanced;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BracketsTest {
	
	private String input;
	private boolean expected;

	public BracketsTest(String input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(new Object[][] {
				{"",true},
				{"abc", true},
				{"{ab[()b]}",true},
				{"(l)c",true},
				{"{[]]",false},
				{"{[()",false},
				{"{][}", false},
				{"{[()}]",false},
		});
	}
	
	@Test
	public void testSequences() {
		Assert.assertEquals(expected, isBalanced(input));
	}
}
