package designer;

public class Builder {
	public static void main(String[] args){
		System.out.println(new MyBuilder().setAge("11").setName("wxy").setSex("man").create());
	}
	private String name;
	private String age;
	private String sex;
	public Builder(MyBuilder builder){
		name = builder.name;
		age = builder.age;
		sex = builder.sex;
	}
	
	public void get(){
		MyBuilder builder = new MyBuilder();
		builder.age = "sss";//可以在外部类直接使用内部类的private属性，不管是不是static类
	}
	@Override
	public String toString() {
		return "name:"+name+"; age:"+age+"; sex:"+sex;
	}
	
	public static class MyBuilder{
		private String name;
		private String age;
		private String sex;
		public MyBuilder setName(String name){
			this.name = name;
			return this;
		}
		
		public MyBuilder setAge(String age){
			this.age = age;
			return this;
		}
		public MyBuilder setSex(String sex){
			this.sex = sex;
			return this;
		}
		public Builder create(){
			return new Builder(this);
		}
	}
}
