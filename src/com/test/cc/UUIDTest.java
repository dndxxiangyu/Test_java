package com.test.cc;

import java.util.UUID;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-25 下午4:43:11
 */
public class UUIDTest {
	public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
