package microsoft_100;

import java.util.Arrays;

public class m_006_腾讯123456789 {

	/**
	 * 第 6题（数组）
	 * 腾讯面试题：
     * 给你 10 分钟时间，根据上排给出十个数
     * 在其下填对应的要求下排每个数都是先前上那十在出现的次。
     * 数值 : 0,1,2,3,4,5,6,7,8,9 
	 * 分配 : 6,2,1,0,0,0,1,0,0,0 
       0在下排出现了 6次， 1在下排出现了 2次，
       2在下排出现了 1次， 3在下排出现了 0次....
	 */
	public static void main(String[] args) {
		int[] up = {0,1,2,3,4,5,6,7,8,9};
		int[] down={0,0,0,0,0,0,0,0,0,0};
		new m_006_腾讯123456789().show(10);
	}
	
	public void show(int n){
		//初始化
		int[] up = new int[n];
		int[] down = new int[n];
		for(int i=0;i<n;i++){
			up[i] = i;
		}
		System.out.println(Arrays.toString(up));
		boolean success = false;
		while(!success){
			success = true;
			for(int i=0;i<n;i++){
				int count = 0;
				for(int j=0;j<n;j++){
					if(down[j]==i){
						count++;
					}
				}
				if(count!=down[i]){
					down[i] = count;
					success = false;
				}
			}
		}
		System.out.println(Arrays.toString(down));
	}
	
}
