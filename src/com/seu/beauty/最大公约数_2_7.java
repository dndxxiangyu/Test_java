package com.seu.beauty;

public class 最大公约数_2_7 {
	
	public static void main(String[] args){
		System.out.println(find2(42,30));
	}
	public static int find(int a, int b){
		if(a<=0||b<=0)return -1;
		while(b!=0){
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	//由于取模开销高，所以用减法
	public static int find2(int a, int b){
		if(a<b){
			return find2(b,a);
		}
		if(b==0){
			return a;
		}else{
			return find2(a-b,b);
		}
	}
}
