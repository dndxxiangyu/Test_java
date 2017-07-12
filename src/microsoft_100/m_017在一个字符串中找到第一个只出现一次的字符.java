package microsoft_100;

public class m_017在一个字符串中找到第一个只出现一次的字符 {

	/**
	 * 第17题：
     * 题目：在一个字符串中找到第一个只出现一次的字符。
     * 如输入abaccdeff，则输出b
	 */
	public static void main(String[] args) {
		System.out.println('a'-'z');
		char[] in="abaccdeffb".toCharArray();
		System.out.println(new m_017在一个字符串中找到第一个只出现一次的字符().getFirstNotSame(in));
	}
	public char getFirstNotSame(char[] in){
		int len = in.length;
		int[] temp = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(temp.length);
		for(int i=0;i<len;i++){
			temp[in[i]-'a']++;
		}
		for(int i=0;i<len;i++){
			if(temp[in[i]-'a']==1){
				return in[i];
			}
		}
		return 0;
	}
}
