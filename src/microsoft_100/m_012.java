package microsoft_100;

public class m_012 {
		/**
		 * find x=1+2+3+....n
		 */
	public static void main(String[] args) {
		int n=10;
		int re=get(n);
		System.out.print(re);
		boolean a = false;
		System.out.println(a);
		int[] tabl={};
		System.out.println(tabl.length);
	}
	static int find(int n){
		int re=0;
		boolean whatever=false;
		int a=-1;
		whatever=(n!=0)&&(a==(re=find(n-1)));
		return re+n;
	}
	public static int get(int n){
		int num = 0;
		boolean whatever = false;
		int a=-1;
		whatever=(n!=0)&&(a==(num=n+get(n-1)));
		return num;
	}
}
