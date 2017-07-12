package com;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String table = "www.taobao.com";
		int len = table.length();
		reverse(table,0,len-1);

	}
	public static void reverse(String table, int start, int end){
		if(start < end){
			for(int i=start; i<end; i++){
				if(table.charAt(i) == '.'){
					reverse(table,i+1,end);
					System.out.println(table.substring(start, i));
					return;
				}
			}
		}
	}
}
