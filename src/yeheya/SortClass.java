package yeheya;

import java.util.Arrays;

public class SortClass {

	public static void main(String[] args) {
		int[] key1 = {34,2,45,82,11,9,26,78,35,24,1,22,22};
		int[] key2 = {49,38,65,97,76,13,27,49,55,04};
		int[] key3 = {49,38,65,97,76,13,27,49};
		int[] key4 = {1,2,3,4,5,6,7};
		int[] key5 = {7,6,5,4,3,2,1};
		mergeSort(key2);
		System.out.println(Arrays.toString(key2));
		quickSort(key2, 0, key2.length-1);
		System.out.println(Arrays.toString(key2));
		int a=0xa0000001;
		int b=0xa0000002;
		System.out.println(a);
		System.out.println(b);
		a = a+b;
		int c =-1610612738;
		System.out.println(a);
		b = a-b;
		a = a-b;
		System.out.println(a);
		System.out.println(b);
		int[] table=new int[-1];
		insertSort(table);
	}
	//插入排序-->稳定
	public static void insertSort(int[] table){
		int temp, i, j;
		for(i = 1; i < table.length; i++){
			temp = table[i];
			for(j = i-1; j>=0 && table[j]>temp; j--){
				table[j+1] = table[j];
			}
			table[j+1] = temp;
		}
	}
	//折半插入排序
	public static void binaryInsertSort(int[] table){
		int i,j,temp;
		for(i = 1; i < table.length;i++){
			temp = table[i];
			int start = 0;
			int end = i - 1;
			int mid =0;
			while(start <= end){
				mid = (start+end)/2;
				if(table[mid] > temp){
					end = mid-1;
				}
				if(table[mid] < temp){
					start = mid +1;
				}
				if(table[mid] == temp){
					start = mid+1;//相等了，找到要插入的位置
					return;
				}
			}
			for(j = i; j > start; j--){
				table[j] = table[j -1];
			}
			table[start] = temp;
		}
	}
	
	//希尔排序 -->不稳定,基本思想也是直接插入排序,
	//描述：将一个数据分成若干组，每组由若干相隔一段距离的元素组成，在一个组内采用直接插入排序算法进行排序。
	public static void shellSort(int[] table){
		for(int delta = table.length/2; delta > 0; delta /= 2){
			int temp,i,j;
			for(i = delta; i < table.length; i++){
				temp = table[i];
				for(j = i-delta; j>=0 && temp < table[j]; j -= delta){
					table[j + delta] = table[j];
				}
				table[j + delta] = temp;
			}
		}
	}
	//冒泡排序-->稳定
	public static void bubbleSort(int[] table){
		boolean exchange = true;
		for(int i = 1; i < table.length && exchange; i++){
			exchange = false;
			for(int j = 0; j < table.length-i; j++){
				if(table[j] > table[j+1]){
					int temp = table[j];
					table[j] = table[j+1];
					table[j+1] = temp;
					exchange = true;
				}
			}
		}
	}
	
	//快速排序-->不稳定
	//思想：在数据序列中选择一个值作为比较的基准值，每趟从数据序列的两端开始交替进行，蒋小的基准值的元素交换到序列前端，
	//将大于基准值的元素交换到序列后端，介于两者之间的位置则成为基准值的最终位置
	public static void quickSort(int[] table, int low, int high){
		if(low < high){
			int i = low;
			int j = high;
			int temp = table[low];
			while(i != j){
				//第一步的时候相当于第i个是空的
				while(i < j && temp <= table[j]){
					j--;
				}
//				if(i < j){
					table[i] = table[j];
//					i++;
//				}
				//第二步的时候相当于第j个是空的
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
	//直接选择排序-->不稳定
	//基本思想：第一遍从n个元素中选最小的放到最前，下一趟再从n-1个元素在从n-1个元素中选出最小的放到次前位置。需要n-1次排序
	public static void selectSort(int[] table){
		if(table==null || table.length==0)return;
		int min;
		for(int i=0; i<table.length-1; i++){
			min = i;
			for(int j=i+1; j<table.length;i++){
				if(table[j] > table[min]){
					min = j;
				}
			}
			if(min != i){
				int temp = table[min];
				table[min] = table[i];
				table[i] = temp;
			}
		}
	}
	//堆排序-->不稳定,利用完全二叉树的应用，充分利用二叉树的性质
	//堆，是完全二叉树，每个节点的值都大于或等于其左右孩子节点的值叫大顶堆；每个节点的值都小于或等于其左右孩子子节点的值，称为小顶堆
	//基本思想：把大顶堆的root和完全二叉树的最后节点交换，继续构造除了最后一个节点的大顶堆，然后再把root和次节点交换。
	//两个阶段：a:先将数据列建成堆，b:选择排序思路，每趟将根节点交换到后面，再将其与调整
	public static void heapSort(int[] table){
		if(table == null)return;
		int n = table.length;
		for(int j=n/2-1;j>=0;j--){
			//对有子孩子的节点都都进行大顶堆排序，有n/2个
			sift_max(table, j, n-1);
		}
		for(int j=n-1; j>0; j--){
			int temp = table[0];
			table[0] = table[j];
			table[j] = temp;
			sift_max(table, 0, j-1);
		}
	}
	private static void sift_max(int[] table, int begin, int end){
		int i = begin;
		int j = 2*i + 1;//low的左孩子
		int temp = table[i];
		while(j <= end){
			if(j < end && table[j] < table[j+1]){
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
	//归并排序-->稳定
	public static void mergeSort(int[] table){
		sort(table, 0, table.length-1);
	}
	private static void sort(int[] table, int left, int right){
		if(left >= right)return;
		int mid = (left+right)/2;
		sort(table, left, mid);
		sort(table, mid+1,right);
		merge(table, left, mid, right);
	}
	private static void merge(int[] table, int left, int mid, int right){
		int[] temp = new int[table.length];
		int leftb = mid+1;//右分支数组的起始下标
		int tmp = left;//缓存左边的起始下标，等待可以写会原数组
		int cursor = left;//记录temp数组存入的个数
		while(left<=mid && leftb<=right){
			if(table[left]<=table[leftb]){
				temp[cursor++] = table[left++];
			}else{
				temp[cursor++] = table[leftb++];
			}
		}
		//copy the rest
		while(left<=mid){
			temp[cursor++] = table[left++];
		}
		while(leftb<=right){
			temp[cursor++] = table[leftb++];
		}
		//copy temp to table
		while(tmp <= right){
			table[tmp] = temp[tmp++];
		}
	}
	//桶排序
	public static void bucketSort(int[] table){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		//找出最大和最小值
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
}
