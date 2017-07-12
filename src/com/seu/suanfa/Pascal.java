package com.seu.suanfa;

import java.util.Arrays;
/**
 *  要了解nCr 和nCr-1的关系
 * @author hp
 *
 */
public class Pascal {

	
	public static void main(String[] args) {
		
	       
		new Pascal().getPascal( 5);
	}

	public void getPascal(int n){
		if(n==1)System.out.println("["+1+"]");
		int[] a = new int[n];
		a[0]=1;
		if(n>=2)
		{
			for(int i=1;i<n;i++){
				a[i]=a[i-1]*(n-i)/i;
			}
			for(int i=0;i<n;i++){
				
			}
			getPascal(n-1);
			System.out.println(Arrays.toString(a));
		}
	}
}
