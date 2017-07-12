package com.seu.suanfa;

public class NodeTest {

	/**
	 * 链表相邻元素翻转，如a->b->c->d->e->f-g，翻转后变为：b->a->d->c->f->e->g 
	 */
	public static void main(String[] args) {
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> a1 = new Node<Integer>(2);
		Node<Integer> a2 = new Node<Integer>(3);
		Node<Integer> a3 = new Node<Integer>(4);
		Node<Integer> a4 = new Node<Integer>(5);
		Node<Integer> a5 = new Node<Integer>(6);
		a.next=a1;
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		a4.next=a5;
		reverse(a);
		Node<Integer> p =a;
		while(p!=null){
			System.out.print(p.data);
			p = p.next;
		}
		System.out.println();
		
	}
	public static void reverse(Node<Integer> p){
		if(p==null)return;
		Node<Integer> a = p;
		while(a!=null && a.next!=null){
			int temp = a.data;
			a.data=a.next.data;
			a=a.next;
			a.data=temp;
			a = a.next;
		}
	}
}
