package com.seu.cc;


public class Compare {
	
	public static void main(String[] args){
		Comparable a = new Comp(1);
		System.out.println(((Comp)a).i);
		Persona[] p = new Employeea[5];
		p[0] = new Studenta();
		p[1] = new Employeea();
	}
}
class Comp implements Comparable<Comp>{
	int i;
	public Comp(int i){
		this.i=i;
	}
	public int compareTo(Comp o) {
		
		return 0;
	}
	
}
class CompChild extends Comp{

	public CompChild(int i) {
		super(i);
	}
	
}
class Persona{}
class Employeea extends Persona{
	
}
class Studenta extends Persona{
	
}
