package com.seu.beauty;

public class 子数组的最大乘积_2_13 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		

	}
	public static int findBig(int[] table){
		int len=table.length;
		int odd=len%2;//如果是奇数，则odd为1，如果为偶数则odd为0；
		int zero_num=0;
		int negative_num=0;
		for(int i=0;i<table.length;i++){
			if(table[i]==0){
				zero_num++;
			}else if(table[i]<0){
				negative_num++;
			}
		}
		if(zero_num>=2)return 0;
		if(zero_num==1&&negative_num%2==0){
			
		}else if(zero_num==1&&negative_num%2!=0){
			return 0;
		}
		if(negative_num%2==1){
			//找出比0小但是是最大的那个数，然后其他的相乘
		}else{
			//说明负数为偶数个，找出大于0，且最小的数，然后其他的相乘
		}
		return -1;
	}
	public static int getMaxSum(int[] table){
		if(table==null)throw new RuntimeException();
		int neg=0;
		int zero=0;
		int leng = table.length;
		for(int i=0;i<leng;i++){
			if(table[i]==0){
				zero++;
			}else if(table[i]<0){
				neg++;
			}
		}
		if(zero==0){
			
		}
		return -1;
	}
}
