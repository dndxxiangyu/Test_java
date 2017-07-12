package yeheya;

import java.util.Stack;

public class StackClass {

	/**
	 * 栈的实现，顺序栈、链表栈
	 */
	public static void main(String[] args) {
		LinkedStack<String> string = new LinkedStack<String>();
		System.out.println(string);
		string.push("1");
		string.push("2");
		string.push("3");
		string.push("4");
		System.out.println(string);
		string.pop();
		System.out.println(string);
		string.pop();
		System.out.println(string);
		string.pop();
		System.out.println(string);
		string.pop();
		System.out.println(string);
	}

}
class SeqStack<E>{
	private Object[] elements;
	private int top;
	
	public SeqStack(){
		this(10);
	}
	public SeqStack(int size){
		elements = new Object[Math.abs(size)];
		top = 0;
	}
	
	public boolean isEmpty(){
		return top == 0;
	}
	public E push(E element){
		if(element == null)return null;
		if(elements.length == top){
			Object[] temp = elements;
			elements = new Object[2*elements.length+1];
			for(int i = 0; i < temp.length; i++){
				elements[i] = temp[i];
			}
		}
		elements[top] = element;
		top++;
		return element;
	}
	public E get(){
		return this.top == 0 ? null : (E)elements[top];
	}
	public E pop(){
		if(top == 0){
			throw new ArrayIndexOutOfBoundsException("no number");
		}
		E temp = this.get();
		elements[top] = null;
		top--;
		return temp;
	}
	public String toString(){
		if(top == 0)return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < top; i++){
			sb.append(elements[i].toString());
			if(i != top-1)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}
//no head node of linked
class LinkedStack<E>{
	private Node<E> top;
	public LinkedStack(){
		this.top = null;
	}
	public boolean isEmpty(){
		return top == null;
	}
	public E push(E element){
		if(element == null)return null;
		Node<E> temp = new Node<E>(element);
		temp.next = top;
		top = temp;
		return top.data;
	}
	public E pop(){
		if(top == null){
			throw new ArrayIndexOutOfBoundsException("no number");
		}
		Node<E> temp = top;
		E e = top.data;
		top = top.next;
		temp.next = null;
		return e;
	}
	public E get(){
		if(top == null)return null;
		return top.data;
	}
	public String toString(){
		if(top == null)return null;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> temp = top;
		while(temp != null){
			sb.append(temp.data.toString()+" ");
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}
}