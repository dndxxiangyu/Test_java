package com.seu.cc;

public class Chinese {

	/**
	 * 汉字和字母都占两个byte但是string里面的，"想x".getBytes()长度为3；
	 */
	public static void main(String[] args) {
		String str = "我fd想大ffdfd放送ddd";
		System.out.println(getChinese(str));
	}
	//获取字符串中的汉字。
	public static String getChinese(String str){
		char[] ch = str.toCharArray();
		if(ch.length==0)return null;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<ch.length;i++){
			if((ch[i]+"").getBytes().length==2){
				sb.append(ch[i]);
			}
			
		}
		return sb.toString();
	}
	public static String cutString(String s,int count){
		System.out.println(s.getBytes().length);
		if(s!=null&&!"".equals(s)){
			if(count > 0 && count< s.getBytes().length){
				StringBuffer sb = new StringBuffer();
				char c;
				for(int i = 0; i < count; i++){
					c=s.charAt(i);
					if(isChinese(c)){
						count--;
					}
					if(i+1 > count)break;
					sb.append(c);
				}
				return sb.toString();
			}
		}
		return s;
		
		
	}
	public static boolean isChinese(char c){

		return String.valueOf(c).getBytes().length>1;
	}
}
