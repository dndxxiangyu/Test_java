package com.seu.structure;

import java.util.ArrayList;

public class Search {

	public static void main(String[] args) {
		String[] string = { "abstract", "boolean", "break", "byte", "case",
				"catch", "char", "class", "continue", "default", "do",
				"double", "else", "extends", "false", "final", "finally",
				"float", "for", "if", "implements", "import", "instanceof",
				"int", "interface", "long", "native", "new", "null", "package",
				"private", "protected", "public", "return", "short", "static",
				"super", "switch", "synchronized", "this", "throw", "throws",
				"transient", "true", "try", "void" };
		int[] key1 = { 8, 17, 26, 32, 40, 72, 87, 99 };
		System.out.println(binarySearch2(key1, 40, 0, key1.length - 1));
	}

	public static int binarySearch(int[] table, int target, int low, int high) {
		int mid = 0;
		if (low <= high) {
			mid = (low + high) / 2;
			if (table[mid] == target) {
				return mid;
			} else if (table[mid] > target) {
				return binarySearch(table, target, low, mid - 1);
			} else if (table[mid] < target) {
				return binarySearch(table, target, mid + 1, high);
			}
		}
		return -1;
	}

	public static int binarySearch2(int[] table,int target,int low,int high){
		if(table!=null){
			while(low<=high){
				int mid=(low+high)/2;
				System.out.println(table[mid]+"?");
				if(table[mid]==target){
					return mid;
				}else{
					if(table[mid] < target)
						high=mid-1;
					else
						low=mid+1;
				}
			}
		}
		return -1;
	}
	
}
