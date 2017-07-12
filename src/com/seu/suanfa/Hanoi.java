package com.seu.suanfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hanoi {

	
	public static void main(String[] args) throws IOException {
		int i=0;//表示有多少层
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		i=Integer.parseInt(br.readLine());
		Hanoi h = new Hanoi();
		
		h.hanoi(i,'A','B','C');
//		Scanner s = new Scanner(System.in);
//		i=s.nextInt();
//		new Hanoi().hanoi(i, 'A', 'B', 'C');
	}
	
	public void hanoi(int n , char a , char b , char c){
		if(n==1){
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
			return;
		}else{
			hanoi(n-1,a,c,b);
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
			hanoi(n-1,b,a,c);
		}
	}
}
