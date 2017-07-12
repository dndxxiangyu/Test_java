package com.seu.cc;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(new Pointa(1,2));
		al.add(new Pointa(5,6));
		al.add(new Pointa(3,4));
		System.out.println(al);
		//Collections.sort(al);
		System.out.println(al);
		ArrayList st = new ArrayList();
		st.add(new Stud(5,"xx"));
		st.add(new Stud(4,"cc"));
		st.add(new Stud(6,"xc"));
		System.out.println(st);
		Collections.sort(st,new StudComparator());
		Collections.sort(st,Collections.reverseOrder());//反序
		System.out.println(st);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
		Classa c1 = new Classb();
		Holder<Classa> holder = new Holder<Classa>(c1);
		holder.get();
		holder.getNum();
		System.out.println(c1.getClass());
		LinkedList ll;
//		Stack st;
//		HashSet<E>
		Tt t = new Tt();
		if(t instanceof Comparable){
			System.out.println("xiangdeng");
		}
		Holder a = new Holder();
		a.getNum();
		ArrayList<String> cc = new ArrayList<String>();
		cc.ensureCapacity(2);
		cc.add("1");
		cc.add("1");
		cc.add("1");
		System.out.println(cc);
		 
	}

}
class Pointa{
	int x,y;
	public Pointa(int x, int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return "x="+x+"：y="+y;
	}
}
class Stud implements Comparable<Stud>{
	int age;
	String name;
	public Stud(int age,String name){
		this.name=name;
		this.age=age;
	}
	public int compareTo(Stud o) {
		return this.age>o.age?1:(this.age==o.age?0:-1);
		//return o.age>this.age?1:(o.age==this.age?0:-1);
	}
	public String toString(){
		return "age:"+age+"：name:"+name;
	}
}
class StudComparator implements Comparator<Stud>{
	
	//自定义一个比较器，在外部比较
	//可以在Collections.sort()中传入一个自定义的比较器。
	public int compare(Stud o1, Stud o2) {
		
		return o1.age>o2.age?1:(o1.age==o2.age?0:-1);
	}
	
}
class Holder<E>{
	private E a;
	public Holder(){
		a = (E) new String();
	}
	public Holder(E a){
		this.a = a;
	}
	public E get(){
		return a;
	}
	public void getNum(){
		System.out.println(a.getClass());
	}
}
class Classa{
	
}
class Classb extends Classa{
	
}

class Tt implements Comparable{
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class Twu{
	
}