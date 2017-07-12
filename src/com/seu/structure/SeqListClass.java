package com.seu.structure;

import java.util.ArrayList;
import java.util.Arrays;

public class SeqListClass {

	
	public static void main(String[] args) {
		SeqList<String> s = new SeqList<String>(12);
		s.add("xx1");
		s.add("xx2");
		s.add("xx3");
		s.add("xx4");
		s.add("xx5");
		s.remove(1);
		System.out.println(s);
		System.out.println("array的长度："+s.size());
		System.out.println("----------------------------");
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("xx1");
//		a.add("xx2");
//		a.add("xx3");
//		a.add("xx4");
//		a.add("xx5");
//		System.out.println(a);
//		a.add(5,"xx6");
//		System.out.println("array的长度："+a.size());
		/**
		 * if(element==null)return false;
		if(index>n||index<0)
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		if(n==array.length){
			Object[] temp = array;
			array = new Object[2*array.length];
			for(int i=0;i<temp.length;i++){
				array[i]=temp[i];
			}
		}
		for(int i=n;i>index;i++){
			array[i]=array[i-1];
		}
		array[index]=element;
		n++;
		 */
	}

}
class SeqList<E> implements LList<E>{
	
	private Object[] array;//存放数据的数组
	private int n;//数据的长度，而不是数组的长度
	
	public SeqList(){
		this(10);
	}
	
	public SeqList(int a){
		if(a==0)a=10;
		array = new Object[Math.abs(a)];
		n=0;
	}
	
	public boolean add(int index, E element) {
		if(element==null)return false;//传入空内容
		if(index<0||index>n)//下标超过范围
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		if(n==array.length){
			Object[] temp=array;
			array = new Object[2*temp.length];
			for(int i=0;i<temp.length;i++){
				array[i]=temp[i];
			}
		}
		for(int i=n;i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=element;
		n++;
		return true;
	}

	public boolean add(E element) {
		return this.add(n, element);
	}

	public void clear() {
		if(n!=0){
			for(int i=0;i<n;i++){
				array[i]=null;
			}
			n=0;
		}
	}

	public E get(int index) {
		if(index<0||index>n-1)
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		return (E)array[index];
	}

	public boolean isEmpty() {
		return n==0;
	}

	public E remove(int index) {
		if(index<0||index>n-1)
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		E a = (E) array[index];
		for(int i=index;i<n-1;i++){
			array[i]=array[i+1];
		}
		array[n-1]=null;
		n--;
		return a;
	}

	public E set(int index, E element) {
		if(element==null)return null;
		if(index<0||index>n-1)
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		E old = (E) array[index];
		array[index]=element;
		return old;
	}

	public int size() {
		return n;
	}
	
	public String toString(){
		if(n==0)return null;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<n;i++){
			sb.append(array[i].toString());
			if(i!=n-1)sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}