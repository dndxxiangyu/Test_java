package com.seu.suanfa;

public class Find23 {

	/**
	 * 在一串字符串中找出23
	 * abc235fadfds34fdf23545
	 */
	public static void main(String[] args) {
		
		new Find23().get("abc235fadfds34fdf23545", "235");
	}
	public void get1(String s,String param){
		char[] in = s.toCharArray();
		char[] temp = param.toCharArray();
		int len2 = temp.length;
		int len = in.length;
		int index=0;
		int count=0;
		
	}
	public void get(String s,String param){
		char[] in = s.toCharArray();
		char[] temp = param.toCharArray();
		int len2 = temp.length;
		int len = in.length;
		int index=0;
		int count=0;
		for(int i=0;i<len;i++){
			if(in[i] == temp[count]){
				count++;
				if(count==len2){
					System.out.println("index:"+(i-count+1));
					count=0;
				}
			}else{
				count=0;
				index = i;
			}
		}
	}
}
