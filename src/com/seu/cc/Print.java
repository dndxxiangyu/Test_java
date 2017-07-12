package com.seu.cc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Print {

	public static void main(String[] args) {
		PrintWriter pw =null;
		try {
			pw= new PrintWriter("d:\\cc.txt");
			pw.println("xxdecc1");
			pw.write("xxdecc");
//			pw.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}

}
