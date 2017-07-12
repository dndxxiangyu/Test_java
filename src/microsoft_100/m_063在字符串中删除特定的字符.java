package microsoft_100;

import java.util.Arrays;

public class m_063在字符串中删除特定的字符 {

	/**
	 * 63.在字符串中删除特定的字符。
	题目：输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
	例如，输入”They are students.”和”aeiou”， 则删除之后的第一个字符串变成”Thy r stdnts.”。
	 */
	public static void main(String[] args) {
		System.out.println(' '-'a');
		String a="theyarestudents";
		String b="aeiou";
		new m_063在字符串中删除特定的字符().get(a.toCharArray(), b.toCharArray());
	}
	public void get(char[] a, char[] b){
		int lena=a.length;
		int lenb=b.length;
		int[] temp = new int[26];
		//找出b中有的字符，在temp中标记
		for(int i=0;i<lenb;i++){
			temp[b[i]-'a']=1;
		}
		System.out.println(Arrays.toString(temp));
		int count=0;
		for(int i=0;i<lena;i++){
			if(temp[a[i]-'a']==1){
				count++;
			}
		}
		System.out.println("count:"+count);
		int length=lena-lenb;
		int index=0;
		for(int i=0;i<length;i++){
			while(temp[a[index]-'a']==1){
				index++;
			}
			a[i] = a[index];
			index++;
		}
		System.out.println(new String(a,0,length));
	}
}
