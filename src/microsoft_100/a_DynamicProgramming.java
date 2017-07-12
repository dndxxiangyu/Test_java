package microsoft_100;

import java.util.Stack;

public class a_DynamicProgramming {

	/**
	 * 动态规划：0-1背包问题
	 * a:找出最优解的性质，并刻画其结构特征
	 * b:递归的定义最优解的值
	 * c:以自底向上的方式计算出最优值
	 */
	Stack<Integer> arr = new Stack<Integer>();
	public static void main(String[] args) {
		int[] v={4,5,10,11,13};
		int[] w={3,4,7 ,8 ,9};
		int[] table={1,2,3,4,5,6,7,8,9,10};
		table = new int[100];
		for(int i=0;i<100;i++){
			table[i] = i;
		}
		System.out.println(new a_DynamicProgramming().max(4, 17, w, v));
		new a_DynamicProgramming().find(10, 11);
		System.out.println("find2_____>");
		new a_DynamicProgramming().find2(table.length-1, table, 5);
	}
	//n表示元素个数，w表示总共重量
	public int max(int n, int w, int[] weight, int[] value){
		if(n==-1||w==0)return 0;
		if(weight[n]>w)return max(n-1,w,weight,value);//如果超重，则不加
		
		int a1 = max(n-1,w,weight,value);//不包含
		int a2 =max(n-1,w-weight[n],weight,value)+value[n];
		if(a1>a2)
			return a1;
		else
			return a2;
	}
	public int bag(int[] table,int weight,int[] value){
		int[][] temp = new int[table.length+1][weight+1];
		for(int i=0;i<table.length;i++){
			for(int j=0;j<weight;j++){
				if(i==0||j==0){
					temp[i][j]=0;
				}else{
					if(table[i]<=j){
						temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-table[i]]+value[i]);
					}else{
						temp[i][j] = temp[i-1][j];
					}
				}
			}
		}
		return temp[table.length][weight];
	}
	//完全背包问题 n=m-1;
	public void find(int n, int m){
		if(n<=0||m<=0)return;
		if(m==n){
			for(int i=0;i<arr.size();i++){
				System.out.print(arr.get(i)+"+");
			}
			System.out.println(n+"");
		}
		arr.push(n);
		find(n,m-n);
		arr.pop();
		find(n-1,m);
	}
	//数组中任意个数之和为给定的m,n为下标，从0开始
	public void find2(int n, int[] table, int m){
		if(n<0||m<=0)return;
		if(m==table[n]){
			for(int i=0;i<arr.size();i++){
				System.out.print(arr.get(i)+"+");
			}
			System.out.println(table[n]+"");
		}
		arr.push(table[n]);
		find2(n-1,table,m-table[n]);
		arr.pop();
		find2(n-1,table,m);
	}
}
