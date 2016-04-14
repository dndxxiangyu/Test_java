package com;

public class StaticBolckTest {

	/**
	 * {简述，证明多个asynctask的子类共用的是同一个线程池}.
	 * <p>
	 * {详述}
	 * <p>
	 * <code>{样例代码， 小于号大于号转义&lt; &gt;}</code>
	 * @author wuxiangyu 2016-4-14 下午1:43:29
	 * @param args
	 * @modify {上次修改原因} by wuxiangyu 2016-4-14 下午1:43:29
	 */
	public static void main(String[] args) {
		new StaticA().test();
		new StaticA().test();
		new StaticB().test();
		
	}

}
class Father{
	public Father(){
		System.out.println("constructor father");
	}
}

abstract class StaticFather{
	static{
		System.out.println("init static ");
	}
	static Father father = new Father();
	public StaticFather (){
		System.out.println(father);
	}
	abstract void test();
}
class StaticA extends StaticFather{
	@Override
	void test() {
		System.out.println(father);
	}
	
}
class StaticB extends StaticFather{
	@Override
	void test() {
		
	}
	
}