package com.seu.cc;

public class TryCatchTest {
    
    public static void main(String[] args) {
        
        System. out .println(fun());
        
   }
   
    public static String fun(){
         try {
             int temp =10/0;
        
        
            
        } catch (Exception e) {
            e.printStackTrace();
             return "aaa" ;
            
        } finally {
            System. out .println("NO" );
        
        }
         return "bbb" ;
   }

}
