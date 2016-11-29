package com.vvy.algo.map;


import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleMap<K,V> implements Map<K, V> {
	
	@SuppressWarnings("unchecked")
	private List<Entry<K,V>> [] buckets = new List[256];
	
	private int hash(Object key) {
		return (key.hashCode()<<24)>>24;
	}

	private int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean containsKey(Object key) {
		List<Entry<K,V>> bucket = buckets [hash(key)];
		if (bucket==null)
			return false;
		for (Entry<K,V> entry : bucket) {
			if (entry.getKey().equals(key))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		throw new Error ("not implemented");
//		return false;	
	}

	@Override
	public V get(Object key) {
		List<Entry<K,V>> bucket = buckets [hash(key)];
		if (bucket==null || bucket.isEmpty())
			return null;
		for (Entry<K,V> entry : bucket) {
			if (entry.getKey().equals(key))
				return entry.getValue();
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		int hash = hash(key);
		if (buckets[hash]==null)
			buckets[hash] = new LinkedList<>();
		List<Entry<K, V>>bucket = buckets[hash];
		for (Entry<K,V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				V ret = entry.getValue();
				entry.setValue(value);
				return ret;
			}
		}
		bucket.add(new SimpleEntry<K,V>(key, value));
		size++;
		return null;
	}

	private static class SimpleEntry<K,V> implements Entry<K,V> {

		private K k;
		private V v;

		public SimpleEntry(K k, V v) {
			this.k = k;
			this.v = v;			
		}
		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}

		@Override
		public V setValue(V value) {
			V ret = v;
			v = value;
			return ret;
		}
		
	}
	@Override
	public V remove(Object key) {
		List<Entry<K,V>> bucket = buckets [hash(key)];
		if (bucket==null || bucket.isEmpty())
			return null;
		for (Entry<K,V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				bucket.remove(entry);
				size--;
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Entry<K,V>> ret = new HashSet<>();
		for (List<Entry<K,V>> bucket : buckets) {
			ret.addAll(bucket);
		}
		return ret;
	}

	public static void main(String[] args) {
		Map<String, String> map = new SimpleMap<>();
		map.put("one", "dog");
		map.put("two", "cat");
		System.out.println(map.size());
		System.out.println(map.get("two"));
		System.out.println(map.containsKey("one"));
		map.remove("one");
		System.out.println(map.get("one"));
		map.put("two", "dog2");
	}
}
