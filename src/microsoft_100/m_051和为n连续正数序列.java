package microsoft_100;

public class m_051和为n连续正数序列 {

	/**
	 * 51.和为n连续正数序列。
		题目：输入一个正数n，输出所有和为n连续正数序列。
		例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列1-5、4-6和7-8。
	 */
	public static void main(String[] args) {
		
		new m_051和为n连续正数序列().out(1000);
		new m_051和为n连续正数序列().in(15);
	}
	public void out(int n){
		int end = n;
		int start = n;
		int sum=n;
		//从后往前
		while(start>=1){
			if(sum<n){
				start--;
				sum += start;
			}else if(sum>n){
				sum -= end;
				end--;
			}else if(sum==n){
				System.out.println(start+"-"+end);
				sum -= end;
				end--;
			}
		}
	}
	public void in(int n){
		int start=1;
		int end =2;
		int sum =3;
		while(start<(1+n)/2){
			if(sum<n){
				end++;
				sum += end;
			}else if(sum>n){
				sum -= start;
				start++;
			}else{
				System.out.println(start+"-"+end);
				sum -= start;
				start++;
			}
		}
	}
}
