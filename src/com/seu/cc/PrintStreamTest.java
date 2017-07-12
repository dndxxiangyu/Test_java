package com.seu.cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			System.out.println("1");
			InputStreamReader reader = new InputStreamReader(System.in);
			br = new BufferedReader(reader);
			String buffer = null;
			while((buffer=br.readLine())!=null){
				System.out.println("输入的是");
				System.out.println(buffer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
