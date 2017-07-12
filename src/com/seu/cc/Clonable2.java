package com.seu.cc;

import java.util.ArrayList;

public class Clonable2 {

	
	public static void main(String[] args) {
		int i=3;
		int j=i=4;
		System.out.println(j);
		Object o;
	}

}
class CloneA{
	
}
class  CloneB extends CloneA{
	
}
class CloneC{
	public CloneA get(){
		return new  CloneB();
	}
}
class CloneD extends CloneC implements Inter{
	@Override
	public CloneB get() {
		
		return new CloneB();
	}
	
	public CloneB get(String a) {
		
		return new CloneB();
	}
	
	public void set() {
		// TODO Auto-generated method stub
		
	}
}
interface Inter{
	void set();
}