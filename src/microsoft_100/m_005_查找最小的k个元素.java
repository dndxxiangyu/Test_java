package microsoft_100;

import java.util.Stack;

import yeheya.SortClass;


public class m_005_查找最小的k个元素 {

	/**
	 * 查找最小的k个元素（数组）
	 * 题目：输入n个整数，输出其中最小的k个。
	 * 例如输入 1,2,3,4,5,6,7和 8这 8个数字，则最小的4个数字为 1,2,3和4
	 */
	//注意：得看k的大小来决定
	public static void main(String[] args) {
		int[] table = {8,7,6,5,4,3,2,1};
		int k=4;
		new m_005_查找最小的k个元素().get(table, k);
	}
	//1.直接对数组排序，然后取排序后的前面k个最小值:o(nlogn)
	public void get(int[] table,int k){
		SortClass.quickSort(table, 0, table.length-1);
		for(int i=0;i<k;i++){
			System.out.print(table[i]+" ");
		}
	}
	//2.维护一个一维的k数组，O(n*k)
	//3.维护一个k个元素的大顶堆，建堆O(k),更新堆O(logk),O(k+(n-k)logk)
}
