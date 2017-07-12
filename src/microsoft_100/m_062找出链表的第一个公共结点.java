package microsoft_100;

public class m_062找出链表的第一个公共结点 {

	/**
	 * 62.找出链表的第一个公共结点。
	题目：两个单向链表，找出它们的第一个公共结点。
	方法：找出两条链表的长短差值
	 */
	public static void main(String[] args) {
		Node<Integer> a=new Node<Integer>(1);
		Node<Integer> a1=new Node<Integer>(2);
		Node<Integer> a2=new Node<Integer>(3);
		Node<Integer> a3=new Node<Integer>(4);
		Node<Integer> b=new Node<Integer>(5);
		Node<Integer> b1=new Node<Integer>(5);
		Node<Integer> b2=new Node<Integer>(5);
		a.next=a1;
		a1.next=a2;
		a2.next=a3;
		b.next=b1;
		b1.next=b2;
		b2.next=a1;
		System.out.println(new m_062找出链表的第一个公共结点().getFirstSame(a, b).data);
	}
	public Node<Integer> getFirstSame(Node<Integer> a, Node<Integer> b){
		if(a==null||b==null)return null;
		Node<Integer> p1 = a;
		Node<Integer> p2 = b;
		int len1=0;
		while(p1.next!=null){
			len1++;
			p1 = p1.next;
		}
		int len2=0;
		while(p2.next!=null){
			len2++;
			p2 = p2.next;
		}
		//先判断是否相交
		if(p1!=p2)return null;
		p1=a;
		p2=b;
		int step = Math.abs(len1-len2);
		if(len1>len2){
			for(int i=0;i<step;i++){
				p1 = p1.next;
			}
		}else{//当相等的时候，下面代码不执行
			for(int i=0;i<step;i++){
				p2 = p2.next;
			}
		}
		/**
		 * 这里有一大问题，如果第一个节点就相等了怎么办。
		 */
		while(p1!=null&&p2!=null){
			if(p1==p2)return p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		return null;
	}
}
