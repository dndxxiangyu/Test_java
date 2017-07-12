package com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class ClassName {

	
	public static void main(String[] args) {
		
//		new $cc();
//		List<String> s = new ArrayList<String>();
//		LinkedList<String>[] ll = new LinkedList[4];
//		LinkedList<String> ls = new LinkedList<String>();
//		ArrayList<String> ss = new ArrayList<String>();
//		cc[] c = new cc[10];
//		c[0] = new cc();
//		String string;
//		Object object;
//		for(int i=0;i<Integer.MAX_VALUE;i++){
//			cc a = new cc();
//		}
		System.out.println(Integer.MIN_VALUE);
		Object object = new Object();
		int i=2;
		
		System.out.println(object.equals(null));
		_cc c = new _cc();
		if(c instanceof Comparable){
			System.out.println("yes");
			System.out.println(c.getClass().getName());
		}
		double a = 1.1f;
		double b = 1.1;
		String aa ="abc";
		String bb =new String("abc");
		System.out.println(aa.hashCode());
		System.out.println(bb.hashCode());
		if(null instanceof Comparable){
			System.out.println("yeDDDs");
		}
		System.out.println(a);
		System.out.println(b);
		$cc[] cc = new $cc[4];
		for(i=0;i<cc.length;i++){
			cc[i] = new $cc();
		}
		for($cc xx:cc){
			
		}
		List<Object> list1 = new ArrayList<Object>();
		List list2 = new ArrayList();
		list1.add(new $cc());
		list2.add(new $cc());
//		Object[] ao = new Long[1];
//		ao[0] = "cc";
		List[] s = new ArrayList[4];
		s[0]  = new ArrayList<String>();
		Ta ta = new Ta();
		ta.get();
		Ta tb = new Tb();
		tb.get();
		System.out.println(1.03-.42);
		System.out.println(1-.42);
		int j=10;
		String string="adbfd:fdfdsf:fdfdsf";
		String[] ss =string.split(":",2);
		System.out.print(Arrays.toString(ss));
		cc ab = new cc();
		System.out.println(ab instanceof Singletona);
	}
	
}
class $cc {
	
}
class _cc implements Comparable<_cc>,Serializable{
	public int compareTo(_cc o) {
		
		return 0;
	}
}
class cc extends Singletona{
	protected void finalize() throws Throwable {
    	System.out.println("cc------->finalize");
    }
}
class Singletona {
    public Singletona(){
    	System.out.println("constructor");
    }
    protected void finalize() throws Throwable {
    	System.out.println("finalize");
    }
}
enum Shrubbery{GROUND,CRAWLING,HANGING}
class Ta{
	static void get(){
		System.out.println("ta");
	}
}
class Tb extends Ta{
	static void get(){
		System.out.println("tb");
	}
}