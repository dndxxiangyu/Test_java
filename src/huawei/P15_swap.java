package huawei;
/**
 * 通过一个数组，来改变两个边量的值。
 *
 */
public class P15_swap {

	public static void main(String[] args) {
		int a = 10, b = 11;
		int[] c = {a,b};
		swap(c);
		System.out.println(a);
		System.out.println(b);
		System.out.println(2^4);
	}
	public static int[] swap(int []a){
		if(a.length == 2){
			int temp = a[0];
			a[0] = a[1];
			a[1] = temp; 
		}	
		return a;
	}
}
