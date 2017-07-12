package microsoft_100;

import yeheya.SearchClass;
import yeheya.SortClass;

public class m_048数组移位 {

	/**
	 * 48.微软：
	 * 一个数组是由一个递减数列左移若干位形成的，比如{4,3,2,1,6,5}
	 * 是由{6,5,4,3,2,1}左移两位形成的，在这种数组中查找某一个数。
	 */
	public static void main(String[] args) {
		int[] table ={3,2,1,6,5,4};
		int[] table1={2,1,6,5,4,3};
		int[] table2={6,5,4,3,2,1};
		System.out.println(binarySearch(table2,0,5));
	}
	//找到分界点的下标
	public static int binarySearch(int[] table, int start, int end){
		if(start < 0 || end < 0 || table == null)return -1;
		int temp = table[0];
		int left = start;
		int right = end;
		if(temp>table[right])return 0;
		while(left<right){
			int mid = (left+right)/2;
			if(table[mid]>temp){
				right=mid;
			}else if(table[mid]<temp){
				left=mid+1;
			}
		}
		return left;
	}
	public static int binarySearch2(int[] table, int start, int end, int target){
		int index = binarySearch(table,start,end);
		
		return SearchClass.binarySearch(table, start, end, target);
	}
}
