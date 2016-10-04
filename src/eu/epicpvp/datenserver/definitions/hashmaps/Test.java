package dev.wolveringer.hashmaps;

import java.util.concurrent.TimeUnit;

import dev.wolveringer.arrays.CachedArrayList;

public class Test {
	public static void main(String[] args) {
		CachedHashMap<String,String> list = new CachedHashMap<>(5, TimeUnit.SECONDS);
		list.put("Hello world (2)","5 seconds");
		list.put("Hello world (1)","3 seconds",3,TimeUnit.SECONDS);
		while (list.size() != 0) {
			System.out.println("List: "+list);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Empty");
	}
}
