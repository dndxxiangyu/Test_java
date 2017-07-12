package com.seu.structure;

/**
 * 没有头结点
 * @author hp
 *
 */
public class SinglyListClass {

	public static void main(String[] args) {
		
//		SinglyList<String> s = new SinglyList<String>();
//		s.add("xx1");
//		s.add("xx2");
//		s.add("xx3");
//		s.add("xx4");
//		s.add("xx5");
//		s.add(5, "xx6");
//		s.remove(0);
//		s.set(1, "ccc");
//		System.out.println(s);
//		System.out.println("数组长度："+s.size());
//		s.reverse();
//		System.out.println(s);
		SortList s = new SortList();
		s.add(10);
		s.add(9);
		s.add(7);
		s.add(6);
		s.add(9);
		System.out.println(s);
	}

}
class Node<E>{
	public E data;
	public Node<E> next;
	
	public Node(E data,Node<E> next){
		this.data=data;
		this.next=next;
	}
	public Node(E data){
		this(data,null);
	}
	public Node(){
		this(null,null);
	}
}

class SinglyList<E> implements LList<E>{

	private Node<E> head;
	private int n;
	
	public boolean add(int index, E element) {
		if(element==null)return false;
		if(index<0||index>n)//把下标错误的都阻挡住了。
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		Node<E> p = head;
		Node<E> q = new Node<E>(element);
		if(index==0){//包含了head==null的情况；
			q.next=p;
			head=q;
		}else{
			int i=0;
			while(i<index-1){
				i++;
				p=p.next;
			}
			q.next=p.next;
			p.next=q;
		}
		n++;
		return true;
	}

	public boolean add(E element) {
		return this.add(n, element);
	}

	public void clear() {
		this.head=null;
		n=0;
	}

	public E get(int index) {
		if(index<0||index>=n)
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		Node<E> p = head;
		int j=0;
		while(j<index){
			j++;
			p=p.next;
		}
		
		return p.data;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public E remove(int index) {
		E old = null;
		if(index<0||index>n-1)
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		Node<E> p = head;
		if(index==0){
			old=head.data;
			head=p.next;
		}else{
			int j=0;
			while(j<index-1){
				j++;
				p=p.next;
			}
			old=p.next.data;
			p=p.next.next;
		}
		n--;
		return old;
	}

	public E set(int index, E element) {
		if(element==null)return null;
		if(index<0||index>n-1)
			throw new IndexOutOfBoundsException("Index:"+index+", Size: "+n);
		int j=0;
		Node<E> p = head;
		while(j<index){
			j++;
			p=p.next;
		}
		E old=p.data;
		p.data=element;
		return old;
	}

	public int size() {
		return n;
	}
	public String toString(){
		if(head==null)return null;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> p = head;
		int j=0;
		while(p!=null){
			j++;
			sb.append(p.data);
			if(j!=n)sb.append(",");
			p=p.next;
		}
		sb.append("]");
		return sb.toString();
	}
	//单链表逆转
	public void reverse(){
		Node<E> p=head;
		Node<E> after=null;
		Node<E> front=null;
		while(p!=null){
			after=p.next;
			p.next=front;
			front=p;
			p=after;
		}
		head=front;
	}
}
//带有头结点的单链表
class HSList<E> implements LList<E>{

	private Node<E> head;
	private Node<E> rear;
	private int n;
	public boolean add(int index, E element) {
		if(element==null)return false;
		if(index<0||index>n)
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+n);
		Node<E> p=head;
		Node<E> q=new Node<E>(element);
		
		int i=0;
		while(i<index){
			i++;
			p=p.next;
		}
		q.next=p.next;
		p.next=q;
		if(index==n)rear=q;
		n++;
		return true;
	}

	public boolean add(E element) {
		if(element==null)return false;
		Node<E> q = new Node<E>(element);
		q.next=rear.next;
		rear.next=q;
		rear=q;
		n++;
		return true;
	}

	public void clear() {
		head=null;
		rear=null;
		n=0;
		
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return n;
	}
	
}

class SortList{
	private Node<Integer> head;
	private int n;
	
	public boolean add(Integer element){
		if(element==null)return false;
		Node<Integer> p =head;
		
		Node<Integer> q = new Node<Integer>(element);
		if(head==null){
			head=q;
		}else{
			if(element<=head.data){
				q.next=p;
				head=q;
			}else{
				while(p!=null){
					if(p.next.data>=element){
						q.next=p.next;
						p.next=q;
						n++;
						return true;
					}
					p=p.next;
				}
			}
		}
		n++;
		return false;
	}
	public String toString(){
		if(head==null)return null;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<Integer> p = head;
		int j=0;
		while(p!=null){
			j++;
			sb.append(p.data);
			if(j!=n)sb.append(",");
			p=p.next;
		}
		sb.append("]");
		return sb.toString();
	}
}