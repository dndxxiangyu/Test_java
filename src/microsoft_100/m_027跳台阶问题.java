package microsoft_100;

public class m_027跳台阶问题 {

	/**
	 * 27.跳台阶问题
	 * 题目：一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。
	 * 求总共有多少总跳法，并分析算法的时间复杂度。
	 */
	public static void main(String[] args) {
		m_027跳台阶问题 m =new m_027跳台阶问题();
		System.out.println(m.jump(100));
	}
	public int jump(int n){
		if(n<=0)return 0;
		if(n==1)return 1;
		if(n==2)return 2;
		int a=1,b=2;
		int temp = 0;
		for(int i=3;i<=n;i++){
			temp = a+b;
			a = b;
			b = temp;
			System.out.print(temp+" ");
		}
		return temp;
	}
	public int jump2(int n){
		if(n<=0)return 0;
		if(n==1)return 1;
		if(n==2)return 2;

		return jump2(n-1)+jump2(n-2);
	}
}
