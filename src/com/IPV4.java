package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {描述: 功能，使用对象，使用方法等}
 * 
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2016-3-4 下午2:33:51
 */
public class IPV4 {

	public static void main(String[] args) {
		System.out.println(is("10.22.38.24:11"));
	}

	public static boolean is(String ip){
		String string = "^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])(\\:\\d{1,5})?$";
		Pattern p = Pattern.compile(string);
		Matcher m = p.matcher(ip);
		return m.matches();
	}
}
