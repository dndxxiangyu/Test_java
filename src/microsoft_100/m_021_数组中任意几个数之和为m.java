package microsoft_100;

import java.util.Stack;

public class m_021_数组中任意几个数之和为m {

	/**
	 * 第21题
	 * 2010年中兴面试题
	 * 编程求解：
	 * 输入两个整数 n 和 m，从数列1,2,3.......n 中 随意取几个数
	 * 使其和等于m,要求将其中所有的可能组合列出来.
	 */
	Stack<Integer> arr = new Stack<Integer>();
	public static void main(String[] args) {
		
		new m_021_数组中任意几个数之和为m().find(10, 14);
	}
	public void find(int n, int m){
		if(n<=0||m<=0){
			return;
		}
		if(m==n){
			for(int i=0;i<arr.size();i++){
				System.out.print(arr.get(i)+"+");
			}
			System.out.println(n+"");
		}
		arr.push(n);
		find(n-1,m-n);
		arr.pop();
		find(n-1,m);
	}
}
