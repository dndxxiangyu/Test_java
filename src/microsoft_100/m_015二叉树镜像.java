package microsoft_100;

import java.util.Stack;

public class m_015二叉树镜像 {

	/**
	 * 题目：输入一颗二元查找树，将该树转换为它的镜像，
	 * 即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
	 * 用递归和循环两种方法完成树的镜像转换。
	 */
	BinaryNode<Integer> root;
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
		m_015二叉树镜像 m = new m_015二叉树镜像();
		m.root = root;
		m.mirror2(root);
		m.mirror2(root);
//		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);
//		tree.inOrder();
	}
	public void mirror(BinaryNode<Integer> p){
		if(p==null)return ;
		BinaryNode<Integer> temp = p.right;
		p.right = p.left;
		p.left = temp;
		mirror(p.left);
		mirror(p.right);
	}
	//no reverse
	public void mirror2(BinaryNode<Integer> p){
		if(p==null)return;
		Stack<BinaryNode<Integer>> stack = new Stack<BinaryNode<Integer>>();
		stack.push(p);
		while(!stack.isEmpty()){
			BinaryNode<Integer> get = stack.pop();
			BinaryNode<Integer> temp = get.left;
			get.left = get.right;
			get.right = temp;
			if(get.left!=null)stack.add(get.left);
			if(get.right!=null)stack.add(get.right);
			
		}
	}
}
