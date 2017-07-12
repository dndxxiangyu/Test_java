/**
 * 约瑟夫问题：丢手帕
 */
package com.seu.cc;

import java.util.Arrays;

public class Joseph {

	public static void main(String[] args) {
		int a[]={1,2,3};
		Joseph.get(a, 1, 2);
	}
	public static int get(int[] a, int start,int distance){
		int length=a.length;
		int begin=(start+distance-2)%length;
		while(length>1){
			System.out.println(a[begin]);
			for(int i=begin;i<=length-2;i++){
				a[i]=a[i+1];
			}
			length--;
			begin=(begin+distance-1)%length;
			
		}
		System.out.println(a[0]);
		return 0;
	}
}
