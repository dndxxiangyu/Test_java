package com.test.cc;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-15 下午4:22:26
 */
public class BuilderTest {

	private int age;
	private String sex;
	public static void main(String[] args) {
		BuilderTest test = new BuilderTest.Builder().setAge(10).setSex("man").build();
		System.out.println(test.age);
		System.out.println(test.sex);
	}
	public BuilderTest(Builder builder){
		this.sex = builder.sex;
		this.age = builder.age;
		
	}
	public static class Builder{
		private int age;
		private String sex;
		public BuilderTest build(){
			return new BuilderTest(this);
		}
		public Builder setSex(String sex){
			this.sex = sex;
			return this;
		}
		public Builder setAge(int age){
			this.age = age;
			return this;
		}
		
	}
}
