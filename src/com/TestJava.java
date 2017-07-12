package com;


public class TestJava {

//	public static void main(String[] args) {
//		int i=new Integer(200);
//		int j=new Integer(200);
//		if(i==j){
//			System.out.println("i==j");
//		}
//		Integer a = 100;
//        Integer b = 100;
//        b.intValue();
//        System.out.println("m11 result " + (a == b));
////		int i=0;
////		i=i++ + ++i;
////		int j=0;
////		j=++j + j++ + j++ + j++;
////		int k=0;
////		k=k++ + k++ + k++ + ++k;
////		int h=0;
////		h= ++h + ++h;
////		System.out.println(i);
////		System.out.println(j);
////		System.out.println(k);
////		System.out.println("----------------------");
////		int a = 0,b=0;
////		int c=0;
////		a = c++ + ++c;
////		System.out.println(a);
////		int cc = "abc".length();
////		int[] ccc = new int[3];
////		for(i = 0; i<ccc.length;i++){}
//		short s = 1;
//		s +=1;
//	}
//	public static void main(String[] as){
//		int num=32;
//		System.out.println(num>>2);
//		A a = new A();
//		try {
//			a.test();
//			System.out.println("condition 1");
//		}catch(IndexOutOfBoundsException e ){
//			System.out.println("condition 2");
//		} catch (Exception e) {
//			System.out.println("condition 3");
//		}
//		int[] c = {'a','b','c'};
//		System.out.println(c);
//	}
//	public static void test(boolean test){
//		test = !test;
//		System.out.println("test:" +test);
//	}
	int i=2000;
	public static void main(String[] args){
//		System.out.println("xx:"+args[1]+"please");
//		sushu();
		System.out.println(Math.sqrt(16));
	}
	public static void sushu(){
		for(int i=2; i<=100;i++){
			int temp = (int) Math.sqrt(i);
			if(i<=3){
				System.out.println(i+" is a prime");
			}else{
				for(int j=2; j<=temp;j++){
					if(i%j==0){
						break;
					}
					if(j>=temp){
						System.out.println(i+" is a prime");
					}
				}
			}
		}
	}
}

class A{
	 static int main(){
		System.out.println("AAA");
		return 0;
	}
	 public void cc(){
		 System.out.println("xx");
	 }
	 public void test() throws Exception{
		 throw new Exception();
	 }
}
class CException extends Exception{
	public CException(String s) {
		super(s);
	}
}