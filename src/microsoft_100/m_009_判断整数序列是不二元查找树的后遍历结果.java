package microsoft_100;

public class m_009_判断整数序列是不二元查找树的后遍历结果 {

	/**
	 * 9.判断整数序列是不二元查找树的后遍历结果
	 * {5,7,6,9,11,10,8}
	 */
	public static void main(String[] args){
		int[] table={7,4,6,5};
		System.out.println(new m_009_判断整数序列是不二元查找树的后遍历结果().isBST(table, 0, table.length-1));
		
	}
	public boolean isBST(int[] table, int start, int end){
		if(start==end)return true;
		int temp=table[end];
		int i=start;
		while(i<end&&table[i]<temp){
			i++;
		}
		System.out.println(temp);
		for(int j=i;j<end-1;j++){
			if(table[j]<temp)return false;
		}
		boolean left =true;
		boolean right = true;
		if(i>start)left=isBST(table,start,i-1);
		if(i<end)right=isBST(table,i,end-1);
		return left&&right;
	}
}
