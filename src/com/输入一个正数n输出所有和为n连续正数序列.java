package com;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2016-2-16 下午6:12:05
 */
public class 输入一个正数n输出所有和为n连续正数序列 {

	
	public static void main(String[] args) {
		inputN(15);

	}

	public static void inputN(int n){
		if(n <= 0)return;
		int i=1, j=1;
		int sum = i;
		while(j <= (n+1)/2){
//			sum = sum + j;
			if(sum < n){
				j++;
				sum += j;
			}else if(sum == n){
				System.out.println(i+"-"+j);
				j++;
				sum += j;
			}else if(sum > n){
				sum -= i;
				i++;
			}
		}
	}
}
