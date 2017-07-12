package microsoft_100;

public class m_039求一个二叉树中任意两个节点间的最大距离 {

	/**
	 * 39.11
	网易有道笔试：
	(1).
	求一个二叉树中任意两个节点间的最大距离，
	两个节点的距离的定义是 这两个节点间边的个数，
	比如某个孩子节点和父节点间的距离是1，和相邻兄弟节点间的距离是2，优化时间空间复杂度。
	(2).
	求一个有向连通图的割点，割点的定义是，如果除去此节点和与其相关的边，
	有向图不再连通，描述算法。
	 */
	int max=-1;
	public static void main(String[] args) {
		BinaryNode<Integer> root = new BinaryNode<Integer>(1);
		BinaryNode<Integer> root1 = new BinaryNode<Integer>(1);
		BinaryNode<Integer> root2 = new BinaryNode<Integer>(1);
		BinaryNode<Integer> root3 = new BinaryNode<Integer>(1);
		root.left = root1;
		root1.left = root2;
		root2.left = root3;
		m_039求一个二叉树中任意两个节点间的最大距离 m=new m_039求一个二叉树中任意两个节点间的最大距离();
		m.height(root);
		System.out.println(m.max);
		BinaryNode<Integer> p = new BinaryNode<Integer>(1);
		BinaryNode<Integer> p1 = new BinaryNode<Integer>(2);
		BinaryNode<Integer> p2 = new BinaryNode<Integer>(3);
		BinaryNode<Integer> p3 = new BinaryNode<Integer>(4);
		BinaryNode<Integer> p4 = new BinaryNode<Integer>(5);
		BinaryNode<Integer> p5 = new BinaryNode<Integer>(6);
		BinaryNode<Integer> p6 = new BinaryNode<Integer>(7);
		BinaryNode<Integer> p7 = new BinaryNode<Integer>(8);
		BinaryNode<Integer> p8 = new BinaryNode<Integer>(9);
		BinaryNode<Integer> p9 = new BinaryNode<Integer>(10);
		p.left = p1;
		p.right = p2;
		p1.left = p3;
		p1.right = p4;
		p2.left = p5;
		p2.right = p6;
		p3.left = p7;
		p4.right = p8;
		p5.left = p9;
		m_039求一个二叉树中任意两个节点间的最大距离 m1 = new m_039求一个二叉树中任意两个节点间的最大距离();
		m1.height(p);
		System.out.println(m1.max);
		m_039求一个二叉树中任意两个节点间的最大距离 m2 = new m_039求一个二叉树中任意两个节点间的最大距离();
		
		System.out.println(m2.getMaxLength(p));
	}
	public int height(BinaryNode<Integer> p){
		if(p==null)return 0;
		int lheight = height(p.left);
		int rheight = height(p.right);
		if(max < lheight+rheight)max=lheight+rheight;
		return lheight>rheight?lheight+1:rheight+1;
	}
	
	//常规的方法
	public int getMaxLength(BinaryNode<Integer> p ){
		if(p==null)return 0;
		int lheight = height(p.left);
		int rheight = height(p.right);
		//比较三个大小，经过root，或者最大在左子树，或者最大在右子树。
		int max = lheight+rheight;//有个问题是冗余太多了
		int maxleft = getMaxLength(p.left);
		int maxright = getMaxLength(p.right);
		return Math.max(max, Math.max(maxleft,maxright));
	}
}
