package com;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Object, String> ha = new HashMap<Object, String>();
		WeakHashMap<Object, String> hash = new WeakHashMap<Object, String>();
		System.out.println(hash);
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		Object o4 = new Object();
		hash.put(o1, "xx");
		System.out.println(hash);
		System.out.println(ha);
		o1=null;
		System.gc();
		System.out.println(hash);
	}

}
