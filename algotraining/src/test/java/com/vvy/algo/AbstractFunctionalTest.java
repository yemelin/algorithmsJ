package com.vvy.algo;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public abstract class AbstractFunctionalTest <T,R> {
		
	protected abstract Map<String, Function<T, R>> functions();
	protected abstract Collection<Object[]> data();
	
		
	@SuppressWarnings("unchecked")
	@Test
	public void test() {		
		for (Entry<String, Function<T, R>> fdata: functions().entrySet()) {
			Function<T, R> f = fdata.getValue();
			String name = fdata.getKey();
			System.out.println("test for: "+name);
			for (Object[] d : data()) {
				Object params = d[0];
				Object expected = d[1];
				Assert.assertEquals(expected, f.apply((T)params));
			}
		}
	}

	protected class FuncHolder {
		Function<T,R> func;
		String name;
		public FuncHolder() {
			// TODO Auto-generated constructor stub
		}
	}
}
