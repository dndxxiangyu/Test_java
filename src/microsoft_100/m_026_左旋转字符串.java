package microsoft_100;

import java.util.Arrays;

public class m_026_左旋转字符串 {

	/**
	 * 26.左旋转字符串
	 * 题目：
	 * 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。
	 * 如把字符串abcdef左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。
	 * 要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。
	 */
	public static void main(String[] args) {
		String s = "abcdef";
		char[] in = s.toCharArray();
		new m_026_左旋转字符串().leftChange(in, 2);
		System.out.println(Arrays.toString(in)+"\n****************************");
		new m_026_左旋转字符串().left(s.toCharArray(), 2);
	}
	public void left(char[] in, int left){
		if(in==null)return;
		int len = in.length;
		change1(in,0,len-1);
		change1(in,0,left-1);
		change1(in,left,len-1);
		System.out.println(Arrays.toString(in));
	}
	public void change1(char[] in, int start,int end){
		int i=start,j=end;
		while(i<j){
			char temp = in[i];
			in[i] = in[j];
			in[j] = temp;
			i++;j--;
		}
	}
	
	public void leftChange(char[] in, int leftRound){
		if(in==null)return;
		int len = in.length;
		int l = leftRound%len;
		System.out.println(l+"");
		System.out.println(Arrays.toString(in));
		change(in,0,len-1);
		System.out.println(Arrays.toString(in));
		change(in,0,len-l-1);//改变右边
		change(in,len-l,len-1);//改变左边
	}
	public void change(char[] in, int left, int right){
		for(int i=left;i<left+(right-left+1)/2;i++){
			char temp = in[i];
			in[i] = in[right-i+left];
			in[right-i+left] = temp;
		}
	}
}
