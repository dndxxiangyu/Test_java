package microsoft_100;

public class m_033 {

	/**
	 * 33.实现一个挺高级的字符匹配算法：
	 * 给一串很长字符串，要求找到符合要求的字符串，例如目的串：123
	 * 1******3***2 ,12*****3这些都要找出来
	 * 其实就是类似一些和谐系统。。。。。
	 */
	public static void main(String[] args) {
		System.out.println((int)'a');
		System.out.println((int)'A');
		System.out.println((int)'1');
		System.out.println(new m_033().isContain("wuxiangyu","wuxy"));
	}
	public boolean isContain(String s,String contain){
		int[] hashTable = new int[26];
		char[] in = s.toCharArray();
		int len = s.length();
		for(int i=0;i<len;i++){
			hashTable[in[i]-'a'] = 1;//表示含有这个字符
		}
		char[] out = contain.toCharArray();
		int len2 = out.length;
		for(int i=0;i<len2;i++){
			if(hashTable[out[i]-'a']==0){
				return false;
			}
		}
		return true;
	}
}
