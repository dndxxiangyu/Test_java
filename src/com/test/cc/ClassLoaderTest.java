package com.test.cc;

public class ClassLoaderTest {
    public static void main(String[] args){
         ClassLoader loader = A.class.getClassLoader(); 
            while (loader != null) { 
                System.out.println(loader.toString()); 
                loader = loader.getParent(); 
            }
            ClassLoader loader1 = B.class.getClassLoader(); 
            while (loader1 != null) { 
                System.out.println(loader1.toString()); 
                loader1 = loader1.getParent(); 
            } 
    }
}
class A{}
class B{}
