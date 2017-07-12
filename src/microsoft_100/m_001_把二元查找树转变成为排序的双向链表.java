package microsoft_100;

import java.util.Stack;


public class m_001_把二元查找树转变成为排序的双向链表 {

	/**
	 * 把二元查找树转变成为排序的双向链表
	 * 要求不能创建任何新的结点，只调整指针的指向。
	 * root为二次排序树的根
	 */
	BinaryNode<Integer> head;
	BinaryNode<Integer> listIndex;
	
	BinaryNode<Integer> head2;
	BinaryNode<Integer> listIndex2;
	
	BinaryNode<Integer> head3;
	BinaryNode<Integer> listIndex3;
	public static void main(String[] args) {
		BinaryNode<Integer> root = new BinaryNode<Integer>(12);
		BinaryNode<Integer> a = new BinaryNode<Integer>(9);
		BinaryNode<Integer> b = new BinaryNode<Integer>(10);
		BinaryNode<Integer> c = new BinaryNode<Integer>(11);
		BinaryNode<Integer> d = new BinaryNode<Integer>(13);
		BinaryNode<Integer> e = new BinaryNode<Integer>(14);
		BinaryNode<Integer> f = new BinaryNode<Integer>(15);
		root.left = b;
		root.right = e;
		b.left = a;
		b.right = c;
		e.left = d;
		e.right = f;
		m_001_把二元查找树转变成为排序的双向链表 m = new m_001_把二元查找树转变成为排序的双向链表();
		m.inOrder(root);
		System.out.println();
		m.getDoubleLinked3(root);
		System.out.println(m.head3.data);
		BinaryNode<Integer> p = m.head3;
		while(p!=null){
			System.out.println(p.data);
			p = p.right;
		}
	}
	public  void inOrder(BinaryNode<Integer> p){
		if(p!=null){
			inOrder(p.left);
			System.out.print(p.data+" ");
			inOrder(p.right);
		}
	}
	/**
	 * 不是很好想到，其他两个可以通过中序遍历来推倒
	 */
	public void getDoubleLinked(BinaryNode<Integer> p){
		if(p==null)return;
		if(p.left!=null){
			getDoubleLinked(p.left);
		}
		BinaryNode<Integer> left = p.left;
		left = listIndex;
		if(listIndex!=null){
			listIndex.right = p;
		}else{
			head = p;
		}
		listIndex = p;
		System.out.println(p.data+" ");
		if(p.right!=null){
			getDoubleLinked(p.right);
		}
	}
	public void getDoubleLinked3(BinaryNode<Integer> p){
		if(p==null)return;
		getDoubleLinked3(p.left);
		if(head3==null){
			head3 = p;
			listIndex3 = p;
		}else{
			p.left = listIndex3;
			listIndex3.right = p;
			listIndex3 = p;
		}
		getDoubleLinked3(p.right);
	}
	public void getDoubleLinked2(BinaryNode<Integer> root){
	
		if(root==null)return;
		Stack<BinaryNode<Integer>> stack = new Stack<BinaryNode<Integer>>();
		BinaryNode<Integer> p = root;
		while(p!=null || !stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				if(head2 == null){
					head2 = p;
					listIndex2=p;
				}else{
					listIndex2.right = p;
					p.left = listIndex2;
					listIndex2 = p;
				}
				p = p.right;
			}
		}
	}
}

