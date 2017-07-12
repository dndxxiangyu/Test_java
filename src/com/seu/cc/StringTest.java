package com.seu.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StringTest {

	
	public static void main(String[] args) {
		String string = "我想ded";
        System.out.println("length():"+string.length());
        byte[] by = string.getBytes();
        System.out.println("string to byte:"+Arrays.toString(by));
        String nString = new String(by);
        System.out.println("newString:"+nString);
        System.out.println("byte's length:"+string.getBytes().length);
        char[] cha = string.toCharArray();
        System.out.println(cha.length);
        System.out.println(cha[1]);
        System.out.println(Arrays.toString(cha));
        ArrayList array = new ArrayList();
        Father father = new Father();
        array.add(father);
        array.get(0);
        System.out.println(array.get(0).getClass().getName());
        
        String s = "helloworld";  
        String[] s2 = s.split("abc");  
        for (int i = 0; i < s2.length; i++) {  
            System.out.println(s2[i] + " " + i);  
        }  
        System.out.println(s2.length );
        int i = 2;  
        int j = 3;  
        String s1 = "9";  
        System.out.println(i+j+s1);        
        System.out.println("-----------------------");  
        System.out.println(i+s1+j);  
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(null);
        System.out.println(arr);
        HashMap<String,String> hash = new HashMap<String, String>();
        System.out.println(hash.get(null));
	}

}
