package com.seu.cc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exception1 {

	public static void main(String[] args) {
		boolean a = get();
		System.out.println(a);
	}
	public static boolean get(){
		String filename = "d:\\test.txtp";  
        try {  
            FileReader reader = new FileReader(filename);  
            Scanner in = new Scanner(reader);  
            String input = in.next();  
            int value = Integer.parseInt(input);  
            System.out.println(value);  
            return true;  
  
        } catch (FileNotFoundException e) {  
            System.out.println("this is catch_for_filenot... block!");  
            return false;  
        } finally {  
            System.out.println("this is finally block!");  
            return true;
        }  
	}
}
