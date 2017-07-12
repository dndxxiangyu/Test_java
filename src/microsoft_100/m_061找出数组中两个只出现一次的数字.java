package microsoft_100;

public class m_061找出数组中两个只出现一次的数字 {

	/**
	 * 61.找出数组中两个只出现一次的数字
	 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。
	 * 
	 * 在每个子数组中，包含一个只出现一次的数字，而其他数字都出现两次
	 */
	public static void main(String[] args) {
		System.out.println(10>>2);
		int[] table={5,1,2,2,5,9,1,9,3,4};
		new m_061找出数组中两个只出现一次的数字().get(table);
	}
	public void get(int[] table){
		int len = table.length;
		int sum=0;
		for(int i=0;i<len;i++){
			sum ^= table[i];
		}
		System.out.println("sum:"+sum);
		//找到sum中第一个不是0的位置比如8为4（1000）
		int pos = 0;
		while((sum&1)!=1){
			sum = sum>>1;
			pos++;
		}
		System.out.println("pos:"+pos);
		//对table中每个数字进行第pos位的与操作
		int first=0,second =0;
		for(int i=0;i<len;i++){
			if(((table[i]>>pos)&1)!=1){
				first ^= table[i];
			}else{
				second ^= table[i];
			}
		}
		System.out.println("不同的两个数："+first+","+second);
	}
}
