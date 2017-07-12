package com.seu.cc;

import java.io.File;
import java.util.Arrays;

public class Wio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:\\KwDownloadx\\song");
		String[] filenames = file.list();
		System.out.println(Arrays.toString(filenames));
	}

}
