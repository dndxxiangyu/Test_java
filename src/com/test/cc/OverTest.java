package com.test.cc;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-17 下午6:12:38
 */
public class OverTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Father1{}
class Child1 extends Father1{}

class OverLoadFather{
	public Father1 get(Child1 a){
		return null;
	}
}
class OverLoadChild extends OverLoadFather{
	
	@Override
	public Child1 get(Child1 a) {
		return null;
	}
	public void put(){
		
	}
	public void put(int a){
		
	}
}
