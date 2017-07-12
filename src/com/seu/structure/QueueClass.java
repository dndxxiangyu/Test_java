package com.seu.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class QueueClass {
	public static void main(String[] args){
		ArrayList<Integer> a=new ArrayList<Integer>(0);
		LinkQueue<Integer> s = new LinkQueue<Integer>();
		s.enqueue(1);
		s.enqueue(2);
		s.enqueue(3);
		s.enqueue(4);
		s.enqueue(5);
		s.enqueue(6);
		s.enqueue(6);
		s.enqueue(6);
		s.enqueue(6);
		s.dequeue();
		System.out.println(s);
		s.dequeue();
		System.out.println(s);
		System.out.println(Math.sqrt(13));
		
		
	}
}
/**
 * 空一格作为辨别标识；
 * @author hp
 *
 * @param <E>
 */
class SeqQueue<E> implements QQueue<E>{
	public Object[] array;
	private int front,rear;
	public int n;
	public SeqQueue(){
		this(1);
	}
	public SeqQueue(int i){
		if(i==0)
			array=new Object[10];
		array=new Object[Math.abs(i)];
		front=rear=0;
	}
	public E dequeue() {
		if(front==rear){
			return null;
		}else{
			E p=(E)array[front];
			array[front]=null;
			front=(front+1)%array.length;
			n--;
			return p;
		}
		
	}

	public boolean enqueue(E element) {
		if(element==null)return false;
		if(front==(rear+1)%array.length){
			Object[] temp=array;
			array = new Object[2*temp.length];
			for(int i=0;i<temp.length-1;i++){
				array[i]=temp[front];
				front=(front+1)%temp.length;
			}
			front=0;
			rear=temp.length-1;
		}
		array[rear]=element;
		rear=(rear+1)%array.length;
		n++;
		return true;
	}

	public boolean isEmpty() {
		return front==rear;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int i=0;
		int j=front;
		while(j!=rear){
			sb.append((E)array[j]);
			if(i!=n-1)sb.append(",");
			j=(j+1)%array.length;
			i++;
		}
		sb.append("]");
		return sb.toString();
	}
}

class LinkQueue<E> implements QQueue<E>{
	private Node<E> head;
	private Node<E> rear;
	private int n;
	
	public E dequeue() {
		if(head==null){
			return null;
		}else{
			E p=head.data;
			head=head.next;
			n--;
			return p;
		}
	}

	public boolean enqueue(E element) {
		// 增加
		if(element==null)return false;
		Node<E> p=head;
		Node<E> q=new Node<E>(element);
		if(head==null&&rear==null){
			head=q;
			rear=q;
		}else{
			rear.next=q;
			rear=q;
		}
		n++;
		return true;
	}

	public boolean isEmpty() {
		return n==0;
	}
	
	public String toString(){
		if(head==null){
			return null;
		}else{
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			Node<E> p=head;
			int i=0;
			while(p!=null){
				sb.append(p.data);
				if(i!=n-1)sb.append(",");
				i++;
				p=p.next;
			}
			sb.append("]");
			return sb.toString();
		}
		
	}
	
}