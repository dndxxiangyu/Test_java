package com.seu.beauty;

import java.util.Arrays;

public class 数组循环移位_2_17 {

	/**
	 * 设计一个算法， 把一个含有N个元素的数组循环右移K位，要求时间复杂度为n，且只允许使用两个附加变量
	 */
	public static void main(String[] args){
		int[] table={1,2,3,4,5,6,7,8};
		sort(table, 0);
		System.out.println(Arrays.toString(table));
	}
	public static void sort(int[] table, int k){
		int length=table.length;
		if(k<0)throw new RuntimeException();
		if(k>=length)k=k%length;
//		if(k==0)return;
		for(int i=0;i<(length+1)/2;i++){
			int temp=table[i];
			table[i]=table[length-i-1];
			table[length-i-1]=temp;
		}
		for(int i=0;i<(k+1)/2;i++){
			int temp=table[i];
			table[i]=table[k-i-1];
			table[k-i-1]=temp;
		}
		for(int i=0;i<(length-k+1)/2;i++){
			int temp=table[i+k];
			table[i+k]=table[length-i-1];
			table[length-i-1]=temp;
		}
	}
}
