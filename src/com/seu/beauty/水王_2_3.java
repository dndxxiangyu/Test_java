package com.seu.beauty;

public class 水王_2_3 {
	/**
	 * 发帖水王问题，其中水王发帖为全部贴的一半以上，找出水王
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int[] table={1,8,8,8,8,8,8,8,88,8,8,8,8,8,2,3,4,5,6,7,7,};
		int[] test = {1,1,1,2,2,2,3,3,3,5};
		System.out.println(findWater(table));
		findThreeWater(test);
	}
	//每次删除两个不同的id，那么剩下的id列表中，水王id出现的次数还是超过总数的一半以上
	//时间复杂度  n
	public static int findWater(int[] table){
		if(table==null||table.length<=0)throw new RuntimeException();
		int len = table.length;
		int count=0;//统计重复的个数
		int current=-1000;//存放两个比较数字中的前一个数字
		for(int i=0;i<len;i++){
			if(count==0){
				current=table[i];
				count++;
			}else{
				if(current==table[i]){
					count++;
				}else{
					count--;
				}
			}
		}
		return current;
	}
	/**
	 * 随着Tango的发展，管理员发现，“超级水王”没有了。统计结果表明，有3个发帖很多的ID，
	 * 他们的发帖数目都超过了帖子总数目N的1/4。你能从发帖ID列表中快速找出他们的ID吗?
	 * 同时删除4个不同的
	 */
	public static void findThreeWater(int[] table){//要调整顺序
		if(table==null||table.length<=0)throw new RuntimeException();
		int len = table.length;
		int count1=0,count2=0,count3=0;
		int[] current = new int[3];
		for(int i=0;i<len;i++){
			if(count1==0){
				current[0] = table[i];
				count1++;
			}else if(table[i] == current[0]){
				count1++;
			}else if(count2==0){
				current[1] = table[i];
				count2++;
			}else if(table[i] == current[1]){
				count2++;
			}else if(count3==0){
				current[2] = table[i];
				count3++;
			}else if(table[i] == current[2]){
				count3++;
			}else{
				count1--;
				count2--;
				count3--;
			}
		}
		System.out.println(current[0]+" "+current[1]+" "+current[2]);
	}
}
