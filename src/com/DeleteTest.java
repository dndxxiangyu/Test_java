package com;

import java.io.File;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2016-1-12 上午11:24:11
 */
public class DeleteTest {
	
	public static void main(String[] args) {
		File file = new File("d:/delete");
		delete(file);
//		File[] fileList = file.listFiles();
//		int len = fileList.length;
//		long currentTime = System.currentTimeMillis();
//		for(int i=0; i<len; i++){
//			File temp = fileList[i];
//			fileList[i].delete();
////			fileList[i].
//		}
//		currentTime = System.currentTimeMillis()-currentTime;
//		System.out.println(currentTime/1000);
	}
	public static void delete(File file){
		if(file==null || !file.exists() || !file.isDirectory())return;
		File[] fileList = file.listFiles();
		int len = fileList.length;
		for(int i=0; i<len; i++){
			File temp = fileList[i];
			System.out.println(temp.exists());
			if(temp.isDirectory()){
				delete(temp);
				temp.delete();
			}else{
				temp.delete();
			}
		}
	}
	
}
