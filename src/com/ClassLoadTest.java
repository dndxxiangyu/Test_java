package com;

import com.test.cc.Test;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-25 下午3:01:59
 */
public class ClassLoadTest {
	public static void main(String[] args) {
        
        // 此时三个ClassLoader是同一个对象
        System.out.println(Thread.currentThread().getContextClassLoader()); // 当前线程的类加载器
        System.out.println(Test.class.getClassLoader()); // 当前类的类加载器
        System.out.println(ClassLoader.getSystemClassLoader()); // 系统初始的类加载器
        
    }
}
