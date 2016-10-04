package dev.wolveringer.hashmaps;

import java.util.HashMap;

public abstract class InitHashMap<K,V> extends HashMap<K, V> {
	@Override
	public V get(Object key) {
		V value = super.get(key);
		if(value == null)
			super.put((K) key, value = defaultValue((K) key));
		return value;
	}
	public abstract V defaultValue(K key);
}
