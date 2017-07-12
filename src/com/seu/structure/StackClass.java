package com.seu.structure;

import java.util.Stack;


public class StackClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkStack<Integer> s =new LinkStack<Integer>();
		String string="()()()()";
		char a1='c';
		char a2='c';
		if(a1==a2)
		System.out.println("a1==a2");
		System.out.println(bracket(string));
		Stack<String> st=new Stack<String>();
		st.push("cc1");
		st.push("cc2");
		st.push("cc3");
		System.out.println("st:"+st+""+st.size());
	}
	public static String bracket(String string){
		//判断括号是否匹配
		LinkStack<String> stack = new LinkStack<String>();
		char[] cc=string.toCharArray();
		int i=0;
		while(i<cc.length){
			switch(cc[i]){
			case '(':stack.push(cc[i]+"");
				break;
			case ')':
				System.out.println(cc[i]+"--------------");
				if(stack.isEmpty()){
					stack.push(cc[i]+"");
				}else{
					if(stack.get().equals('('+""))stack.pop();
					else{
						stack.push(cc[i]+"");
					}
				}
				break;
			default:
				break;
			}
			i++;
		}
		return stack.toString();
	}
}
class SeqStack<E> implements SStack<E>{
	public Object[] array;
	public int n;
	public SeqStack(){
		this(1);//默认容量为10；
	}
	public SeqStack(int a){
		array=new Object[a];
	}
	public E get() {
		if(n==0){
			return null;
		}
		else{
			return (E)array[n-1];
		}
	}

	public boolean isEmpty() {
		return n==0;
	}

	public E pop() {
		if(n==0){
			return null;
		}else{
			E q = (E)array[n-1];
			array[n-1]=null;
			n--;
			return q;
		}
	}

	public boolean push(E element) {
		if(element==null)return false;
		if(n==array.length){
			Object[] temp=array;
			array=new Object[2*temp.length];
			for(int i=0;i<temp.length;i++){
				array[i]=temp[i];
			}
		}
		array[n]=element;
		n++;
		return false;
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
//单链表栈
class LinkStack<E> implements SStack<E>{
	public Node<E> head;
	public int n;
	
	public E get() {
		if(n==0)return null;
		return head.data;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public E pop() {
		if(n==0){
			return null;
		}else{
			E p=head.data;
			head=head.next;
			n--;
			return p;
		}
	}

	public boolean push(E element) {
		if(element==null)return false;
		Node<E> p=head;
		Node<E> q=new Node<E>(element);
		
		q.next=p;
		head=q;
		
		n++;
		return false;
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
}