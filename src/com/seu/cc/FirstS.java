package com.seu.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FirstS {

	public static void main(String[] args) {
		FirstS f = new FirstS();
		Scanner sc = new Scanner(System.in);
		String string=sc.next();
		String result = f.ff(string);
		System.out.println(result);
	}
	public String ff(String string){
		char[] chara = string.toCharArray();
		System.out.println("String:"+Arrays.toString(chara));
		ArrayList<Character> al = new ArrayList<Character>();
		al.add(chara[0]);
		int []count = new int[chara.length];
		count[0] = 1;
		for(int i=1;i<chara.length;i++){
			for(int k=0;k<al.size();k++){
				if(chara[i] == (char)al.get(k)){
					count[k]++;
					break;
				}
				if(k==al.size()-1){
					al.add(chara[i]);
				}
			}
		}
		for(int i=0;i<count.length;i++){
			if(count[i]==1){
				return String.valueOf(al.get(i));
			}else{
			}
		}
		return null;
	}

}
