package com.seu.cc;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int i = 0;i<5;i++){
			for(int j=0;j<5;j++){
				for(int k=0;k<5;k++){
					ar.add((int)(Math.pow(2,k)*Math.pow(3,j)*Math.pow(5,i)));
				}
			}
		}
		
		Math.pow(2, 3);
		System.out.println(ar.toString());
		
		Collections.sort(ar);
		System.out.println(ar.toString());

	}

}
