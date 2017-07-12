package microsoft_100;

public class m_003_求子数组的最大和 {

	/**求子数组的最大和：
	 * 输入一个整形数组，数组里有正数也有负数。
	 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
	 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。[1,-1,2,3,-4,-5]]-->2+3最大
	 */
	public static void main(String[] args) {
		int[] input = {1, -2, 3, 10, -4, 7, 2, -5};
		int[] input2 = {1, 2, -1, -3, 3, -4, -5, 7, 8, -1, -2, 10};
		System.out.println(getBig(input2));
	}
	public static int getBig(int[] input){
//		if(input==null)return -1;
//		int len = input.length;
//		//if all are negetive
//		int temp=input[0];
//		int k=0;
//		for(int i=1; i<len;i++){
//			if(temp>input[i])temp = input[i];
//			k=i;
//		}
//		if(temp <= 0){//最大那个还是<=0;
//			return temp;
//		}
//		//存在>0的整数
//		int max1 = 0;
//		int max2 = 0;
//		for(int i=0;i<len;i++){
//			if(input[i]>=0){
//				max1 = max1+input[i];
//			}else{
//				if(max1+input[i] < 0){
//					
//				}
//			}
//			
//		}
//		return -1;
		int sum = Integer.MIN_VALUE;
		int b=0;
		for(int i=0; i<input.length; i++){
			if(b <= 0){
				b = input[i];
			}else{
				b += input[i];
			}
			if(sum < b)sum = b;
		}
		return sum;
	}
}
