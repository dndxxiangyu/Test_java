package com.seu.cc;

public class OverLoad {

	
	public static void main(String[] args) {
		
	}

}
class OverLoada{
	public Object a;
	public Object get(){
		return a;
	}
}
class OverLoadb extends OverLoada{
	@Override
	public OverLoada get() {
		// TODO Auto-generated method stub
		return (OverLoada) super.get();
	}
	public int find(){
		return 1;
	}
	public int find(int a){
		return a ;
	}
}