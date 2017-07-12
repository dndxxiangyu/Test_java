package com.seu.beauty;

import java.util.Arrays;

public class 寻找数组中最大值和最小值_2_10 {
	/**
	 * 正常想法是扫描两遍
	 * @param args
	 */
	public static void main(String[] args){
		int[] table	= {10,2,4,15,5,6};
		findMinAMax(table);
		findByTwo(table);
		System.out.println(findSecondBig(table));
	}
	//这样要比较2n次
	public static void findMinAMax(int[] table){
		int a=Integer.MIN_VALUE;
		int b=Integer.MAX_VALUE;
		for(int i=0;i<table.length;i++){
			if(table[i]>a){
				a=table[i];
			}
			if(table[i]<b){
				b=table[i];
			}
		}
		System.out.println("max:"+a+"\nmin:"+b);
	}
	//对数组进行两个两个才拆分
	public static void findByTwo(int[] table){
		for(int i=1;i<table.length;i++,i++){
			if(table[i-1]<table[i]){//大的在钱面
				int temp=table[i-1];
				table[i-1]=table[i];
				table[i]=temp;
			}
		}
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<table.length;i++,i++){
			if(table[i]>max)max=table[i];
		}
		for(int i=1;i<table.length;i++,i++){
			if(table[i]<min)min=table[i];
		}
		System.out.println("max:"+max+"\nmin:"+min);
	}
	//找出第二大的数,时间复杂度1.5n而不是2n,像希尔排序，对比次数为n
	//第一次吧数组分成两组，然后把大的交换到左边，但是第二大的也可能交换到右边去了，所以对左边求出前两个比较大的，第二大的也可能在有半部分，
	//所以对有部分进行遍历对比，找到最大的，然后和左边第二大的进行对比。
	public static int findSecondBig(int[] table){
		System.out.println(Arrays.toString(table));
		int len = table.length;
		while(len>2){
			int index=(len+1)/2;
			for(int i=index;i<len;i++){
				if(table[i-index]<table[i]){
					int temp=table[i-index];
					table[i-index]=table[i];
					table[i]=temp;
				}
				System.out.println(Arrays.toString(table));
			}
			System.out.println("len:"+len+"\nindex:"+index);
			len=index;
		}
		System.out.println(Arrays.toString(table));
		int max2=Integer.MIN_VALUE;
		for(int i=(table.length+1)/2;i<table.length;i++){
			if(table[i]>max2)max2=table[i];
		}
		System.out.println("max2:"+max2);
		if(table[0]>table[1]){
			if(max2>table[1]){
				return max2;
			}else{
				return table[1];
			}
		}
		else{
			if(max2>table[0]){
				return max2;
			}else{
				return table[0];
			}
		}
	}
	public static int findSecondBig2(int[] table){
		
		return -1;
	}
}
