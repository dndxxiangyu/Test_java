package microsoft_100;

import java.util.ArrayList;
import java.util.Stack;

public class m_004_root到叶子的和为常数 {

	/**
	 * 当访问到某一结点时，把该结点添加到路径上，并累加当前结点的值。
	 * 如果当前结点为叶结点并且当前路径的和刚好等于输入的整数，则当前的路径符合要求，我们把它打印出来
	 * 		12
	 * 		/ \
	 * 	  10   14
	 *    /\   /\
	 *   9 11 13 15
	 * 功能：也可以计算有多少个叶子节点
	 */
	BinaryNode<Integer> root;
	public static void main(String[] args) {
		//节点类在m_001中
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
		m_004_root到叶子的和为常数 m = new m_004_root到叶子的和为常数();
		m.root = root;
//		m.get();
		m.get(33);
		System.out.println("*****");
		m.get2(33);
	}
	public void getRoad(BinaryNode<Integer> p, int num){
		Stack<BinaryNode<Integer>> arr = new Stack<BinaryNode<Integer>>();
		int realNum=0;//从根到当前节点的数据
		if(p!=null && p.data<=num){
				arr.add(p);
				realNum += p.data;
		}
		//把左节点都放入arr中
		while(p!=null && p.data<=realNum){
			if(p!=null){
				arr.add(p);
				realNum += p.data;
				p = p.left;
			}
		}
		
	}
	//改变与后根遍历，得到全部的叶子节点到根的链表；
	public void get(int num){
		Stack<BinaryNode<Integer>> stack = new Stack<BinaryNode<Integer>>();
		BinaryNode<Integer> p = root;
		//标记最近出栈的节点，用于判断是不是p节点的右孩子，如果是的话，就可以访问p节点
		BinaryNode<Integer> prev = root;
		int number = 0;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				number = number+p.data;
				p = p.left;
			}else{
				p = stack.peek();//取出节点，如果是叶子则输出。
				if(p.left==null&&p.right==null&&number==num){
					System.out.println(stack);
				}
				if(p.right != null && p.right != prev){
					p = p.right;
				}else{
					p = stack.pop();
					number = number-p.data;
					prev = p;
					p = null;
				}
			}
			
		}
	}
	//得到给定值的链表。
	public void get2(int num){
		int realNum = 0;
		Stack<BinaryNode<Integer>> stack = new Stack<BinaryNode<Integer>>();
		BinaryNode<Integer> p = root;
		//标记最近出栈的节点，用于判断是不是p节点的右孩子，如果是的话，就可以访问p节点
		BinaryNode<Integer> prev = root;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				if(p.data<=num-realNum){
					realNum += p.data;
					stack.push(p);
					p = p.left;
				}else{
					p=null;
				}
			}else{
				if(stack.isEmpty())return;
				p = stack.peek();
				if(p.left==null&&p.right==null && realNum==num){
					System.out.println(stack);
				}
				if(p.right != null && p.right != prev&&p.data<=num-realNum){
					p = p.right;
					System.out.println("p:"+p.data);
				}else{
					p = stack.pop();
					realNum -= p.data;
					prev = p;
					p = null;
					System.out.println("cc");
				}
			}
			
		}
	}
}
