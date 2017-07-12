package com.seu.beauty;

import java.util.Arrays;

public class 买书_1_4 {

	/**
	 * 5种书，不同的一起买可以打折,一般8快
	 * 2 5%
	 * 3 10%
	 * 4 20%
	 * 5 25%
	 */
	public static void main(String[] args) {
		int[] table={1,1,1,1,1};
		System.out.println(get(table));
	}
	public static float get(int[] table){
		if(table==null)throw new RuntimeException("table is null");
		if(table.length!=5)throw new RuntimeException();
		if(table[0]==0&&table[1]==0&&table[2]==0&&table[3]==0&&table[4]==0)return 0;
		Arrays.sort(table);
		float[] min = new float[5];
		for(int i=0;i<5;i++){
			min[i]=Integer.MAX_VALUE;
		}
		if(table[0]>=1){
			table[0]--;
			table[1]--;
			table[2]--;
			table[3]--;
			table[4]--;
			min[0]= (float) (5*8*(1-0.25)+get(table));
		}
		if(table[1]>=1){
			table[1]--;
			table[2]--;
			table[3]--;
			table[4]--;
			min[1]=(float) (4*8*(1-0.2)+get(table));
		}
		if(table[2]>1){
			table[2]--;
			table[3]--;
			table[4]--;
			min[2]=(float) (3*8*(1-0.1)+get(table));
		}
		if(table[3]>=1){
			table[3]--;
			table[4]--;
			min[3]=(float) (2*8*(1-0.05)+get(table));
		}
		if(table[4]>=1){
			table[4]--;
			min[4]=8+get(table);
		}
		Arrays.sort(min);
		System.out.println(Arrays.toString(min));
		return min[0];
	}
}
