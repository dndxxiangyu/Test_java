package com.seu.structure;

import java.util.Arrays;

public class StringClass {

	
	public static void main(String[] args) {
		
		int[] a = getNext("ababaaaba");
		System.out.println(Arrays.toString(a));
		String ss ="abc";
		String s = new String("abc");
		String sss ="abc";
		System.out.println(s==ss);
		System.out.println(ss);
	}
	public int BF(String target,String pattern,int start){
		if(target!=null&&pattern!=null&&pattern.length()>0&&target.length()>=pattern.length()){
			char[] tar=target.toCharArray();
			char[] pat=pattern.toCharArray();
			int[] next=getNext(pattern);

			int i=0,j=0;
			while(i<target.length()){
				if(j==-1||tar[i]==pat[j])
				{
					i++;j++;
				}else{
					j=next[j];
				}
				if(j==pattern.length())return i-j;
			}
		}
		return -1;
	}
	
	public static int[] getNext(String pattern){
		int[] next=new int[pattern.length()];
		char[] cc=pattern.toCharArray();
		
		int k=-1;
		int j=0;
		next[j]=-1;
		for(j=1;j<pattern.length();j++){
			k=next[j-1];
			while(k>=0&&cc[j-1]!=cc[k]){
				k=next[k];
			}
//			if(cc[j]!=cc[k+1]){
//				next[j]=k+1;
//			}else{
//				next[j]=-1;
//			}
			next[j]=k+1;
		}
		
		return next;
	}
}

