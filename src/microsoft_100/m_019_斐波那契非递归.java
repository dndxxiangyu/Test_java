package microsoft_100;

public class m_019_斐波那契非递归 {

	/**
	 * 第19题：
	 * 题目：定义Fibonacci数列如下：  
	 *   /   0           n=0
	 * f(n)= 1           n=1,2
	 *   / f(n-1)+f(n-2) n>2
	 */
	public static void main(String[] args) {
		System.out.println(~3);
		System.out.println(new m_019_斐波那契非递归().recursion(10));
		System.out.println(new m_019_斐波那契非递归().fibonacci(100));
		int[][] x = new int[3][];
	}
	public int recursion(int n){
		if(n<=2){
			return 1;
		}
		return recursion(n-1)+recursion(n-2);
	}
	public int fibonacci(int n){
		if(n<0)return -1;
		if(n==0)return 0;
		if(n==1||n==2)return 1;
		int a=1,b=1;
		int[] answer=new int[n+1];
		answer[0]=0;
		answer[1]=1;
		answer[2]=1;
		for(int i=3;i<=n;i++){
			answer[i] = answer[i-1]+answer[i-2];
			System.out.println(answer[i]+" "+"i:"+i);
		}
		return answer[n];
	}
}
