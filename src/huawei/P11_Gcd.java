package huawei;


/**
 * 更相减损术，求两个整数的最大约数
 * gcd(a,b) = gcd(b,a) = gcd(b,b%a),把小的数放在后面
 */
public class P11_Gcd {

	public static void main(String[] args) {
		int a=12,b=18;
		System.out.println(gcd(a,b));
	}

	public static int gcd(int a, int b){
		if(a == 0 || b == 0)return 0;
		while(b != 0){
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
}
