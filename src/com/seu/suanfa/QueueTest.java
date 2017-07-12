package com.seu.suanfa;

import java.util.Stack;

public class QueueTest {

	Stack<String> stack1;//in
	Stack<String> stack2;//out
	public QueueTest(){
		this.stack1 = new Stack<String>();
		this.stack2 = new Stack<String>();
	}
	public  boolean offer(String s){
		//in
		if(s==null)return false;
		stack1.push(s);
		return true;
	}
	public String pop(){
		if(stack2.size()==0){
			int len = stack1.size();
			for(int i=0;i<len;i++){
				stack2.add(stack1.pop());
			}
			return stack2.pop();
		}else{
			return stack2.pop();
		}
	}
	public static void main(String[] args) {
		QueueTest q = new QueueTest();
		q.offer("a");
		q.offer("b");
		System.out.println(q.pop());
		q.offer("c");
		System.out.println(q.pop());
		System.out.println(q.pop());
		q.offer("d");
		q.offer("e");
		System.out.println(q.pop());
		q.offer("f");
		System.out.println(q.pop());
		System.out.println(q.pop());
	}
}
