package com.seu.cc;
/**
 * 线性表的链表实现
 * @author hp
 *
 */
public class LinkedList {

	
	public static void main(String[] args) {
		
	}

}
class Node<E>{
	public E data;
	public Node<E> next;
	public Node(){
		this(null,null);
	}
	public Node(E data,Node<E> next){
		this.data=data;
		this.next=next;
	}
	public Node(E data){
		this(data,null);
	}
}
class LList<E>{
	private Node<E> head;
	private int size;
	public LList(){
		head=null;
	}
	public LList(Node<E> head){
		this.head=head;
	}
	public boolean add(int index,E element){
		if(element==null)return false;
		if(this.head==null||index<=0){
			Node<E> q = new Node<E>(element);
			q.next=head;
			head=q;
		}else{
			int j=0;//遍历要插入的地方
			Node<E> p = this.head;
			while(p.next!=null&&j<index-1){
				j++;
				p=p.next;
			}
			Node<E> q = new Node<E>(element);
			q.next=p.next;
			p.next=q;
		}
		return true;
	}
	public E remove(int index){
		E old=null;
		if(head!=null&&index>=0){
			if(index==0){
				old=head.data;
				head=head.next;
			}else{
				int j=0;
				Node<E> p = head;
				while(p.next!=null&&j<index-1){
					j++;
					p=p.next;
				}
				if(p.next!=null){
					old=p.next.data;
					p.next=p.next.next;
				}
			}
		}
		return old;
	}
}