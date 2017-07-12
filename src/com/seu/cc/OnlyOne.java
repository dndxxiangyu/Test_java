
/**
 * 上传一个字符串，按顺序输出不重复的字符串
 * 如：abcaac：-----abc
 */
package com.seu.cc;

import java.util.Arrays;
import java.util.Scanner;

public class OnlyOne {


	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		System.out.println("输出的是：");
		new OnlyOne().getOnly(string);
		System.out.println('五'-'a');
	}
	
	public void getOnly(String string){
		
		int[] a = new int[26];
		char[] c = string.toCharArray();
		int[] c1 = new int[c.length];
		for(int i=0;i<c.length;i++){
			c1[i]=c[i]-'a';//得到数组，
			a[c1[i]] = 1;
		//	System.out.println(c1[i]);
		}
		System.out.println(Arrays.toString(c1));
		System.out.println(Arrays.toString(a));
		for(int i=0;i<c.length;i++){
			System.out.print("");
			if(a[c1[i]] == 1){
				a[c1[i]] = 0;
				System.out.print((char)(c1[i]+'a'));
			}
		}
	}

}
