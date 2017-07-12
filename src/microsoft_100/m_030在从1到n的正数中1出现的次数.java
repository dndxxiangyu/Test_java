package microsoft_100;

public class m_030在从1到n的正数中1出现的次数 {

	/**
	 * 30.在从1到n的正数中1出现的次数
	 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
	 */
	public static void main(String[] args) {
//		new m_030().getOne(1230);
		System.out.println(new m_030在从1到n的正数中1出现的次数().getOne(12));
	}
	//分别计算每位上出现的次数
	public int getOne(int n){
		if(n<=0)return 0;
		int num = 0;
		int len = (n+"").length();
		int a=0;//前面的全部
		int b=0;//本位一个数字
		int c=0;//余下的后面全部数字
		for(int i=0; i<len; i++){
			a =  n/(int)Math.pow(10, len-i);
			b = n%(int)Math.pow(10, len-i)/(int)Math.pow(10, len-i-1);
			c = n%(int)Math.pow(10, len-i)%(int)Math.pow(10, len-i-1);
			System.out.println(a+":"+b+":"+c);
			if(b==0){
				num = num+a*(int)Math.pow(10, len-i-1);
			}else if(b==1){
				num = num+a*(int)Math.pow(10, len-i-1)+c+1;
			}else if(b>=2){
				num = num+(a+1)*(int)Math.pow(10, len-i-1);
			}
		}
		return num;
	}
}
