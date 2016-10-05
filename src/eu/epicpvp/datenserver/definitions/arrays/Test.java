package eu.epicpvp.datenserver.definitions.arrays;

import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		CachedArrayList<String> list = new CachedArrayList<>(5, TimeUnit.SECONDS);
		list.add("Hello world (2)");
		list.add("Hello world (1)",2,TimeUnit.SECONDS);
		list.add(null);
		while (list.size() != 0) {
			System.out.println("List: "+list);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Empty");
		for(int i = 0;i<10;i++){
			System.out.println("List: "+list);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
