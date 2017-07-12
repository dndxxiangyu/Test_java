package yeheya;

import java.util.Arrays;

public class QueueClass {

	public static void main(String[] args){
		SeqQueue<Integer> queue = new SeqQueue<Integer>();
		for(int i = 0; i < 10; i++){
			queue.add(i);
		}
		System.out.println(queue);
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		System.out.println(queue);
		queue.add(10);
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);

		System.out.println(queue);
	}
}
interface Queue<E>{
	boolean add(E e);
	boolean isEmpty();
	E poll();
	E peek();
}
//循环队列
class SeqQueue<E> implements Queue<E>{
	private Object[] elements;
	private int front , rear;//尾巴进，头出。
	private int len;
	public SeqQueue(){
		this(10);
	}
	public SeqQueue(int size){
		elements = new Object[Math.abs(size)];
		len = 0;
		front = rear = 0;
	}
	public boolean add(E e) {
		if(e == null)return false;
		if(len == elements.length){
			Object[] temp = elements;
			elements = new Object[2 * len];
			for(int i = 0; i < len; i++){
				elements[i] = temp[front];
				front = (front+1)%temp.length;//注意啊！！！！！！！！！！！！！！！！！！！！！！1
			}
			front = 0;
			rear = len;
		}
		elements[rear] = e;
		rear = (rear + 1) % elements.length;
		len++;
		return true;
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public E peek() {
		if(len == 0)return null;
		
		return (E) elements[front];
	}

	public E poll() {
		if(len == 0)return null;
		E temp = (E) elements[front];
		elements[front] = null;
		front = (front+1)%elements.length;
		len--;
		return temp;
	}
	public String toString(){
		if(len == 0)return "[]";
		int k = front;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < len; i++){
			sb.append(elements[k]+"").append(" ");
			k = (k + 1) % elements.length;
		}
		sb.append("]");
		return sb.toString();
	}
}

class LinkedQueue<E> implements Queue<E>{
	private Node<E> front, rear;
	private int len;
	public LinkedQueue(){
		this.front = this.rear = null;
		len = 0;
	}
	public boolean add(E e) {
		if(e == null)return false;
		Node<E> temp = new Node<E>(e);
		if(rear == null){
			front = rear = temp;
		}else{
			rear.next = temp;
			rear = temp;
		}
		len++;
		return true;
	}

	public boolean isEmpty() {
		return len==0;
	}

	public E peek() {
		if(front == null)return null;
		
		return front.data;
	}

	public E poll() {
		if(front == null)return null;
		Node<E> temp = front;
		front = front.next;
		temp.next = null;
		len--;
		return temp.data;
	}
	
}