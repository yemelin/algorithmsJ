package com.vvy.algo;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public abstract class AbstractConsumerTest<T> {
	
protected abstract Map<String, Consumer<T>> functions();
protected abstract Collection<T> data();
protected abstract boolean checkResult(T param);

	
@Test
public void test() {		
	for (Entry<String, Consumer<T>> fdata: functions().entrySet()) {
		Consumer<T> f = fdata.getValue();
		String name = fdata.getKey();
		System.out.println("test for: "+name);
		for (T d : data()) {
			T params = d;
			f.accept(params);
			Assert.assertTrue(checkResult(params));
		}
	}
}

}
