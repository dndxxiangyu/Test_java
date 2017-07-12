package com.seu.cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Test5 {

	public static void main(String[] args) {
		String s1= Test5.sendPost("http://xueyang365.vicp.cc/android.php", "user=seu&password=seu");
		System.out.println(s1);
	}
	public static String sendPost(String url,String param){
		
		PrintWriter out = null;
		BufferedReader in = null;
		String result="";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accpt", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0(compatiable;MSIE 6.0;Windows NT 5.1;SV1");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.println(param);
			out.flush();
			in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line=in.readLine())!=null){
				result+="\n"+line;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				if(out!=null)out.close();
				if(in!=null)in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}

}
