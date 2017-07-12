package com.seu.cc;

import java.util.ArrayList;
import java.util.Arrays;

public class SqList {

	
	public static void main(String[] args) {
		List<String> cc = new List<String>();
		cc.add("xx1");
		cc.add("xx2");
		cc.add("xx3");
		cc.add("xx4");
		cc.remove(1);
		System.out.println("数组的长度： "+cc.size());
		System.out.println(cc);
	}
}
class List<T>{
	private Object[] list;//数组存放的数据
	private int n;//数据的长度，并不是线性表的长度
	
	public List(){
		this(16);
	}
	
	public List(int length){
		list = new Object[length];
		n=0;
	}
	
	public T get(int index){
		if(index>=n||index<0||n<0){
			return null;
		}
		return (T)list[index];
	}
	
	public T set(int index,T element){
		if(index>=n||index<0||element!=null||n<0){
			return null;
		}
		T old = (T)list[index];
		list[index]=element;
		return old;
	}
	
	public T remove(int index){
		if(index>=n||index<0){
			return null;
		}
		if(n<0)return null;
		if(index<n&&index>=0){
			T old = (T)list[index];
			for(int i=index;i<n;i++){
				list[i]=list[i+1];
			}
			list[n-1]=null;
			n--;
			return old;
		}
		return null;
	}
	public boolean add(int index,T element){
		if(element==null)return false;
		if(n==list.length){
			Object[] temp = list;
			list=new Object[2*temp.length];
			for(int i=0;i<temp.length;i++){
				list[i]=temp[i];
			}
		}
		if(index<0)index=0;
		if(index>n)index=n;
		for(int i=n-1;i>index;i++){
			list[i]=list[i-1];
		}
		list[index]=element;
		n++;
		return true;
	}
	public boolean add(T element){
		return add(n,element);
	}
	
	public int size(){
		return n;
	}
	
	public String toString(){
		return Arrays.toString(list);
	}
}
