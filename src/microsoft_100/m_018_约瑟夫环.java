package microsoft_100;

public class m_018_约瑟夫环 {

	/**
	 * 第18题：
	 * 题目：n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
	 * 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
	 * 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。
	 * 求出在这个圆圈中剩下的最后一个数字。
	 */
	public static void main(String[] args) {
		int n=9;
		Node<Integer> head = null;
		Node<Integer> p = null;
		for(int i=0;i<n;i++){
			Node<Integer> a = new Node<Integer>(i);
			if(head==null){
				head = a;
				p = head;
			}else{
				p.next = a;
				p = a;
			}
			
		}
		p.next = head;//变成一个环链表
		p = head;
//		while(p!=null){
//			System.out.println(p.data);
//			p = p.next;
//		}
//		p.next = head;
		int k=3;//从0开始，步长为3
		while(p.next!=p){
			for(int i=0;i<k-1;i++){
				p = p.next;
			}
			Integer d = p.next.data;
			System.out.print(p.data+" ");
			Node<Integer> temp = p.next;
			p.next = p.next.next;
			temp.next=null;
			p.data = d;
		}
		System.out.println();
		System.out.println(p.data);
		
		
		joseph(0, 0);
	}
	public static void joseph(int n,int k){
		int[] temp = new int[n];
		for(int i=0;i<temp.length;i++){
			temp[i]= i;
		}
		
	}

}
