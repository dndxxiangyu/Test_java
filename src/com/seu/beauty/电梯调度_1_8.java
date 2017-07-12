package com.seu.beauty;

public class 电梯调度_1_8 {

	/**
	 * 电梯停在某一层，使得所有差值最少
	 */
	public static void main(String[] args) {
		
		
	}
	//在第i层的N2个乘客，i层以下的N1个乘客，i层以上的N3个乘客
	//第一次停在第一层的时候Y
	//table表示到达每层的人数table[0]表示到第一层的人数
	public static int getFloor(int[] table){//第一个表示第二层的
		int len = table.length;
		int floor=0;//表示第二层
		int y=0;
		int N1=0;
		int N2=0;
		int N3=0;
		N2=table[0];
		//表示第一次停在第2层
		for(int i=1;i<len;i++){
			N3 += table[i];
			y=y+table[i]*i;
		}
		for(int i=1;i<len;i++){
			if(N1+N2<N3){
				floor=i;
				y = y+N1+N2-N3;
				N1 = N1+N2;
				N2 = table[i];
				N3 = N3- table[i];
			}
		}
		return floor+2;
	}
}
