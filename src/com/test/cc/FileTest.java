package com.test.cc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-10 下午8:53:12
 */
public class FileTest {
	public static void main(String[] args) throws IOException {
		File file = new File("d://cc.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(new String("cc").getBytes());
			fos.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Date date = new Date(file.lastModified());
		System.out.println(date);
		String path = "d:/cc";
		file = new File(path);
		if(!file.exists())file.mkdirs();
		file = new File(file, "wxy.txt");
		file.createNewFile();
		new FileOutputStream(file).write(new String("cc").getBytes());
		System.out.println("---------------------------------------------0");
		file = new File("d://text//wxy//test.txt");
		file.mkdirs();
		file.createNewFile();//不能一起
	}
}
