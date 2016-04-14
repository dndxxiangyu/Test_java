package com.test.cc;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-22 上午9:41:26
 */
public class FanTest {

	private Test1<Object> object = new Test1<Object>() {
		@Override
		void go() {
			
		}
	};
}
abstract class Test1<T>{
	abstract void go();
}