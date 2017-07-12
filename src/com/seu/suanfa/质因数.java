package com.seu.suanfa;

public class 质因数 {

	/**
	 * 分解质因数问题
	 */
	public static void main(String[] args) {
		
		get(99);
	}
	static void fun(int x){//分解正数x并将质因子输出的方法
		int i=0;
		int k=x;
		System.out.print(x+"的质因子为：");
		while(true){
			for(i=2;i<=k;i++){
				if(k%i==0){
					System.out.print(i);//i即为素因子，可传至数组另存
					k=k/i;
					break;
				}
			}
			if(k==1)
				break;
			System.out.print("*");
		}
	}
	static void get(int n){
		if(n<=1)return;
		int k=n;
		while(k!=1){
			for(int i=2;i<=k;i++){
				if(k%i==0){
					System.out.print(i);
					k = k/i;
					break;
				}
			}
			System.out.print(",");
		}
	}
}
