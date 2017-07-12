package com.seu.beauty;

public class 对1的数目 {

	/**
	 * 从1,2,3,4,5...,n中，总共1的个数
	 */
	public static void main(String[] args) {
		System.out.println(getOne2(133));
		System.out.println(getOne(133));
		
	}
	//统计每个数
	public static int getOne(int n){
		int num=0;
		for(int i=1;i<=n;i++){
			int k=i;
			while(k!=0){
				if(k%10==1)num++;
				k = k/10;
			}
		}
		return num;
	}
	
	//对每个位置上进行统计
	public static int getOne2(int n){
		if(n<=0)return -1;
		String s = n+"";
		int len = s.length();
		int num=0;
		int front=0;
		int index=0;//index表示要求的那一位，只有一位
		int after=0;//把n分成三部分，front index after，index表示要找的求职的那一位。
		if(len>0){
			for(int i=0;i<len;i++){
				front=n/(int)Math.pow(10, len-i);
				index= n/(int)Math.pow(10, len-i-1)%10;
				after=n%(int)Math.pow(10, len-i-1);
				System.out.println("front:"+front+"index:"+index+"after:"+after);
				if(index==0){
					num = num+front*(int)Math.pow(10, len-i-1);
				}else if(index==1){
					num = num+front*(int)Math.pow(10, len-i-1)+after+1;
				}else if(index>=2){
					num=num+(front+1)*(int)Math.pow(10, len-i-1);
				}
			}
		}
		return num;
	}

}
