package com.seu.cc;

public class Overloadself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father a = new Sun();
		a.get();
	}

}
class F{
	public Father get(Sun str){
		return null;
	}
}
class S extends F{
	@Override
	public Father get(Sun str) {
		return null;
	}
}
class Father{
	protected  void get(){
		System.out.println("father");
	}
}
class Sun extends Father{
	@Override
	public  void get(){
		System.out.println("sun");
	}
}