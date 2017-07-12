package microsoft_100;

public class m_011求二叉树中节点的最大距离 {

	/**
	 * 第 11 题（树）
	 * 求二叉树中节点的最大距离
	 * 如果我们把二叉树看成一个图，
	 * 父子节点之间的连线是双向我们姑且定义 "距离 "为两节点之间边的个 数。
	 * 写一个程序，求一棵二叉树中相距最远的两个节点之间离。
	 */
	int max;
	public static void main(String[] args) {
		Integer[] in = {1,2,3,null,null,null,4,5,6,null,null,null,7,8,9,null,null,null,null};
		BinaryTree<Integer> b = new BinaryTree<Integer>(in);
		System.out.println(b.root.data);
		System.out.println(new m_011求二叉树中节点的最大距离().getDictory(b, b.root));
		m_011求二叉树中节点的最大距离 t=new m_011求二叉树中节点的最大距离();
		t.h(b.root);
		System.out.println(t.max);
	}
	public <E> int getDictory(BinaryTree<E> tree,BinaryNode<E> p){
		if(p==null)return 0;
		if(p!=null){
			int a = tree.height(p.left);
			int b = tree.height(p.right);
			int c = a+b+1;
			if(c>max)max = c;
			getDictory(tree, p.left);
			getDictory(tree, p.right);
		}
		return max;
	}
	public <E> int h(BinaryNode<E> root){
		if(root==null)return 0;
		int a=h(root.left);
		int b=h(root.right);
		int sum=a+b;
		if(sum>max){
			max=sum;
		}
		return a>b?a+1:b+1;
	}
	public <E> int get(BinaryTree<E> tree,BinaryNode<E> root){
		BinaryNode<E> x = root;
		if(x==null)return 0;
		int height = tree.height(x.left)+tree.height(x.right);
		int left = get(tree,root.left);
		int right =  get(tree,root.right);
		return max;
	}
}
