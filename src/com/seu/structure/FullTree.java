package com.seu.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FullTree {

	
	public static void main(String[] args) {
		ArrayList<Integer> s= new ArrayList<Integer>(0);
//		String[] e = {"a","b","d",null,"g",null,null,null,"c","e",null,null,"f","h"};
//		BinaryTree<String> tree = new BinaryTree<String>(e);
//		tree.preOrder();
//		tree.inOrder();
//		tree.postOrder();
//		BinaryNode<Integer> node = new BinaryNode<Integer>(null);
//		node=null;
//		if(node==null)System.out.println("xxxxxx");
//		tree.inOrderTraverse();
//		tree.preOrderTraverse();
//		tree.postOrderTraverse();
//		tree.levelOrder();
		HashSet<CC> a = new HashSet<CC>();
		CC c1 = new CC(11,"xx");
		CC c2 = new CC(12,"xx1");
		CC c3 = new CC(13,"xx2");
		a.add(c1);
		a.add(c2);
		a.add(c3);
//		if(c1.equals(c2)){
//			
//		}
	}

}
class ComTree<E>{
	Object[] array;
	int n;
	public ComTree(int n){
		if(n==0)n=1;
		this.n=0;
		array=new Object[Math.abs(n)];
	}
	public ComTree(){
		this(10);
	}
	
	public boolean add(E element){ 
		if(element==null)return false;
		if(n==array.length){
			Object[] temp = array;
			array=new Object[2*temp.length];
			for(int i=0;i<temp.length;i++){
				array[i]=temp[i];
			}
		}
		array[n]=element;
		n++;
		return true;
	}
	
	public int height(){
		if(n==0)return 0;
		return (int) (Math.log(n)/Math.log(2))+1;
	}
}



//8888888888888888888888888888888888888888888888888
class BinaryNode<E>{
	E data;
	BinaryNode<E> left,right;
	public BinaryNode(E data,BinaryNode<E> left,BinaryNode<E> right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
	public BinaryNode(E data){
		this(data,null,null);
	}
	
}
class BinaryTree<E>{
	BinaryNode<E> root;
	private int i=0;
	
	public BinaryTree(){
		root=null;
	}
	public BinaryTree(BinaryNode<E> root){
		this.root=root;
	}
	public BinaryTree(E[] p){
		root=create(p);
	}
	public void preOrder(){
		preOrder(root);
		System.out.println();
	}
	private void preOrder(BinaryNode<E> p){
		if(p!=null){
			System.out.print(p.data+"");
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	public void inOrder(){
		inOrder(root);
		System.out.println();
	}
	private void inOrder(BinaryNode<E> p){
		if(p!=null){
			inOrder(p.left);
			System.out.print(p.data+"");
			inOrder(p.right);
		}
	}
	public void postOrder(){
		postOrder(root);
		System.out.println();
	}
	private void postOrder(BinaryNode<E> p){
		if(p!=null){
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data+"");
		}
	}
	
	public int height(){
		return height(root);
	}
	public int height(BinaryNode<E> p){
		if(p!=null){
			int ld=height(p.left);
			int rd=height(p.right);
			return (ld>=rd)?ld+1:rd+1;
		}
		return 0;
	}
	
	public int count(){
		return count(root);
	}
	public int count(BinaryNode<E> p){
		if(p!=null){
			return count(p.left)+count(p.right)+1;
		}
		return 0;
	}
	public BinaryNode<E> search(E element){
		return search(root,element);
	}
	private BinaryNode<E> search(BinaryNode<E> p,E element){
		BinaryNode<E> find =null;
		if(p!=null&&element!=null){
			if(p.data.equals(element)){
				find=p;
			}else{
				find=search(p.left,element);
				if(find==null)
					search(p.right,element);
			}
		}
		return find;
	}
	
	public BinaryNode<E> getParent(BinaryNode<E> node){
		if(node==null)return null;
		return getParent(root,node);
	}
	public BinaryNode<E> getParent(BinaryNode<E> p,BinaryNode<E> node){
		if(p==null||node==root||node==null){
			return null;
		}
		BinaryNode<E> find=null;
		if(p.left==node||p.right==node){
			find=p;
		}else{
			find=getParent(p.left,node);
			if(find==null)
				find=getParent(p.right, node);
		}
		return find;
	}
	
	public BinaryNode<E> create(E[] pro){
		BinaryNode<E> p=null;
		if(i<pro.length){
			E elem=pro[i];
			i++;
			if(elem!=null){
				p=new BinaryNode<E>(elem);
				p.left=create(pro);
				p.right=create(pro);
			}
		}
		return p;
	}
	
	public void insert(BinaryNode<E> p,E element, boolean leftChild){
		if(p!=null&&element!=null){
			if(leftChild){
				p.left=new BinaryNode<E>(element,p.left,null);
			}else{
				p.right=new BinaryNode<E>(element,null,p.right);
			}
		}
	}
	
	public void remove(BinaryNode<E> p,boolean leftChild){
		if(p!=null){
			BinaryNode<E> node=null;
			if(leftChild){
				node=p.left;
				clear(p.left);
				p.left=null;//其实不是最完美的，要写一个函数，把左右的都打断，这样最后的叶子节点不会有上一层的引用。
			}else{
				node=p.right;
				clear(p.right);
				p.right=null;
			}
		}
	}
	
	public void clear(BinaryNode<E> node){
		BinaryNode<E> left=null;
		BinaryNode<E> right=null;
		if(node!=null){
			left=node.left;
			node.left=null;
			clear(left);
			right=node.right;
			node.right=null;
			clear(right);
		}
	}
	
	public void inOrderTraverse(){
		System.out.println("中根次序遍历-非递归");
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();
		BinaryNode<E> p = this.root;
		while(p!=null||!stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				p=p.left;
			}else{
				p=stack.pop();
				System.out.print(p.data+"");
				p=p.right;
			}
		}
	}
	
	public void preOrderTraverse(){
		System.out.println("\n先根次序遍历-非递归");
		ArrayList<BinaryNode<E>> a = new ArrayList<BinaryNode<E>>();
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();
		BinaryNode<E> p = root;
		while(p!=null||!stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				System.out.print(p.data+"");
				p=p.left;
			}else{
				p=stack.pop();
				p=p.right;
			}
		}
	}
	
	public void postOrderTraverse(){
		System.out.println("\n后根次序遍历-非递归");
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();
		BinaryNode<E> p = root,prev=root;
		while(p!=null||!stack.isEmpty()){
			while(p!=null){
				stack.push(p);
				p=p.left;
			}
			if(stack.size()>0){
				BinaryNode<E> temp=stack.peek().right;
				if(temp==null||temp==prev){
					p=stack.pop();
					System.out.print(p.data+"");
					prev=p;
					p=null;
				}else{
					p=temp;
				}
			}
		}
	}
	
	public void levelOrder(){
		Queue<BinaryNode<E>> queue = new LinkedList<BinaryNode<E>>();
		BinaryNode<E> p = root;
		System.out.println("\n层次遍历：");
		while(p!=null){
			System.out.print(p.data+"");
			if(p.left!=null){
				queue.add(p.left);
			}
			if(p.right!=null){
				queue.add(p.right);
			}
			p=queue.poll();  
		}
	}
}

class ThreadBinaryNode<E>{
	E data;
	public ThreadBinaryNode<E> left,right;
	public int rtag,ltag;
	
	public ThreadBinaryNode(E data,ThreadBinaryNode<E> left,ThreadBinaryNode<E> right){
		this.data=data;
		this.left=left;
		this.right=right;
		this.rtag=0;
		this.ltag=0;
	}
	public ThreadBinaryNode(E data){
		this(data,null,null);
	}
	public ThreadBinaryNode(){
		this(null,null,null);
	}
	
}
class ThreadBinaryTree<E>{
	ThreadBinaryNode<E> root;
	private int i=0;
	private ThreadBinaryNode<E> front=null;
	
	public ThreadBinaryTree(){
		root=null;
	}
	public ThreadBinaryTree(E[] preorder){
		root=create(preorder);
		inorderThread(root);
	}
	public ThreadBinaryNode<E> create(E[] preorder){
		ThreadBinaryNode<E> p=null;
		if(i<preorder.length){
			E elem = preorder[i];
			i++;
			if(elem!=null){
				p=new ThreadBinaryNode<E>(elem);
				p.left=create(preorder);
				p.right=create(preorder);
			}
		}
		return p;
	}
	public void inorderThread(ThreadBinaryNode<E> p){
		if(p!=null){
			inorderThread(p.left);
			if(p.left==null){
				p.ltag=1;
				p.left=front;
			}
			if(p.right==null){
				p.rtag=1;
			}
			if(front!=null&&front.rtag==1){
				front.right=p;
			}
			front=p;
			inorderThread(p.right);
		}
	}
	
	public ThreadBinaryNode<E> inNext(ThreadBinaryNode<E> p){
		if(p.rtag==1)
			p=p.right;
		else{
			p=p.right;
			while(p.ltag==0){
				p=p.left;
			}
		}
		return p;
	}
	
	public void inOrder(){
		ThreadBinaryNode<E> p=root;
		if(p!=null){
			System.out.println("中根次序遍历：");
			while(p.ltag==0)
				p=p.left;
			do{
				System.out.print(p.data+"");
				p=inNext(p);
			}while(p!=null);
			System.out.println();
		}
	}
	public ThreadBinaryNode<E> inBefore(ThreadBinaryNode<E> p){
		if(p.ltag==1)
			return p.left;
		else{
			p=p.left;
			while(p.rtag==0){
				p=p.right;
			}
		}
		return p;
	}
	public void inOrder2(){
		ThreadBinaryNode<E> p = root;
		if(p!=null){
			System.out.println("中根次序遍历：");
			while(p.rtag==0){
				p=p.right;
			}
			do{
				System.out.print(p.data+"");
				p=inBefore(p);
			}while(p!=null);
			System.out.println();
		}
	}
}
class CC{
	int age;
	String name;
	public CC(int age, String name){
		this.age=age;
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println(this.name+":调用equals，想用什么方式比较自己写");
        CC p = (CC)obj;
        return this.age==p.age?true:false;

	}
	@Override
	public int hashCode() {
		
		System.out.println(this.name+"：先调用hashCode,想用什么方式比较自己写,若想同，再调用equals");
        return age;

	}
}