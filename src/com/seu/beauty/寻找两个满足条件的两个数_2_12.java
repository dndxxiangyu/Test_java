package com.seu.beauty;

import java.util.Stack;

import yeheya.SortClass;

public class 寻找两个满足条件的两个数_2_12 {

	/**
	 * 在一个数组中的两个数字，让着两个数字之和等于给定的值，
	 * 数组是排序的
	 */
	public static void main(String[] args) {
		int[] table={5,6,1,4,7,9,8};
		SortClass.mergeSort(table);
		find(table, 10);
		System.out.println("**************");
		find3(table, 10);
		System.out.println("**************");
		findAny(table.length-1,table, 10);
	}
	public static void find(int[] table, int k){
		if(table==null)throw new RuntimeException();
		int start=0;//开头指针
		int end=table.length-1;//末尾指针
		while(start<end){
			int sum=table[start]+table[end];
			if(sum>k){
				end--;
			}else if(sum<k){
				start++;
			}else{
				System.out.println(table[start]+"+"+table[end]);
				start++;
			}
		}
	}
	//扩展问题
	//如果是3个数字
	public static void find3(int[] table, int k){
		for(int i=0;i<table.length;i++){
			int[] temp = new int[table.length-1];
			for(int j=0;j<table.length-1;j++){
				if(j<i){
					temp[j]=table[j];
				}
				if(j>=i)temp[j]=table[j+1];
			}
			find(temp, k-table[i]);
		}
	}
	//任意个数字,n表示table的下标
	public static Stack<Integer> stack = new Stack<Integer>();
	public static void findAny(int n, int[] table, int k){
		if(n<0||k<=0)return;
		if(k==table[n]){
			for(int i=0;i<stack.size();i++){
				System.out.print(stack.get(i)+"+");
			}
			System.out.println(k+"");
		}
		stack.push(table[n]);
		findAny(n-1, table, k-table[n]);
		stack.pop();
		findAny(n-1, table, k);
	}
}
