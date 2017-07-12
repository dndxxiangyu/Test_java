package com.seu.cc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AbstractClass {

	
	public static void main(String[] args) {
		Class a = Abstarct.class;
		Constructor[] cons = a.getDeclaredConstructors();
		for(int i=0;i<cons.length;i++){
			System.out.println(cons[i]);
		}
		new Exten().get();
		int i=Exten.i;
		new Expend().showNum();
		new Expend().showNum();
		new Expend().showNum();
		new Expend().showNum();
		new Expend().showNum();
		Method[] m = a.getDeclaredMethods();
		for(i=0;i<m.length;i++){
			System.out.println(m[i]);
		}
		Constructor[] con = a.getDeclaredConstructors();
		for(i=0;i<con.length;i++){
			System.out.println(con[i]);
		}
		Class ac = Ac.class;
		Constructor[] acs = ac.getDeclaredConstructors();
		for(i=0;i<acs.length;i++){
			System.out.println(acs[i]);
		}
		System.out.println("***************Ab**************");
		Class ab = Ab.class;
		Method[] abm=ab.getDeclaredMethods();
		for(i=0;i<abm.length;i++){
			System.out.println(abm[i]);
		}
		try {
			Object test = ab.newInstance();
			abm[0].setAccessible(true);
			abm[0].invoke(test, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Exten();
	}

}
interface Ac{
	int a=10;
}
abstract class Abstarct{
	static{
		System.out.println("abstract class");
	}
	protected Abstarct(){
		System.out.println("constructor--->AbstractS");
	}
	abstract public void get();
}
class Exten extends Abstarct implements Ac{
	static int i=100;
	@Override
	public void get() {
		int c = this.i;
		System.out.println("get() from Exten"+this.a+c);
	}
}
class Expend{
	static int i=10;
	public Expend(){
		this.i++;
	}
	public void showNum(){
		System.out.println(i);
		this.get();
	}
	public static void get(){
		System.out.println("get");
	};
}
class Ab{
	private void get(){
		System.out.println("Ab 's get");
	}
}
