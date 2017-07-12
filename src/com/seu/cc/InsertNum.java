package com.seu.cc;

import java.util.Arrays;

public class InsertNum {

	
	public static void main(String[] args) {
		int[] before ={1,2,3,4,5,6,7,8};
		System.out.println(Arrays.toString(after(before,3,5)));
	}
	public static int[] after(int[] before,int k,int j){
		int length = before.length;
		int[] af = new int[length+2];
		for(int i=0;i<length;i++){
			af[i] = before[i];
		}
		af[length]=k;
		af[length+1]=j;
		return af;
	}
}
