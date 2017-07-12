package microsoft_100;

import java.util.Stack;


public class m_075二叉树两个结点的最低共同父结点 {

	/**
	 * 75.二叉树两个结点的最低共同父结点
	 */
	public static void main(String[] args) {
		BinaryNode<Integer> p = new BinaryNode<Integer>(12);
		BinaryNode<Integer> a = new BinaryNode<Integer>(9);
		BinaryNode<Integer> b = new BinaryNode<Integer>(10);
		BinaryNode<Integer> c = new BinaryNode<Integer>(11);
		BinaryNode<Integer> d = new BinaryNode<Integer>(13);
		BinaryNode<Integer> e = new BinaryNode<Integer>(14);
		BinaryNode<Integer> f = new BinaryNode<Integer>(15);
		p.left = b;
		p.right = e;
		b.left = a;
		b.right = c;
		e.left = d;
		e.right = f;
		m_075二叉树两个结点的最低共同父结点 m=new m_075二叉树两个结点的最低共同父结点();
		System.out.println(m.get(p, 12));
		System.out.println(m.getLCA(p, 0, 9).data);
		
	}
	//我自己的想法，对二叉树进行非递归的后序遍历，然后遇到第一个节点，返回stack中的全部元素，然后遇到第二个元素，返回stack中的全部元素，
	//再对两个输出重头到位进行遍历
	public Stack<BinaryNode<Integer>> get(BinaryNode<Integer> a,int n){
		Stack<BinaryNode<Integer>> stack = new Stack<BinaryNode<Integer>>();
		if(a==null)return null;
		BinaryNode<Integer> p=a;
		BinaryNode<Integer> front = null;
		while(p!=null||!stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				if(p.data==n){
					return stack;
				}
				p = p.left;
			}else{
				p = stack.peek();
				if(p.right!=null&&p.right!=front){
					p = p.right;
				}else{
					p = stack.peek();
					front=p;
					p=null;
				}
			}
		}
		return null;
	}
	/**
	 * 得先处理a，b是不是在树中
	 */
	public BinaryNode<Integer> getLCA(BinaryNode<Integer> p,int a, int b){
		if(p==null)return null;
		if(p.data==a||p.data==b)return p;
		BinaryNode<Integer> left = getLCA(p.left, a, b);
		BinaryNode<Integer> right = getLCA(p.right,a,b);
		if(left==null){
			return right;
		}else if(right==null){
			return left;
		}else 
			return p;
	}
	/**
	 *  只要找到这样一个节点：
		已知的两个节点一个在它的左边子树，一个在它的右边子树；
		或者这个节点就是已知的两个节点中的一个，而另一个恰好在它的下面。
	 */
	public BinaryNode<Integer> getLCA2(BinaryNode<Integer> p,int a, int b){
		if(p==null)return null;
		if(p.data==a||p.data==b)return p;
		BinaryNode<Integer> left = getLCA2(p.left, a, b);
		BinaryNode<Integer> right = getLCA2(p.right,a,b);
		if(left!=null&&right!=null){
			return p;
		}
		if(left!=null)return left;
		if(right!=null)return right;
//		if(left==null&&right==null){
		return null;
//		}
	}
}
