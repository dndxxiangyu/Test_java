package com.seu.cc;
public class InnerClass {  
    static class A{  
        int a = 10;  
        void b(){  
            System.out.println("this is A.b()!");  
        }  
    }  
      
    public static void main(String[] args) {  
        InnerClass.build();  
    }  
      
    static void build(){  
        A a = new A();  
        a.b();  
    }  
} 
