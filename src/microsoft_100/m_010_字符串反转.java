package microsoft_100;

import java.util.Arrays;

public class m_010_字符串反转 {

	/**
	 * 第 10 题（字符串）
	 * 翻转句子中单词的顺序。
	 * 题目：输入一个英文句子，翻转中单词的顺序但内字符不变。
	 * 句子中单词以空格符隔开。
	 * 为简起见，标点号和普通字母一样处理例如输入“I am a student.”，则输出“ student. a am I”
	 */
	public static void main(String[] args) {
		char[] in1= {'I',' ','a','m',' ','a',' ','s','t','u','d','e','n','t'};
		char[] in= {'Y','o','u',' ','a','r','e',' ','a',' ','s','t','u','d','e','n','t'};
		System.out.println(new String(in));
		new m_010_字符串反转().changeChar(in);
		System.out.println(new String(in));
		System.out.println("*****************************");
		String string = "you are  a student ";
		System.out.println(Arrays.toString(string.split(" ")));
	}
	public void changeChar(char[] in){
		int len = in.length;
		System.out.println("len:"+len);
		//翻转
		for(int i=0; i<len/2;i++){
			char temp = in[i];
			in[i] = in[len-i-1];
			in[len-i-1] = temp;
		}
		System.out.println(Arrays.toString(in));
		int start=0;
		int end =0;
		for(int i=0;i<len;i++){
			end=i;
			if(in[i] == ' '){
				System.out.println("end:"+end);
				
				for(int j=start;j<start+(end-start)/2;j++){
					char te = in[j];
					in[j] = in[end-j-1+start];
					in[end-j-1+start] = te;
				}
				System.out.println(Arrays.toString(in));
				start = end+1;
				System.out.println("start:"+start);
			}
			if(end==len-1&&end>start){
				System.out.println("end:"+end+"start:"+start);
				for(int j=start;j<start+(end+1-start)/2;j++){
					char te = in[j];
					in[j] = in[end-j+start];
					in[end-j+start] = te;
				}
			}
		}
	}
}
