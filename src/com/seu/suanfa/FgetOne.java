package com.seu.suanfa;

public class FgetOne {

	/**
	 * f(n)表示0~n中1的个数
	 */
	public static void main(String[] args) {
		
		System.out.println(getOne(3));
		System.out.println(getOne2(3));
	}
	public static int getOne2(int n){
		if(n<=0)return 0;
		String s = n+"";
		int len = s.length();
		int left=0;
		int right=0;
		int now = 0;
		int num = 0;
		for(int i=0;i<len;i++){
			left = n/(int)Math.pow(10, len-1-i)/10;
			now  = n/(int)Math.pow(10, len-1-i)%10;
			right = n%(int)Math.pow(10, len-1-i);
			if(now ==1){
				num = num + left*(int)Math.pow(10, len-1-i)+right+1;
			}else if(now==0){
				num = num + left*(int)Math.pow(10, len-1-i);
			}else if(now >=2){
				num = num + (left+1)*(int)Math.pow(10, len-1-i);
			}
		}
		return num;
	}
	public static int getOne(int n){
		String s = n+"";
		int number=0;
		int a=0;
		int b=0;
		int c=0;
		int len =s.length() ;
		System.out.println("数字长度："+len);
		if(len!=0){
			for(int i=0;i<len;i++){
				a=(int) Math.pow(10, len-1-i);
				b=(int) Math.pow(10, len-i);
				System.out.println("a:"+a+" b:"+b);
				c=n%b/a;//得到某位上的数值
				if(c==1){
					number = number  + n/b*a + n%a+1;
				}else if(c==0){
					number = number + n/b*a;
				}else{
					number = number + (n/b+1)*a;
				}
			}
		}
		
		return number;
	}
}
