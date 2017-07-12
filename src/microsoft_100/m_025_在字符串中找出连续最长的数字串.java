package microsoft_100;

public class m_025_在字符串中找出连续最长的数字串 {

	/**
	 * 第25题：
	 * 写一个函数,它的原形是int continumax(char *outputstr,char *intputstr)
	 * 功能：
	 * 在字符串中找出连续最长的数字串，并把这个串的长度返回，
	 * 并把这个最长数字串付给其中一个函数参数outputstr所指内存。
	 * 例如："abcd12345ed125ss123456789"的首地址传给intputstr后，函数将返回9，
	 * outputstr所指的值为123456789
	 */
	public static void main(String[] args) {
		String string = "abcd12345ed125ss123456789";
		System.out.println("string length:"+string.length());
		System.out.println("string length:"+string.substring(0, 1));
		new m_025_在字符串中找出连续最长的数字串().put(string.toCharArray());
		System.out.println(new m_025_在字符串中找出连续最长的数字串().getLength(string.toCharArray()));
		
	}
	public int getLength(char[] in){
		int len = in.length;
		int max=0;
		int count=0;
		for(int i=0;i<len;i++){
			if(in[i]>='0'&&in[i]<='9'){
				count++;
				if(count>max)max=count;
			}else{
				count=0;
			}
		}
		return max;
	}
	
	
	
	
	
	
	
	
	
	public int put(char[] in){
		int len = in.length;
		int index=-1;//最长数字下标开始
		int max = -1;//最长数字
		int count = 0;
		for(int i=0;i<len;i++){
			if(in[i]>='0'&&in[i]<='9'){
				count++;
				if(count>max){
					max = count;
					index = i-max+1;//更新最长数字字符开始的下标
				}
			}else{
				//说明不是数字
				count=0;
			}
		}
		for(int i=index; i<max+index; i++){
			System.out.print(in[i]+"");
		}
		return index;
	}
}
