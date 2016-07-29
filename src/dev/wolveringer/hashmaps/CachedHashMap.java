package dev.wolveringer.hashmaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import dev.wolveringer.arrays.CachedArrayList;
import dev.wolveringer.arrays.CachedArrayList.UnloadListener;
import lombok.Getter;

public class CachedHashMap<K,V> extends HashMap<K, V> {
	private CachedArrayList<K> keys;
	private boolean locked = false;
	private ArrayList<UnloadListener<Entry<K, V>>> listener = new ArrayList<>(); 
	
	public CachedHashMap(int defautTime, TimeUnit defaultTimeUnit) {
		keys = new CachedArrayList<>(defautTime, defaultTimeUnit);
		keys.addUnloadListener(new UnloadListener<K>() {
			@Override
			public boolean canUnload(K element) {
				boolean alowed = true;
				for(UnloadListener<Entry<K, V>> listener : new ArrayList<>(listener))
					if(listener != null)
						if(!listener.canUnload(new Entry<K, V>() {
							@Override
							public K getKey() {
								return element;
							}

							@Override
							public V getValue() {
								return CachedHashMap.this.get0(element);
							}

							@Override
							public V setValue(V value) {
								return getValue();
							}
						}))
							alowed = false;
				return alowed;
			}
		});
	}
	
	@Override
	public V put(K key, V value) {
		putKey(key);
		return super.put(key, value);
	}
	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for(K key : m.keySet())
			putKey(key);
		super.putAll(m);
	}
	
	@Override
	public V get(Object key) {
		V out = super.get(key);
		if(!locked)
			if(!keys.contains(key)){
				out = null;
				super.remove(key);
			}
		return out;
	}
	
	protected V get0(Object key) {
		return super.get(key);
	}
	
	@Override
	public V getOrDefault(Object key, V defaultValue) {
		V out;
		if((out = get(key)) == null)
			return defaultValue;
		return out;
	}
	
	@Override
	public V remove(Object key) {
		keys.remove(key);
		return super.remove(key);
	}
	@Override
	public boolean remove(Object key, Object value) {
		keys.remove(key);
		return super.remove(key, value);
	}
	
	private void putKey(K key){
		keys.remove(key);
		keys.add(key);
	}

	public V put(K key, V value, int time, TimeUnit unit) {
		keys.add(key, time, unit);
		return super.put(key, value);
	}
	
	@Override
	public int size() {
		return keys.size();
	}
	
	@Override
	public Set<K> keySet() {
		if(!locked)
			keys.update();
		return new HashSet<>(keys);
	}
	
	@Override
	public Collection<V> values() {
		for(K key : super.keySet())
			get(key); //Update value
		return super.values();
	}

	public void lock() {
		locked = true;
		keys.update();
	}
	
	public void resetTime(K key){
		keys.resetTime(key);
	}
	
	public void unlock(){
		locked = false;
	}
	
	public void addUnloadListener(UnloadListener<Entry<K, V>> listener){
		this.listener.add(listener);
	}
	public void removeUnloadListener(UnloadListener<Entry<K, V>> listener){
		this.listener.remove(listener);
	}
}
