package com.test.cc;

import java.util.concurrent.atomic.AtomicInteger;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-28 下午2:48:35
 */
public class AtomicTest {
	static AtomicInteger index = new AtomicInteger(0);
	public static void main(String[] args) {
		System.out.println(index);
		index.incrementAndGet();
		System.out.println(index);
		index.addAndGet(10);
		System.out.println(index);
		System.out.println(index.intValue());
	}
}
