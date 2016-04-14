package com.test.cc;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
  
public class NioTest {  
  
    public static void main(String[] args) throws IOException, InterruptedException {  
        IntBuffer ib = IntBuffer.allocate(8);
        for(int i=0; i<ib.capacity();i++){
        	ib.put(i*2+1);
        }
        ib.flip();
        System.out.println(ib);
        
        
        
        
        
        FileInputStream fin = new FileInputStream("C:\\Users\\wuxiangyu\\Desktop\\word1.txt");  
        
        // 获取通道  
        FileChannel fc = fin.getChannel();  
          
        // 创建缓冲区  
        ByteBuffer buffer = ByteBuffer.allocate(8);  
          
        // 读取数据到缓冲区  
        fc.read(buffer);  
          
        buffer.flip();  
          
        while (buffer.remaining()>0) {  
            byte b = buffer.get();  
            System.out.print(((char)b));  
        }  
          
        fin.close();  
    }  
}