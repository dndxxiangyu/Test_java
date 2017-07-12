package com.seu.cc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Thread a;
		try {
			File path = new File("d:\\abcd");
			if(!path.exists()){
				path.mkdirs();
			}
			oos = new ObjectOutputStream(new FileOutputStream("d:\\abcd\\object.txt"));
			Person per = new Person("xxdecc",50);
			System.out.println(per.hashCode());
			oos.writeObject(per);
			ois = new ObjectInputStream(new FileInputStream("d:\\abcd\\object.txt"));
			Person per1 = (Person) ois.readObject();
			System.out.println("name："+per1.getName());
			System.out.println("age："+per1.getAge());
			System.out.println("age："+per1.color);//不会保存在文件中，而会直接从类中获取
			System.out.println(per1.hashCode());
			System.out.println(per1.equals(per));
			per1.get();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ois!=null){
					ois.close();
				}
				if(oos!=null){
					oos.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

class Person implements java.io.Serializable{
	/**
	 * 
	 */
	//id可以表名换了id后表示类做出了改变，这样就不能对保存在硬盘中的对象进行还原，然后报错处理
	private static final long serialVersionUID = 1L;
	private String name;
	private transient int age;//表示不被序列化保存。即忽略 序列化。
	public static int color=10;
	public Person(String name,int age) 
	{
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void get(){
		System.out.println("method : get");
	}
	
	
}