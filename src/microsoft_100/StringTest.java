package microsoft_100;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "我ab是d";
		System.out.println(getSub(string, 5));
		String string1 = "，,";
		System.out.println(string1.getBytes().length);
	}
	/**
	 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。 
	 * 但是要保证汉字不被截半个，如“我ABC”4，应该截为“我AB”，输入“我ABC汉DEF”，6，应该输出为“我ABC”而不是“我ABC+汉的半个”。
	 */
	public static String getSub(String str, int length){
		if(str==null)return null;
		if(length<=0)return null;
		int len = str.getBytes().length;
		if(len<length)throw new RuntimeException("given length is too big");
		String sub;
		if(str.length()<length){
			sub = str.substring(0,str.length());
		}else{
			sub = str.substring(0,length);
		}
		int index = length;
		while(sub.getBytes().length>length){
			sub = str.substring(0, --index);
		}
		return sub;
	}
}
