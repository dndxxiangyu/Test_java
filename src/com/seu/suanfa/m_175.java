package com.seu.suanfa;

import java.util.Arrays;

public class m_175 {

	/**
	 * 一个未排序整数数组，有正负数，重新排列使负数排在正数前面，并且要求不改变原来的正负数之间相对顺序 
	 * 比如： input: 1,7,-5,9,-12,15 ans: -5,-12,1,7,9,15 要求时间复杂度O(N),空间O(1) 
	 */
	public static void main(String[] args) {
		int[] table = {1,2,-3,4,-4,-5-7,-8,9,-10};
		new m_175().input(table);
	}
	public void input(int[] table){
		int len = table.length;
		int neg=0;
		int pos=0;
		System.out.println(Arrays.toString(table));
		for(int i=0;i<len;i++){
			if(table[i]<0){
				neg++;
			}
		}
		System.out.println("负数："+neg);
		int a=0,b=neg;
		while(a<neg){
			if(table[a]<0){
				a++;
			}else{
				int temp = table[b];
				table[b]=table[a];
				table[a] = temp;
				b++;
			}
		}
		System.out.println(Arrays.toString(table));
	}
}
