package com.seu.cc;

import java.util.ArrayList;
import java.util.Iterator;

public class Iteratorself {

	public static void main(String[] args) {

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("第一本");
		arr.add("第二本");
		arr.add("第三本");
		arr.add("第四本");
		arr.add("第五本");
		arr.add("第六本");
		System.out.println("全部的书："+arr.toString());
		Iterator<String> iterator = arr.iterator();
		while(iterator.hasNext()){
		//	System.out.println(iterator.next());
			if(iterator.next().equals("第三本")){
				iterator.remove();
			}
		}
		System.out.println("全部的书："+arr.toString());
	}

}
