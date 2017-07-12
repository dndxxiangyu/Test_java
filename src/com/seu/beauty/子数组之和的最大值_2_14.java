package com.seu.beauty;

public class 子数组之和的最大值_2_14 {

	/**
	 * 
	 */
	public static void main(String[] args) {
		int[] input = {1, -2, 3, 10, -4, 7, 2, -5};
		int[] input1={-3,-2,-1,-3};
		int[] input2 = {1, 2, -1, -3, 3, -4, -5, 7, 8, -1, -2, 10};
		System.out.println(getLongBig(input));
		System.out.println(max_sub_sum(input,0,input.length-1));
		System.out.println(max(input, 0));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(max(input1, 0));
		System.out.println(max(input2, 0));
		System.out.println(max_sub_sum(input1, 0, input1.length-1));
		System.out.println(max_sub_sum(input2, 0, input2.length-1));
	}
	public static int getLong2(int[] table){
		return -1;
	}
	public static int getLongBig(int[] table){
		int sum=Integer.MIN_VALUE;
		int temp=0;
		for(int i=0;i<table.length;i++){
			if(temp<=0){
				temp=table[i];
			}else{
				temp += table[i];
			}
			if(sum<temp){
				sum=temp;
			}
		}
		return sum;
	}
	//分治法
	public static int max_sub_sum(int[] table, int left, int right){
		int sum = Integer.MIN_VALUE;
		if(left>=right)return table[left];
		//a
		int mid = (left+right)/2;
		//b
		int leftSum = max_sub_sum(table, left, mid);//递归
		int rightSum = max_sub_sum(table, mid+1, right);
		//c
		int maxl = Integer.MIN_VALUE;
		int t=0;
		//从中间向左遍历
		for(int i=mid; i>=left; i--){
			t = t+table[i];
			if(t>maxl)maxl = t;
		}
		int maxr = Integer.MIN_VALUE;
		t=0;
		//从中间向右遍历
		for(int i=mid+1; i<=right; i++){
			t = t+table[i];
			if(t>maxr)maxr = t;
		}
		sum = maxl+maxr;
		//比较左边的打，还是右边的打，还是中间的大
		if(sum<rightSum){
			sum = rightSum;
		}
		if(sum<leftSum){
			sum = leftSum;
		}
		return sum;
	}
	//动态规划,wrong
//	public static int max_sub_sum2(int[] table, int n){
//		if(n<0)return 0;
//		int a0=table[n];
//		int a1 = max_sub_sum2(table, n-1);
//		int a2 = max_sub_sum2(table,n-1)+table[n];
//		if(a1>a2){
//			if(a1>a0){
//				return a1;
//			}else{
//				return a0;
//			}
//		}else{
//			if(a2>a0){
//				return a2;
//			}else{
//				return a0;
//			}
//		}
//	}
	//k==0; right
	public static int max=Integer.MIN_VALUE;//保存后面加到前面的连续的最大值
	public static int max(int[] table, int k){
		if(k>table.length-1){
			return Integer.MIN_VALUE;
		}
		int a1=table[k];
		int a2=Integer.MIN_VALUE;
		int temp=0;
		int a3=max(table,k+1);
		//这里写的不好
//		for(int i=k+1;i<table.length;i++){
//			temp=temp+table[i];
//			if(temp>a2)a2=temp;
//		}
		if(table.length-1==k){
			max=Integer.MIN_VALUE;
		}
		if(max<0){
			max=table[k];
		}else{
			max=table[k]+max;
		}
		a2=max;
		if(a1<a2){
			if(a2>a3){
				return a2;
			}else{
				return a3;
			}
		}else{
			if(a1>a3){
				return a1;
			}else{
				return a3;
			}
		}
	}
}
