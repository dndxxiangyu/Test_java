package microsoft_100;

import java.util.Arrays;

public class m_064寻找丑数 {

	/**
	 * 64. 寻找丑数。
	题目：我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。例如6、8 都是丑数，
	 */
	public static void main(String[] args) {
		System.out.println(new m_064寻找丑数().isUgly(1));
		System.out.println();
		long time1 = System.currentTimeMillis();
		new m_064寻找丑数().get(200);
		long time2 = System.currentTimeMillis();
		new m_064寻找丑数().get2(200);
		long time3 = System.currentTimeMillis();
		System.out.println((time2-time1)+":"+(time3-time2));
	}
	public boolean isUgly(int n){
		if(n<=0)return false;
		while(n%2==0)n /= 2;
		while(n%3==0)n /= 3;
		while(n%5==0)n /= 5;
		if(n==1)return true;
		return false;
	}
	//求第n个丑数,这个方法对不是丑数也进行统计，冗余比较多
	public void get(int n){
		int start=0;
		int count=0;
		while(count<n){
			start++;
			if(isUgly(start)){
				count++;
				System.out.print(start+" ");
			}
		}
		System.out.println("number:"+start);
	}
	public void get3(int n){
		int[] temp = new int[n];
		int i2=0,i3=0,i5=0;
		int i=0;
		while(i<0){
			int x = min(temp[i2]*2, temp[i3]*3, temp[i5]*5);
			if(x==temp[i2]*2){
				i2++;
			}
		}
	}
	/**
	 * 因此我们可以创建一个数组，里面的数字是排好序的丑数。里面的每一个丑数是前面的丑数乘以2、3或者5得到的。
	 * 这个思路的关键点，就是要保证数组里面的丑数是排好序的。假设 arr[1..i]是已经排好序的数组，则arr[i]
	 * 一定是这里面最大的数，那么我们只要去寻找新生成的数字中比arr[i]大的的最小的数。新生成的数是由前面的
	 * 数字*2或*3或*5得到的。我们定义index2为前面数字*2中的所有数字中满足大于arr[i]的最小的数的下标，
	 * index3,index5类似定义，则应该放在arr[i+1]位置的数字便是 min(arr[index2]*2,arr[index3]*3,arr[index5]*5)。
	 */
	public void get2(int n){
		int[] arr = new int[n];
		arr[0]=1;
		int index=1;
		int index2=0;
		int index3=0;
		int index5=0;
		while(index<n){
			int value = min(arr[index2]*2,arr[index3]*3,arr[index5]*5);
			if(value==arr[index2]*2){
				index2++;
			}
			if(value==arr[index3]*3){
				index3++;
			}
			if(value==arr[index5]*5){
				index5++;
			}
			arr[index] = value;
			index++;
		}
		System.out.println(Arrays.toString(arr));
	}

	public int min(int a,int b, int c){
		if(a>b){
			return b>c?c:b;
		}else{
			return a>c?c:a;
		}
	}
}
