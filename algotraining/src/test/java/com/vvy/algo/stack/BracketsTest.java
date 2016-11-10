package com.vvy.algo.stack;

import static com.vvy.algo.stack.Brackets.isBalanced;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class BracketsTest {

	@Test
	public void testInvalid() {
		String input = "(l)c";
		Assert.assertTrue(isBalanced(input));
	}
	
	@Test
	public void testSequences() {
		Assert.assertTrue(isBalanced(""));
		Assert.assertTrue(isBalanced("abc"));
		Assert.assertTrue(isBalanced("{ab[()b]}"));
		Assert.assertFalse(isBalanced("{[]]"));
		Assert.assertFalse(isBalanced("{[()"));
		Assert.assertFalse(isBalanced("{][}"));
		Assert.assertFalse(isBalanced("{[()}]"));
	}
}
