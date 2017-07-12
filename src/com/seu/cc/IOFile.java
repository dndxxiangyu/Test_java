package com.seu.cc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IOFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("D:\\aa.txt");
		if(!f.exists()){
			f.createNewFile();
		}
		InputStream fis = new FileInputStream(f);
		int len=0;
		byte[] b = new byte[1024];
		while((len=fis.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		System.out.println("*********************************");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String c="cc";
		while((c=br.readLine())!= null){
			System.out.println(c);
		}
		System.out.println("over");
		br.close();
			FileOutputStream fos = new FileOutputStream("temp.out");  
	        ObjectOutputStream oos = new ObjectOutputStream(fos);  
	        TestSerial ts = new TestSerial(); 
	        oos.writeObject(ts); 
	        oos.flush();
	        oos.close();
	}
}
class TestSerial implements Serializable{  
	 
    public byte version = 100;  

    public byte count = 0;  

} 