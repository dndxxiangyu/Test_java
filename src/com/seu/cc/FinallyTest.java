package com.seu.cc;

public class FinallyTest {

	/**
	 * return 是在final之前就得到答案
	 */
	public static void main(String[] args) {
		
		System.out.println(get());
		System.out.println(new FinallyTest().test());
		System.out.println(getFina());
		try {
//			throw new RuntimeException();
		}finally
        {
        }
		throw new Error();
	}
	static Fina getFina(){
		int x=1;
		Fina f = new Fina();
		try{
			f.a=x;
			return f;
		}finally
        {
        	System.out.println("finally");
            x++;
            f.a=x;
            f = new Fina();
            System.out.println("x:"+x);
//            return x;
        }
	}
	static int get(){
		int x = 1;
        try  
        {
        	return x;
        }
        finally
        {
        	System.out.println("finally");
            ++x;//不会执行这句话的
            System.out.println("x:"+x);
//            return x;
        }
	}
	int test()
    {  
        try  
        {  
            return func1();
        }  
        finally
        {  
            return func2();
        }  
    }  
      
    int func1()  
    {  
        System.out.println("func1");  
        return 1;  
    }  
    int func2()  
    {  
        System.out.println("func2");  
        return 2;  
    } 
}
class Fina{
	int a;
	String b;
	@Override
	public String toString() {
		return a+"";
	}
}