package com.seu.cc;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void printElements(Collection c){
		Iterator it = c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("one", "zhangsan");
		hm.put("two", "lisi");
		hm.put("three", "wangwu");
		Set keys = hm.keySet();
		printElements(keys);
		
		Collection values = hm.values();
		printElements(values);
		
		Set s = hm.entrySet();
		printElements(s);
		
		
		Map<Integer, Integer> map = Collections.singletonMap(1, 1);  
//        map.put(2, 2);  //----------1-------------  
        System.out.println(map.size()); 
        
        
	}

}
