package microsoft_100;

import java.lang.reflect.Method;
import java.util.Arrays;

public class m_053字符串的全排列 {

	/**
	 * 53.字符串的全排列。
	题目：输入一个字符串，打印出该字符串中字符的所有排列。
	例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串
	abc、acb、bac、bca、cab和cba。
	 */
	public static void main(String[] args) {
		char[] in = "abcd".toCharArray();
		new m_053字符串的全排列().recursion(in,0);
		
	}
	public void recursion(char[] in, int start){
		if(start==in.length){
			System.out.println(Arrays.toString(in));
		}
		for(int i=start;i<in.length;i++){//循环n次，第start位
			char temp = in[start];
			in[start] = in[i];
			in[i]=temp;
			recursion(in,start+1);
			temp = in[start];
			in[start]=in[i];
			in[i]=temp;
		}
	}
}
