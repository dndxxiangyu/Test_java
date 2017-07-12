package microsoft_100;

public class m_024_反转链表 {

	/**
	 * 第24题：反转链表
	 */
	public static void main(String[] args) {
		Node<Integer> a1 = new Node<Integer>(1);
		Node<Integer> a2 = new Node<Integer>(2);
		Node<Integer> a3 = new Node<Integer>(3);
		Node<Integer> a4 = new Node<Integer>(4);
		Node<Integer> a5 = new Node<Integer>(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		
		reverse2(a1);
		Node<Integer> node = reverse(a1);
		Node<Integer> p = node;
		while(p!=null){
			System.out.print(p.data+" ");
			p = p.next;
		}
	}
	public static void reverse2(Node<Integer> p){
		if(p==null) return;
		reverse2(p.next);
		System.out.println(p.data);
	}
	public static Node<Integer> reverse(Node<Integer> node){
		if(node == null)return null;
		Node<Integer> p = node;
		Node<Integer> front = null;
		Node<Integer> after = null;
		while(p!=null){
			after = p.next;
			p.next = front;
			front = p;
			p = after;//must be careful
		}
		return front;
	}
	
}

