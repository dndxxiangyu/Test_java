package netease;

import java.io.File;  
import java.io.FileFilter;  
import java.io.IOException;  
import java.net.JarURLConnection;  
import java.net.URL;  
import java.net.URLDecoder;  
import java.util.ArrayList;  
import java.util.Enumeration;  
import java.util.LinkedHashSet;  
import java.util.List;  
import java.util.Set;  
import java.util.jar.JarEntry;  
import java.util.jar.JarFile;  

public class ClassUtil {
	public static void main(String[] args) throws Exception{  
		String str1 = "1吴向禹";
		
		System.out.println(str1.length());
		byte[] byte1 = str1.getBytes("gbk");
		System.out.println(byte1.length);
	} 
	
   
}