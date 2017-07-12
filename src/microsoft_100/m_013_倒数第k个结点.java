package microsoft_100;

public class m_013_倒数第k个结点 {

	/**
	 * 第 13 题（链表）
	 * 题目：输入一个单向链表，出该中倒数第 k个结点。链表的倒数第 0个结点为链表 的尾指针。
	 */
	public static void main(String[] args) {
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> b = new Node<Integer>(2);
		Node<Integer> c = new Node<Integer>(3);
		Node<Integer> d = new Node<Integer>(4);
		Node<Integer> e = new Node<Integer>(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
//		System.out.println("get :"+new m_013().get(4, a).data);
		System.out.println("get :"+new m_013_倒数第k个结点().get2(2, a).data);
	}
	public Node<Integer> get(int k,Node<Integer> head){
		java.util.Stack<Node<Integer>> stack = new java.util.Stack<Node<Integer>>();
		Node<Integer> p = head;
		while(p!=null){
			stack.push(p);
			p = p.next;
		}
		if(k>=stack.size()){
			return null;
		}else{
			for(int i=0;i<k;i++){
				stack.pop();
			}
		}
		return stack.peek();
	}
	//no stack
	public Node<Integer> get2(int k,Node<Integer> head){
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;
		for(int i=0;i<k;i++){
			if(p2!=null){
				p2 = p2.next;
			}else{
				return null;
			}
		}
		while(p2!=null&&p2.next!=null){
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
}
