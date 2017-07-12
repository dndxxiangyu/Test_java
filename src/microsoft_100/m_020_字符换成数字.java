package microsoft_100;

public class m_020_字符换成数字 {

	/**
	 * 第20题：
	 * 题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。
	 * 例如输入字符串"345"，则输出整数345。
	 */
	public static void main(String[] args) {
		System.out.println(new m_020_字符换成数字().getInteger("+123"));
		
	}
	public Integer getInteger(String a){
		if(a==null)return null;
		char[] in = a.toCharArray();
		boolean negetive = false;
		int num=0;
		if(in[0]=='-'){
			negetive = true;
		}else if(in[0]=='+'){
			
		}else if(in[0]>='0'&&in[0]<='9'){
			num = in[0]-'0';
		}else{
			return null;
		}
		for(int j=1;j<in.length;j++){
			if(in[j]>='0'&&in[j]<='9'){
				num = num*10+in[j]-'0';
			}else{
				return null;
			}
		}
		if(negetive == true){
			return -num;
		}
		return num;
	}
}
