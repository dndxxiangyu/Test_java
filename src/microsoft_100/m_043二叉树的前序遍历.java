package microsoft_100;

import java.util.Stack;

public class m_043二叉树的前序遍历 {

	/**
	 * 43.递归和非递归俩种方法实现二叉树的前序遍历
	 */
	public static void main(String[] args) {
		
	}
	public void preOrder(BinaryNode<Integer> p){
		if(p==null)return;
		if(p!=null){
			System.out.println(p.data);
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	public void preOrder2(BinaryNode<Integer> p){
		if(p==null)return;
		BinaryNode<Integer> t = p;
		Stack<BinaryNode<Integer>> stack = new Stack<BinaryNode<Integer>>();
		while(p!=null || !stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				System.out.print(p.data);
				p = p.left;
			}else{
				p = stack.pop();
				p = p.right;
			}
		}
	}
}
