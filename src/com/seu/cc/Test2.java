package com.seu.cc;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String string = sc.next();
		new Test2().xChange(string);
	}
	public String xChange(String inputString){
		char[] cc = inputString.toCharArray();
		char[] newChar = new char[cc.length];
		newChar[0] = cc[0];
		System.out.println("字符串长度"+cc.length);
		int k = 0;
		for(int i = 1;i<cc.length;i++){
			for(int j = 0;j<=k;j++){
				if(cc[i] == newChar[j]){
					break;
				}
				if(j == k){
					newChar[++k] = cc[i];
				}
			}
		}
		System.out.println("输入的："+inputString);
		System.out.println("输出的："+String.valueOf(newChar,0,k+1));
		return String.valueOf(newChar,0,k);
	}
}
