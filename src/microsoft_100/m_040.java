package microsoft_100;

import java.util.HashSet;

public class m_040 {

	/**
	 * 2.就是给一个很长的字符串str,还有一个字符集比如{a,b,c},找出str里包含{a,b,c}的最短子串.
	 * 要求O(n)?
	 * 比如,字符集是a,b,c,字符串是abdcaabcx,则最短子串为abc
	 */
	public static void main(String[] args) {
		
		new m_040().get("abdcaabcx", "abc");
	}
	//第二遍
	public void get2(String s, String param){
		char[] in = s.toCharArray();
		int len = in.length;
		char[] p = param.toCharArray();
		int sum  = 0;//两个指针之间包含的param中的字母个数。
		
	}
	//用两个变量 front，rear 指向一个的子串区间的头和尾
	public void get(String s, String param){
		char[] in = s.toCharArray();
		int len = in.length;
		char[] a = param.toCharArray();
		HashSet<Character> set = new HashSet<Character>();
		HashSet<Character> set1 = new HashSet<Character>();
		for(int i=0;i<a.length;i++){
			set.add(a[i]);
		}
		
		char[] temp = new char[26];
		
		int front =0,rear=0;//头尾指针
		int sum = 0;
		while(front<len&&rear<len){
			if(sum == a.length){
				for(int i=front;i<rear;i++){
					System.out.print(in[i]+"");
				}
				System.out.println();
				if(set1.contains(in[front])){
					boolean b = true;
					for(int i=front+1;i<rear;i++){
						if(in[i]==in[front])b = false;
					}
					if(b){
						set1.remove(in[front]);
						sum--;
					}
				}
				front++;
			}else{
				if(set.contains(in[rear])&&!set1.contains(in[rear])){
					sum++;
					set1.add(in[rear]);
				}
				rear++;
			}
			
		}
	}
}
