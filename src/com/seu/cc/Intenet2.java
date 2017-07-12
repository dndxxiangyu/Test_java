package com.seu.cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Intenet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("this is socket test!");
		URL infoUrl = null;
		URLConnection connection=null;
		HttpURLConnection httpConnection=null;
		InputStream inStream=null;
		try {
			infoUrl = new URL("http://www.baidu.com");//一个网址
			connection = infoUrl.openConnection();
			httpConnection = (HttpURLConnection)connection;  
		    inStream = httpConnection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    try {
			while((line = reader.readLine())!=null){
				sb.append(line + "\n"); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		System.out.println(sb);
	}
    
	
}

