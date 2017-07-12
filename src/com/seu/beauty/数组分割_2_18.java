package com.seu.beauty;

import java.util.Arrays;

public class 数组分割_2_18 {
	
	/**
	 * 有一个没有排序、元素个数为2n的正整数数组，
	 * 如何把这个数组分割为元素为n的两个数字，并使两个子数组的和最接近
	 */
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = {1,3,4,5,6};
		min(a,b);
		System.out.println(Arrays.toString(a));
	}
//	public static void 
	public static void min(int[] table1,int[] table2){
		//起始条件排除,长度相等， 非空
		
		int len=table1.length;
		int sum1=0,sum2=0;
		for(int i=0;i<len;i++){
			sum1=sum1+table1[i];
			sum2=sum2+table2[i];
		}
		int sub=sum1-sum2;
		while(sub!=0){
			int besti=0,bestj=0;
			int bestchange=0;
			for(int i=0;i<len;i++){
				for(int j=0;j<len;j++){
					int change=table1[i]-table2[j];
					if(Math.abs(sub-2*change)<Math.abs(sub-2*bestchange)){
						bestchange=change;
						besti=i;
						bestj=j;
					}
				}
			}
			if(bestchange==0){
				System.out.println(Arrays.toString(table1)+"\n"+Arrays.toString(table2));
				return;
			}
			int temp=table1[besti];
			table1[besti]=table2[bestj];
			table2[bestj]=temp;
			sum1 -= bestchange;
			sum2 += bestchange;
			sub=sum1-sum2;
		}
		System.out.println(Arrays.toString(table1)+"\n"+Arrays.toString(table2));
	}
}
