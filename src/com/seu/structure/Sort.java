package com.seu.structure;

import java.util.*;

public class Sort {

	public static void main(String[] args) {
		int[] key = {34,2,45,82,11,9,26,78,35,24,1};
		int[] key1 = {49,38,65,97,76,13,27,49,55,04,3,3,3,3,3,33,3,33,4,55,3,33,4,55};
		int[] key2 = {49,38,65,97,76,13,27,49};
		int[] key3 = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
//		quickSort(key1 , 0 , key1.length - 1);
		mergeSort(key1);
		System.out.println(Arrays.toString(key1));
		ArrayList<String> cc;
	}
	//插入排序
	public static void insertSort(int[] table){
		int i,j,temp;
		for(i = 1 ; i < table.length ; i++){
			temp = table[i];
			for(j = i - 1 ; j >= 0 && temp < table[j] ; i++){
				table[j+1] = table[j];
			}
			table[j+1] = temp;
		}
		System.out.println(Arrays.toString(table));
	}
	
	//插入排序带步长
	public static void insertSort(int[] table, int length){
		int i,j,temp;
		for(i = length ; i < table.length ; i++){
			temp = table[i];
			for(j = i - length ; j >= 0 && temp < table[j] ; j -= length){
				table[j+length] = table[j];
			}
			table[j+length] = temp;
		}
	}
	//折半插入排序
	public static void insertSort2(int[] table){
		for(int i = 1 ; i < table.length ; i++){
			if(table[i] > table[i-1]){
				int temp = table[i];
				int low = 0;
				int high = i - 1;
				while(low <= high){
					int mid = (low + high) / 2;
					if(table[mid] <= temp){
						low = mid + 1;
					}else{
						high = mid -1;
					}
				}
				for(int j = i ; j > low ; j--){
					table[j] = table[j-1];
				}
				table[low] = temp;
			}
			
		}
		System.out.println(Arrays.toString(table));
	}
	
	//希尔排序
	public static void shellSort(int[] table){
		for(int delta = table.length / 2 ; delta > 0 ; delta /= 2){
			//分成delta组
			int i;
			int j;
			for (i = delta; i < table.length; i++) {
				int temp = table[i];
				for(j = i - delta;j >= 0 && table[j] > temp; j -= delta){
					table[j + delta] = table[j];
				}
				table[j + delta] = temp;
			}
		}
		System.out.println(Arrays.toString(table));
	}
	
	//冒泡排序 
	public static void bubbleSort(int[] table){
		int i,j,temp;
		boolean exchange = true;
		for(i = 0 ; i < table.length-1 && exchange ; i++){
			exchange = false;
			for(j = 0 ; j < table.length - i-1 ; j++){
				if(table[j] > table[j+1]){
					temp = table[j+1];
					table[j+1] = table[j];
					table[j] = temp;
					exchange = true;
				}
			}
		}
		System.out.println(Arrays.toString(table));
	}
	
	//快速排序
	public static void quickSort(int[] table , int low , int high){
		if(low < high){
			int i = low;
			int j = high;
			int temp = table[low];
			while(i != j){
				while(i < j && temp <= table[j]){
					j--;
				}
//				if(i < j){
					table[i] = table[j];
//					i++;
//				}
				while(i < j && temp > table[i]){
					i++;
				}
//				if(i < j){
					table[j] = table[i];
//					j--;
//				}
			}//table[i] = table[j];
			table[i] = temp;
			quickSort(table , low , i - 1);
			quickSort(table , i + 1 , high);
		}
	}
	

	//直接选择排序
	public static void selectSort(int[] table){
		int min;
		for(int i = 0; i < table.length -1; i++){
			min = i;
			for(int j = i + 1 ; j < table.length ; j++){
				if(table[j] < table[min]){
					min = j;
				}
			}
			if(min != i){
				int temp = table[min];
				table[min] = table[i];
				table[i] = temp;
			}
		}
		System.out.println(Arrays.toString(table));
	}
	
	//堆排序，大顶堆
	public static void heapSort(int[] table){
		int n = table.length;
		for(int j = n/2-1; j >= 0; j--){
			//对前面j个都是有孩子的节点。
			//从下往上、从右到左，将每个非终端节点当做根节点，将其和其子树调整成大顶堆
			sift_max(table , j , n-1);
		}
		for(int j = n - 1; j > 0; j--){
			int temp = table[0];
			table[0] = table[j];
			table[j] = temp;
			sift_max(table , 0 , j - 1);
		}
	}
	private static void sift_max(int[] table, int low, int high){
		int i = low;
		int j = 2*i + 1;
		int temp = table[i];
		while(j <= high){
			if(j < high && table[j] < table[j+1]){
				j++;
			}
			if(temp < table[j]){
				table[i] = table[j];
				i = j;
				j = 2*i+1;
			}else{
				break;
			}
		}
		table[i] = temp;
	}
	//归并排序
//	public static void mergeSort(int[] table){
//		System.out.println(Arrays.toString(table));
//		int[] Y = new int[table.length];                       //Y数组长度同X数组
//        int n=1;                                           //已排序的子序列长度，初值为1
//        while (n < table.length)
//        {
//            mergepass(table, Y, n);                            //一趟归并，将X数组中各子序列归并到Y中
//            n*=2;                                          //子序列长度加倍
//            System.out.println("a>>>>>>>"+Arrays.toString(Y));
//            if(n<table.length){
//            	mergepass(Y, table, n);                            //一趟归并，将X数组中各子序列归并到Y中
//                n*=2;  
//                System.out.println("b>>>>>>>"+Arrays.toString(table));
//            }
//        }
//	}
	public static void mergeSort(int[] table){
		System.out.println(Arrays.toString(table));
		int[] Y = new int[table.length];                       //Y数组长度同X数组
        int n=1;                                           //已排序的子序列长度，初值为1
        while (n < table.length)
        {
            mergepass(table, Y, n);                            //一趟归并，将X数组中各子序列归并到Y中
            n*=2;      
            for(int i=0;i<table.length;i++){
            	table[i]=Y[i];
            }
//            table=Y;//you know why this is not true;
        }
        System.out.println("aaaaaaaaaaaaa"+Arrays.toString(table));
        
	}
	private static void mergepass(int[] x, int[] y, int n){
		int i = 0;
		for(i=0; i <= x.length-2*n; i += 2*n){
			merge(x, y, i, i+n, n);
		}
		if(i+n < x.length){
			merge(x, y, i, i+n, n);
		}else{
			for(int j=i; j<x.length; j++){
				y[j] = x[j];
			}
		}
	}
	private static void merge(int[] x,int[] y, int m, int r, int n){//一次归并
		int i=m;
		int j=r;
		int k=m;//y数组的下标，表示把内容放到y数组中去
		while(i<r && j<r+n && j<x.length){
			if(x[i] < x[j]){
				y[k] = x[i];
				k++;
				i++;
			}else{
				y[k] = x[j];
				k++;
				j++;
			}
		}
		while(i<r)
			y[k++] = x[i++];
		while(j<r+n && j<x.length)
			y[k++] = x[j++];
	}
	
	//桶排序
	public static void bucketSort(int[] table){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<table.length; i++){
			if(table[i] > max)max = table[i];
			if(table[i] < min)min = table[i];
		}
		int[] temp = new int[max-min+1];
		for(int i=0; i<table.length; i++){
			temp[table[i]-min]++;
		}
		int cursor = table.length-1;
		for(int i=temp.length-1; i>=0;i--){
			int t = temp[i];
			while(t>0){
				table[cursor] = i+min;
				t--;
				cursor--;
			}
		}
	}
	//基数排序,数据，桶的长度，数据的长度
	public static void radixSort(int[] table, int bucket_len, int len){
		int[] temp = new int[table.length];
		int[] bucket = new int[bucket_len];
		for(int i=0; i<len; i++){
			
		}
	}
}
