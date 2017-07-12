package com.seu.suanfa;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import yeheya.List;

public class ListClass{
	
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> sl = new SingleLinkedList<Integer>();
		for(int i = 0; i < 10; i++){
			sl.add(i);
		}
		System.out.println(sl);
		sl.add(100);
		System.out.println(sl);
		sl.remove(0);
		System.out.println(sl);
		sl.add(0, 10);
		System.out.println(sl);
		sl.reverse();
		System.out.println(sl);
		sl.clear();
	}

}
/**
 * 
 * 线性表的顺序表示
 */
class ArrayList<E> implements List<E>{
	private Object[] elements;
	private int len;
	public ArrayList(){
		this(10);
	}
	public ArrayList(int size){
		//if(size ==0) ??
		if(size < 0){
			throw new IllegalArgumentException("Illegal Capacity: " + size);
		}
		this.elements = new Object[size];
		this.len = 0;
	}
	
	public ArrayList(ArrayList<E> arr){
		
	}
	
	public boolean add(int index, E element) {
		if(element == null)return false;
		if(index < 0 || index > this.len){
			throw new IndexOutOfBoundsException("index:" + index + ", size:" + this.len);
		}
		if(len == elements.length){
			Object[] temp = this.elements;
			elements = new Object[2*temp.length+1];
			for(int i = 0; i < temp.length; i++){
				elements[i] = temp[i];
			}
			for(int i = 0; i < temp.length; i++){
				temp[i] = null;
			}//clear
		}
		for( int i = len; i > index; i--){
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		len++;
		return true;
	}

	public boolean add(E element) {
		
		return this.add(len, element);
	}

	public void clear() {
		for(int i = 0; i< this.len; i++){
			this.elements[i] = null;
		}
		this.len = 0;
	}

	public E get(int index) {
		if(index < 0 || index >= this.len){
			throw new IndexOutOfBoundsException("index:" + index + " , size:" + this.len);
		}
		return (E) this.elements[index];
	}

	public boolean isEmpty() {
		return this.len == 0;
	}

	public E remove(int index) {
		if( index < 0 || index >= this.len){
			throw new IndexOutOfBoundsException("index:"+index+" , size:"+this.len);
		}
		E temp = (E) elements[index];
		for(int i = index; i < this.len-1; i++){
			elements[index] = elements[index+1];
		}
		elements[len-1] = null;
		len--;
		return temp;
	}

	public E set(int index, E element) {
		if(element == null)return null;
		if(index < 0 || index >= this.len){
			throw new IndexOutOfBoundsException("index:" + index + " , size:" + this.len);
		}
		E old = (E) elements[index];
		elements[index] = element;
		return old;
	}

	public int size() {
		return this.len;
	}
	
	@Override
	public String toString() {
		if(len == 0)return "[]";
		StringBuilder sb  = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < len; i++){
			sb.append(elements[i].toString());
			if( i != len - 1)sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}



/**
 * 
 * 线性表的链式表示
 */
//单链表
class Node<E>{
	public E data;
	public Node<E> next;
	
	public Node(E data, Node<E> next){
		this.data = data;
		this.next = next;
	}
	public Node(E data){
		this(data, null);
	}
	public Node(){
		this(null,null);
	}
}
//带头结点的单链表
class SingleLinkedList<E> implements List<E>{
	
	private Node<E> head;
	private int len;
	public SingleLinkedList(){
		this.head = new Node<E>();
		this.len = 0;
	}
	
	public SingleLinkedList(E[] elements){
		this();
		Node<E> temp = this.head;
		for(int i = 0; i < elements.length; i++){
			temp.next = new Node<E>(elements[i],null);
			temp = temp.next;
		}
	}
	public boolean add(int index, E element) {
		//需要两个指针来表示插入的地方的前后位置
		if(element == null)return false;
		if(index < 0 || index > this.len){
			throw new IndexOutOfBoundsException("index: " + index + ", size:" + len);
		}
		Node<E> temp = head;
		Node<E> node = new Node<E>(element);
		if(len == 0){
			head.next = node;
		}else{
			for(int i = 0; i < index; i++){
				temp = temp.next;
			}// find the place to insert
			node.next = temp.next;
			temp.next = node;
		}
		len++;
		return true;
	}

	public boolean add(E element) {
		return this.add(len, element);
	}

	public void clear() {
		Node<E> temp = head;
		Node<E> p = head;
		for(int i = 0; i < len; i++){
			p = temp.next;
			temp.next = null;
			temp = p;
		}
		temp = null;
		p = null;
		len = 0;
	}

	public E set(int index, E element) {
		if(element == null)return null;
		if(index < 0 || index >= len){
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + len);
		}
		Node<E> temp = head;
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		E old = temp.next.data;
		temp.next.data = element;
		return old;
	}

	public E get(int index) {
		if(index < 0 || index >= len){
			throw new IndexOutOfBoundsException("Index:" + index + ", Size: " + len);
		}
		Node<E> temp = head;
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		return temp.next.data;
	}

	public boolean isEmpty() {
		return this.len == 0;
	}

	public E remove(int index) {
		E old = null;
		if(index < 0 || index >= len){
			throw new IndexOutOfBoundsException("Index:" + index + ", Size: " + len);
		}
		Node<E> temp = head;
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		old = temp.next.data;
		temp.next = temp.next.next;
		len--;
		return old;
	}
	
	public int size() {
		return this.len;
	}
	
	public void reverse(){
		if(len > 0){
			Node<E> now = head.next;
			Node<E> front = null;
			Node<E> after = null;
			while(now != null){
				after = now.next;
				now.next = front;
				front = now;
				now = after;
			}
			head.next = front;
		}
	}
	@Override
	public String toString() {
		if(head.next == null)return "[]";
		Node<E> temp = head;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < len; i++){
			sb.append(temp.next.data);
			if(i != len-1)sb.append(",");
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}
}