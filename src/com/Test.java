package com;

import java.util.HashSet;

public class Test {  
	
    public static void main(String[] args) {  
          System.out.println(new StringBuilder("xx").equals(new StringBuilder("xx")));
          System.out.println(new StringBuffer("xx").equals(new StringBuffer("xx")));
          System.out.println(new String("xx").equals(new String("xx")));
        学生 我 = new 学生();  
        我.说();  
        long a = 1;
        switch(1){
        	case 1:
        		System.out.println("xx");
        	default:
        		System.out.println("cc");
        }
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
        System.out.println(Math.ceil(-11.5));
        System.out.println(-11/3);
        if("cc".equals(null)){
        		Object c;
        }
        System.out.println(new Test().test());
        HashSet<StringBuilder> set = new HashSet<StringBuilder>();
        set.add(new StringBuilder("xx"));
        set.add(new StringBuilder("xx"));
        set.add(new StringBuilder("xx"));
        System.out.println(set);
        int[][] cc = new int[][]{{1},{2,3}};
    }  
    public int test(){  
        System.out.println(super.getClass().getName());  
        System.out.println(this.getClass().getName());  
        System.out.println(this.getClass().getSuperclass().getName());  
        System.out.println("xx".hashCode()+" "+new String("xx").hashCode());
            int x = 1;  
            try  
            {  
                return x;  
            }  
            finally  
            {  
            	System.out.println("finally");
                ++x;
                System.out.println(x);
            }  
    }  
}  
class 学生{  
    public void 说(){  
        System.out.println("hello everyone!");  
    }  
}
class dd extends 学生{
	@Override
	public void 说() {
		// TODO Auto-generated method stub
		super.说();
	}

}
