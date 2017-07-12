package microsoft_100;

public class m_014查找两个数使得它们的和正好是输入那个数字 {

	/**
	 * 第 14 题（数组）
	 * 题目：输入一个已经 按升序排过的数组和一个字，
	 * 在数组中查找两个，使得它们的和正好是输入那个数字。
	 * 要求时间复杂度是 O(n) 
	 * 如果有多对数字的和等于输入，出任意一即可例如输入数组 1,2,4,7,11,15 和数字 15,由于4+11=15因此输出4和11
	 */
	public static void main(String[] args) {
		int[] in = {1,2,3,4,5,6,7,8,9,10};
		new m_014查找两个数使得它们的和正好是输入那个数字().get(in, 12);
	}
	public void get(int[] in ,int k){
		int len=in.length;
		int start=0;
		int end = len-1;
		while(start<end){
			int sum = in[start]+in[end];
			if(sum == k){
				System.out.println(in[start]+","+in[end]);
				end--;//加上这一句表示全部可能结果都输出
//				return;
			}else if(sum>k){
				end--;
			}else if(sum <k){
				start++;
			}
		}
	}

}
