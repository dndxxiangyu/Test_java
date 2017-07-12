package microsoft_100;

public class a_DivideAndConquer {

	/**
	 * 分治法求最大子串的和
	 * 分治法的要求：
	 * a:分问题
	 * b:递归
	 * c:合并的算法
	 */
	public static void main(String[] args) {
		int[] in = {-2,11,-4,13,-5,-2};
		new a_DivideAndConquer().max_sub_sum(in, 0, in.length-1);
		System.out.println(new a_DivideAndConquer().max_sub_sum(in, 0, in.length-1));
	}
	
	public int max_sub_sum(int[] table, int left, int right){
		int sum = Integer.MIN_VALUE;
		if(left>=right)return table[left];
		//a
		int mid = (left+right)/2;
		//b
		int leftSum = max_sub_sum(table, left, mid);//递归
		int rightSum = max_sub_sum(table, mid+1, right);
		//c
		int maxl = Integer.MIN_VALUE;
		int t=0;
		//从中间向左遍历
		for(int i=mid; i>=left; i--){
			t = t+table[i];
			if(t>maxl)maxl = t;
		}
		int maxr = Integer.MIN_VALUE;
		t=0;
		//从中间向右遍历
		for(int i=mid+1; i<=right; i++){
			t = t+table[i];
			if(t>maxr)maxr = t;
		}
		sum = maxl+maxr;
		//比较左边的打，还是右边的打，还是中间的大
		if(sum<rightSum){
			sum = rightSum;
		}
		if(sum<leftSum){
			sum = leftSum;
		}
		return sum;
	}
}
