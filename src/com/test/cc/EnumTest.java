package com.test.cc;

public class EnumTest {
	public static void main(String[] args) {
//		System.out.println(State.single.key);
//		System.out.println(State.single.name);
//		System.out.println(State1.ON);
//		System.out.println(CommType.req.getVal());
//		System.out.println(Type.Integer.getType());
//		int a = MsgAcceptType.SINGLE.ordinal();
//		MsgAcceptType type = MsgAcceptType.SINGLE;
//		
//		System.out.println(type.getVal());
//		System.out.println(a);
		System.out.print(EncryptType.A.value);
	}
}
enum EncryptType{
	A("md5"),B("sha-256");
	String value;
	EncryptType(String value){
		this.value = value;
	}
	
}
enum MsgAcceptType {
	SINGLE(1), GROUP(2), PLUGIN(3);
	private int val;

	private MsgAcceptType(int _value) {
		this.val = _value;
		System.out.println("constructor");
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
enum Type{
	Integer{public String getType () {return "INTEGER";}},
	Text{public String getType () {return "text";}};
	public abstract String getType();
}
enum State{
	single(0,"CommMessageBody"),
	group(1,"CommGroupMessageBody"),
	invest(2,"CommMessageBody"),//公众号消息
	system(3,"CommSystemMessageBody");
	public int key;
	public String name;
	private State(int key, String name){
		this.key = key;
		this.name = name;
//		System.out.println("constructor");
	}
}
enum State1{
	ON,OFF;
	private State1(){
		System.out.println("constructor");
	}
}

enum CommType {

	/**
	 * 请求
	 */
	req(0),
	/**
	 * 响应
	 */
	rsp(1);		
	private int val;
	
	private CommType(int _val) {
		this.val = _val;
	}
	
	public int getVal() {
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}

}
