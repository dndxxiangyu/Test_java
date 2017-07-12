package com.seu.suanfa;

public class Sushu {

	//素数
	public static void main(String[] args) {
		
//		System.out.println(" n 是不是素数："+isSushu(19));
//		getSushu();
		zhiyingshu(13);
	}
	public static void getSushu(){
		for(int i=2; i<=100; i++){
			int temp = (int) Math.sqrt(i);
			if(i<=3){
				System.out.println(i+" is a prime");
			}else{
				for(int j=2;j<=temp;j++){
					if(i%j==0){
						break;
					}
					if(j>=temp){
						System.out.println(i+" is a prime");
						break;
					}
				}
			}
		}
	}
	
	public static boolean isSushu(int n){
		if(n < 2)return false;
		if(n == 2)return true;
		if(n%2 == 0)return false;
		int temp = (int)Math.sqrt(n);
		for(int i=3; i<=temp; i+=2){
			if(n%i == 0) return false;
		}
		return true;
	}
	public static void zhiyingshu(int n){
		if(n<=0)return;
		int x=n;
		while(true){
			int i=2;
			for(;i<=x;i++){
				int t = x%i;
				if(t==0){
					System.out.println(i+",");
					x=x/i;
					break;
				}
			}
			if(i==x){
				System.out.println(i+",");
				break;
			}
		}
	}
}
