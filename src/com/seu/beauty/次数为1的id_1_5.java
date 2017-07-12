package com.seu.beauty;

import java.util.Random;

public class 次数为1的id_1_5 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int[] table={1,1,2,2,3,3,4,4,5};
		int[] table1={11,1,2,2,3,3,4,4,11,6};
		System.out.println(get(table));
		get2(table1);
		System.out.println(get());
	}
	// 只有一个id是单个出现，其他的成对
	public static int get(int[] table){
		if(table==null)throw new RuntimeException();
		int len = table.length;
		int result=0;
		for(int i=0;i<len;i++){
			result = result^table[i];
		}
		return result;
	}
	//有两个id是不同的，其他的都相同
	public static void get2(int[] table){
		if(table==null)throw new RuntimeException();
		int len = table.length;
		int result=0;
		for(int i=0;i<len;i++){
			result = result^table[i];
		}
		int index=0;//第几位出现非0，即1
		while(1!=(result&1)){
			index++;
			result = result>>1;
		}
		int first=0,second=0;
		for(int i=0;i<len;i++){
			if(1==((table[i]>>index)&1)){
				first=first^table[i];
			}else{
				second =second^table[i];
			}
		}
		System.out.println("两个值："+first+","+second);
	}
	//扩展：从一副扑克牌中抽出一张(没有大小王)，怎么知道是哪一张
	public static int get(){
		int[] table={1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13};
		int index=new Random().nextInt(52);
		System.out.println(index);
		int answer=0;
		for(int i=0;i<table.length;i++){
			if(i==index){
				continue;
			}
			answer = answer^table[i];
		}
		return answer;
	}
}
