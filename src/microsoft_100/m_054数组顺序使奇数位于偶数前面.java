package microsoft_100;

import java.util.Arrays;

public class m_054数组顺序使奇数位于偶数前面 {

	/**
	 * 54.调整数组顺序使奇数位于偶数前面。
	题目：输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，
	所有偶数位于数组的后半部分。要求时间复杂度为O(n)。
	 */
	public static void main(String[] args) {
		System.out.println("c");
		int[] table = {11,10,7,5,9,2,12};
		m_054数组顺序使奇数位于偶数前面 m = new m_054数组顺序使奇数位于偶数前面();
		m.get(table);
		System.out.println(Arrays.toString(table));
	}
	public void get(int[] table){
		int start=0;
		int end=table.length-1;
		while(start<end){
			if(table[start]%2==0){//偶数
				int temp = table[start];
				table[start] = table[end];
				table[end] = temp;
				end--;
			}else{
				start++;
			}
		}
	}
}
