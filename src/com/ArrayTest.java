package com;

import java.util.ArrayList;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-28 下午4:41:31
 */
public class ArrayTest {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		Object a = new Object();
		list.add(a);
		System.out.println(a.hashCode());
		
		ArrayList<Object> list2 = new ArrayList<Object>();
		list2.addAll(list);
		list = null;
		System.out.println((int)Math.sin((Math.PI*60)/360));
	}
}
