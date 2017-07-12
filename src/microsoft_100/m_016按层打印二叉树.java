package microsoft_100;

import java.util.LinkedList;
import java.util.Queue;

public class m_016按层打印二叉树 {

	/**
	 * 第16题
	 * 题目：输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
	 */
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
		new m_016按层打印二叉树().levelOrderByRow(root);
	}
	public void levelOrderByRow(BinaryNode<Integer> p){
		if(p==null)return;
		Queue<BinaryNode<Integer>> queue1 = new LinkedList<BinaryNode<Integer>>();
		Queue<BinaryNode<Integer>> queue2 = new LinkedList<BinaryNode<Integer>>();
		queue1.offer(p);
		while(!queue1.isEmpty()|| !queue2.isEmpty()){
			if(!queue1.isEmpty()){
				int len = queue1.size();
				for(int i=0;i<len;i++){
					BinaryNode<Integer> temp = queue1.poll();
					System.out.print(temp.data+" ");
					if(temp.left!=null)queue2.offer(temp.left);
					if(temp.right!=null)queue2.offer(temp.right);
				}
				System.out.println();
			}
			if(!queue2.isEmpty()){
				int len = queue2.size();
				for(int i=0;i<len;i++){
					BinaryNode<Integer> temp = queue2.poll();
					System.out.print(temp.data+" ");
					if(temp.left!=null)queue1.offer(temp.left);
					if(temp.right!=null)queue1.offer(temp.right);
				}
				System.out.println();
			}
		}
	}
	public void levelOrderByRow2(BinaryNode<Integer> p){
		if(p==null)return;
		Queue<BinaryNode<Integer>> queue = new LinkedList<BinaryNode<Integer>>();
		queue.offer(p);
		while(!queue.isEmpty()){
			int len = queue.size();
			for(int i=0;i<len;i++){
				BinaryNode<Integer> temp = queue.poll();
				System.out.print(temp.data+" ");
				if(temp.left!=null)queue.offer(temp.left);
				if(temp.right!=null)queue.offer(temp.right);
			}
			System.out.println();
		}
		
	}
	
	public void leverOrder(BinaryNode<Integer> root){
		BinaryNode<Integer> p = root;
		if(p==null)return;
		Queue<BinaryNode<Integer>> queue = new LinkedList<BinaryNode<Integer>>();
		queue.offer(p);
		while(!queue.isEmpty()){
			BinaryNode<Integer> temp = queue.poll();
		}
	}
}
