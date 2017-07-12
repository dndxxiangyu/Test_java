package microsoft_100;

import java.util.Stack;

public class m_007_判断这俩个链表是否相交 {

	/**
	 * 第七题
	 * 微软亚院之编程判断俩个链表是否相交
	 * 给出俩个单向链表的头指针，比如 h1 ，h2 ，判断这俩个链表是否相交。
     * 为了简化问题，我们假设俩个链表均不带环。
	 * a->c->c1->c2->c3->c4
	 * b->c
	 */
	public static void main(String[] args) {
		Node1<Integer> a = new Node1<Integer>(1);
		Node1<Integer> b = new Node1<Integer>(11);
		Node1<Integer> c = new Node1<Integer>(2);
		Node1<Integer> c1 = new Node1<Integer>(3);
		Node1<Integer> c2 = new Node1<Integer>(4);
		Node1<Integer> c3 = new Node1<Integer>(5);
		Node1<Integer> c4 = new Node1<Integer>(6);
		a.next = c;
		c.next = c1;
		c1.next = c2;
		c2.next = c3;
		c3.next = c4;
//		b.next = c1;
//		System.out.println("无环链表是否相交："+new m_007().isCrossed(a, b));
		System.out.println("*********************************");
		System.out.println(new m_007_判断这俩个链表是否相交().isCircled(a));
		System.out.println("*********************************");
		System.out.println(new m_007_判断这俩个链表是否相交().isCrossed2(a, b));
		System.out.println("*********************************");
//		System.out.println(new m_007().fisrtCrossedNode1(a, b).data);
		new m_007_判断这俩个链表是否相交().reverse(a);
		
	}
	public <E> void reverse(Node1<E> head){
		Node1<E> p = head;
		if(p==null)return;
		reverse(p.next);
		System.out.println(p.toString());
	}
	//泛型函数
	public <E> boolean isCrossed(Node1<E> a,Node1<E> b){
		if(a==null||b==null)return false;
		while(a.next!=null){
			a = a.next;
		}
		while(b.next!=null){
			b = b.next;
		}
		if(a==b){//比较物理地址
			return true;
		}else{
			return false;
		}
	
	}
	//链表带不带环
	public <E> boolean isCircled(Node1<E> a){
		if(a==null)return false;
		Node1<E> p1 = a;//speed=1
		Node1<E> p2 = a;//speed=2
		while(p2!=null&&p2.next!=null){
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2){
				return true;
			}
		}
		return false;
	}
	public <E> Node1<E> isCircled2(Node1<E> a){
		if(a==null)return null;
		Node1<E> p1 = a;//speed=1
		Node1<E> p2 = a;//speed=2
		while(p2!=null&&p2.next!=null){
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2){
				return p1;
			}
		}
		return null;
	}
	/**
	 * 如果链表带环，
	 * 那判断一链表上俩指针相遇的那个节点，在不在另一条链表上。
	 * 如果在，则相交，如果不在，则不相交。
	 */
	public <E> boolean isCrossed2(Node1<E> a,Node1<E> b){
		if(a==null||b==null)return false;
		if(this.isCircled2(a)!=null){
			while(b!=null){
				if(b==this.isCircled2(a)){
					return true;
				}
				b = b.next;
			}
		}
		return false;
	}
	
	//如果需要求出俩个链表相交的第一个节点列?
	//可以用两个栈
	//2求长度
	public <E> Node1<E> fisrtCrossedNode1(Node1<E> a, Node1<E> b){
		if(a==null||b==null)return null;
		Stack<Node1<E>> stack1 = new Stack<Node1<E>>();
		Stack<Node1<E>> stack2 = new Stack<Node1<E>>();
		while(a!=null){
			stack1.push(a);
			a = a.next;
		}
		while(b!=null){
			stack2.push(b);
			b = b.next;
		}
		if(stack1.peek()==stack2.peek()){
			Node1<E> p = stack1.pop();
			stack2.pop();
			
			while(stack1.peek()==stack2.peek()){
				p = stack1.pop();
				stack2.pop();
			}
			return p;
		}
		return null;
	}
}
class Node1<E>{
	public E data;
	public Node1<E> next;
	
	public Node1(E data, Node1<E> next){
		this.data = data;
		this.next = next;
	}
	public Node1(E data){
		this(data, null);
	}
	public Node1(){
		this(null,null);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data.toString();
	}
}