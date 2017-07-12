package microsoft_100;

public class m_058从尾到头输出链表 {

	/**
	 * 58.从尾到头输出链表。
	 */
	public static void main(String[] args) {
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> a1 = new Node<Integer>(2);
		Node<Integer> a2 = new Node<Integer>(3);
		Node<Integer> a3 = new Node<Integer>(4);
		Node<Integer> a4 = new Node<Integer>(5);
		Node<Integer> a5 = new Node<Integer>(6);
		Node<Integer> a6 = new Node<Integer>(7);
		a.next=a1;
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		a4.next=a5;
		a5.next=a6;
		new m_058从尾到头输出链表().reverse(a);
	}
	public void reverse(Node<Integer> p){
		if(p!=null){
			reverse(p.next);
			System.out.print(p.data);
		}
	}
}
