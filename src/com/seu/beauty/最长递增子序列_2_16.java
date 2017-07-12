package com.seu.beauty;

public class 最长递增子序列_2_16 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int[] input = {1, -2, 3, 10, -4, 7, 2, -5};
		int[] input2 = {1, 2, -1, -3, 3, -4, -5, 7, 8, -1, -2, 10};

	}

	public static int findLong(int[] table){
		int length = table.length;
		int[] len = new int[length];
		for(int i=0;i<length;i++){
			len[i]=1;
		}
		for(int i=1;i<length;i++){
			for(int j=i-1;j>=0;j--){
				if(table[i]>table[j]&&len[i]<len[j]+1){
					len[i]=len[j]+1;
				}
			}
		}
		int max=0;
		for(int i=0;i<length;i++){
			if(len[i]>max)max=len[i];
		}
		return max;
	}
	public static int findLong2(int[] table){
		int length = table.length;
		int[] len = new int[length];
		int[] maxv = new int[length];//存储长度为i是对应的最小值。
		for(int i=0;i<length;i++){
			len[i]=1;
		}
		for(int i=1;i<length;i++){
			for(int j=i-1;j>=0;j--){
				if(table[i]>table[j]&&len[i]<len[j]+1){
					len[i]=len[j]+1;
				}
			}
		}
		int max=0;
		for(int i=0;i<length;i++){
			if(len[i]>max)max=len[i];
		}
		return max;
	}
}
