package com.seu.cc;

public class ClassTestStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		Class c1 = st1.getClass();
		Class c2 = StaticTest.class;
		System.out.println(c1==c2);//每一个类对应一个class对象！注意只有一个class对象。
		StaticTest st = new StaticTest();
		StaticTest ss = new SunStatic();
		if(st instanceof StaticTest){
			System.out.println("st is shili of StaticTest");
		}
		if(st instanceof SunStatic){
			System.out.println("st is shili of SunStatic");
		}
		if(ss instanceof StaticTest){
			System.out.println("ss is shili of StaticTest");
		}
		if(ss instanceof SunStatic){
			System.out.println("ss is shili of SunStatic");
		}
		if(ss.getClass() == st.getClass()){
			System.out.println("df");
		}
		System.out.println(ss.getClass().toString());
		System.out.println(ss.getClass());
		System.out.println(st.getClass());
	}

}
class StaticTest{
	public final void get(){}
}
class SunStatic extends StaticTest{
	
}