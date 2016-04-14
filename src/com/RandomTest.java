package com;

import java.io.File;
import java.io.RandomAccessFile;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-31 下午4:51:43
 */
public class RandomTest {
	public static void main(String[] args) throws Exception {
		File file = new File("d:/delete");
		if(!file.exists()){
			file.mkdirs();
		}
		for(int i=0; i<10; i++){
			RandomAccessFile raf = new RandomAccessFile("d:/delete/yunpan"+i+".txt", "rwd");  
			// 指定创建的这个文件的长度  
			raf.setLength(1000*1000*100);  
			// 关闭raf  
			raf.close();
		}
	}
}
