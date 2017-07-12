package microsoft_100;

public class m_028二进制中1的个数 {

	/**
	 * 28.整数的二进制表示中1的个数
	 * 题目：输入一个整数，求该整数的二进制表达中有多少个1。
	 * 例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
	 */
	public static void main(String[] args) {
		System.out.println(count(10));
		System.out.println(count2(10));
		System.out.println(Integer.toHexString(255));
		count1(10);
	}
	public static void count1(int n){
		int count=0;
		while(n!=0){
			n = n&(n-1);
			count++;
		}
		System.out.println(count+"");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int count(int n){
		int num=0;
		while(n>0){
			num = num + (n&0x01);
			System.out.println(num);
			n = n>>1;
		}
		return num;
	}
	//好办法
	public static int count2(int n){
		int num=0;
		while(n>0){
			n = n&(n-1);
			num++;
		}
		return num;
	}
}
