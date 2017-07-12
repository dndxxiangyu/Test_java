package yeheya;

public class SearchClass {

	public static void main(String[] args) {
		
		
	}

	public static int binarySearch(int[] table, int start, int end, int target){
		if(start < 0 || end < 0 || table == null)return -1;
		int mid = 0;
		if(start <= end){
			mid = (start + end) / 2;
			if(table[mid] == target){
				return mid;
			}else if(table[mid] > target){
				end = mid - 1;
				binarySearch(table, start, end, target);
			}else if(table[mid] < target){
				start = mid + 1;
				binarySearch(table, start, end, target);
			}
		}
		
		return -1;
	}
	public static int binarySearch2(int[] table, int start,int end, int target){
		if(start < 0 || end < 0 || table == null)return -1;
		int mid = 0;
		while(start <= end){
			mid = (start + end)/2;
			if(table[mid] == target){
				return mid;
			}else if(table[mid] > target){
				end = mid - 1;
			}else if(table[mid] < target){
				start = mid + 1;
			}
		}
		return -1;
	}
}
//线性表的查找算法主要有顺序查找、折半查找、分块查找，分别适用于线性表、有序顺序表、索引顺序表
//分块查找：快内无序，快间有序。