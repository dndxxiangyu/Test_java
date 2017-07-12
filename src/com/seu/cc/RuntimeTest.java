package com.seu.cc;

import java.io.InputStream;
public class RuntimeTest {

	/**
	 * Runtime类：可以调用windows的程序，执行类
	 */
	public static void main(String[] args) {
		// 虚拟机内存
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());
		try {
			//rt.exec("notepad");//返回一个Process
			rt.exec("javac Test1.java");
			Process p = rt.exec("java Test1");
			InputStream is = p.getInputStream();
			int data;
			while((data=is.read())!=-1){
				System.out.print((char)data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
