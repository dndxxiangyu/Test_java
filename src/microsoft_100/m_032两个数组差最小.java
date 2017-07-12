package microsoft_100;

import java.util.Arrays;

public class m_032两个数组差最小 {
	/**
	 * 32.
	 * 有两个序列a,b，大小都为n,序列元素的值任意整数，无序；
	 * 要求：通过交换a,b中的元素，使[序列a元素的和]与[序列b元素的和]之间的差最小。
	 * 例如: 
	 * var a=[100,99,98,1,2, 3];
	 * var b=[1, 2, 3, 4,5,40];
	 */
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = {1,3,4,5,6};
		new m_032两个数组差最小().swap(a, b);
	}
	/**
	 * 算法
	 * 将两序列合并为一个序列，并排序，为序列Source 
	 * 拿出最大元素Big，次大的元素Small 
	 * 在余下的序列S[:-2]进行平分，得到序列max，min 
	 * 将Small加到max序列，将Big加大min序列，重新计算新序列和，和大的为max，小的为min
	 * 
	 * A = sum(a) - sum(b)
   	a的第i个元素和b的第j个元素交换后，a和b的和之差为
   A' = sum(a) - a[i] + b[j] - （sum(b)- b[j] + a[i])
          = sum(a) - sum(b) - 2 (a[i] - b[j])
          = A - 2 (a[i] - b[j])
	使他值最小
	 */
	public void swap(int[] a, int[] b){
		int len = a.length;
		int suma =0,sumb=0;
		for(int i=0;i<len;i++){
			suma += a[i];
			sumb += b[i];
		}
		int diff = suma - sumb;
		while(diff!=0){
			System.out.println("a");
			int besti=0,bestj=0;
			int bestchange=0;
			//一次下来，交换两个差值最合适的两个数
			for(int i=0;i<len;i++){
				for(int j=0;j<len;j++){
					int change = (a[i]-b[j]);
					if(Math.abs(diff-2*change)<Math.abs(diff-2*bestchange)){
						bestchange = change;
						besti = i;
						bestj = j;
					}
				}
			}
			if(bestchange==0){//差不能再缩小，不能交换使之更加小的了
				System.out.println(Arrays.toString(a)+Arrays.toString(b));
				return;
			}//if
			int temp = a[besti];
			a[besti] = b[bestj];
			b[bestj] = temp;
			suma -= bestchange;
			sumb += bestchange;
			diff = suma-sumb;
		}//while
		System.out.println(Arrays.toString(a)+Arrays.toString(b));
	}
}
