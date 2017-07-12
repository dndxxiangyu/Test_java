package huawei;

public class Tencent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int a=2147483647;
		int b=2147483647;
		int c=1;
		System.out.println(a-b+c);
		System.out.println(a+c-b);
		new B();
	}
	static int fuc(int m,int n){
		if((m%n)==0)
		{
			return n;
		}else
		{
			return fuc(n,m%n);
		}
	}
}
class C{
	String cc;
	public C(String cc){
		this.cc = cc;
		System.out.println("C constructor"+cc);
	}
}
class AA{
	static{
		System.out.println("A"); //①
	}
	C c = new C("Aa");//③
	public AA(){
		System.out.println("A constructor"); //④
	}
}
class B extends AA{
	static{
		System.out.println("B"); //②
	}
	C c = new C("Bb");//⑥
	public B(){
		System.out.println("B constructor");//⑦
	}
}
