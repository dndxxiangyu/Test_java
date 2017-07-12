package microsoft_100;

public class m_042合并两个排序链表 {

	/**
	 * 42.请修改append函数，利用这个函数实现：
	 * 两个非降序链表的并集，1->2->3 和 2->3->5 并为 1->2->3->5
	 * 另外只能输出结果，不能修改两个链表的数据。
	 */
	public static void main(String[] args) {
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> a1 = new Node<Integer>(2);
		Node<Integer> a11 = new Node<Integer>(2);
		Node<Integer> a2 = new Node<Integer>(3);
		Node<Integer> b = new Node<Integer>(2);
		Node<Integer> b1 = new Node<Integer>(3);
		Node<Integer> b2 = new Node<Integer>(5);
		a.next=a1;
		a1.next=a11;
		a11.next=a2;
		b.next=b1;
		b1.next=b2;
		m_042合并两个排序链表 m = new m_042合并两个排序链表();
		Node<Integer> p = m.get(a, b);
		while(p!=null){
			System.out.print(p.data+" ");
			p = p.next;
		}
	}
	public Node<Integer> get(Node<Integer> a,Node<Integer> b){
		if(a==null||b==null)return null;
		Node<Integer> p1 = a;
		Node<Integer> p2 = b;
		Node<Integer> temp = null;
		Node<Integer> head = null;
		while(p1!=null&&p2!=null){
			if(p1.data>p2.data){
				if(head==null){
					temp = new Node<Integer>(p2.data);
					head=temp;
				}else{
					if(temp.data!=p2.data){
						Node<Integer> t = new Node<Integer>(p2.data);
						temp.next = t;
						temp = temp.next;
					}
					
				}
				p2 = p2.next;
			}else if(p1.data<p2.data){
				if(head==null){
					temp = new Node<Integer>(p1.data);
					head=temp;
				}else{
					if(temp.data!=p1.data){
						Node<Integer> t = new Node<Integer>(p1.data);
						temp.next = t;
						temp = temp.next;
					}
				}
				p1 = p1.next;
			}else if(p1.data==p2.data){
				if(head==null){
					temp = new Node<Integer>(p2.data);
					head=temp;
				}else{
					if(temp.data!=p2.data){
						Node<Integer> t = new Node<Integer>(p2.data);
						temp.next = t;
						temp = temp.next;
					}
				}
				p2 = p2.next;
				p1 = p1.next;
			}
		}
		while(p1!=null){
			Node<Integer> p = new Node<Integer>(p1.data);
			temp.next=p;
			temp = temp.next;
			p1 = p1.next;
		}
		while(p2!=null){
			Node<Integer> p = new Node<Integer>(p2.data);
			temp.next=p;
			temp = temp.next;
			p2 = p2.next;
		}
		return head;
	}
}
