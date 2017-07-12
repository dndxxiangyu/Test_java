package microsoft_100;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;


public class TreeTest {
	/**
	 * 		 a
	 * 	   /   \
	 *    b     d
	 *     \    /
	 *      c  e
	 *        / 
	 *       f
	 */
	public static void main(String[] args) {
		String[] ss = {"a","b",null,"c",null,null,"d","e","f"};
		BinaryTree<String> tree = new BinaryTree<String>(ss);
		tree.inOrder();
		tree.postOrder();
		tree.postOrder2();
		tree.preOrder2();
		tree.preOrder();
		tree.inOrder2();
		String[] prelist = {"a","b","d","g","c","e","f","h"};
		String[] inlist = {"d","g","b","a","e","c","h","f"};
		BinaryTree<String> b = new BinaryTree<String>(prelist,inlist);
		b.inOrder();
		System.out.println(b.contains(b.root.left, "d"));
		b.getParents("d");
		System.out.println("height:"+b.height());
		b.levelOrder();
		tree.levelOrder();
	}

}

class BinaryNode<E>{
	BinaryNode<E> left;
	BinaryNode<E> right;
	E data;
	public BinaryNode(BinaryNode<E> left, E data, BinaryNode<E> right){
		this.left = left;
		this.data = data;
		this.right = right;
	}
	public BinaryNode(E data){
		this(null,data,null);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data.toString();
	}
}
//二叉树的二叉链表实现，只有两条链，指向两个孩子。
class BinaryTree<E>{
	BinaryNode<E> root;
	private int i;
	public BinaryTree(){
		this.root = null;
	}
	public BinaryTree(BinaryNode<E> root){
		this.root = root;
	}
	
	//标明空指数的先根序列表示
	//在先根遍历中标明空子树，通过空子树位置反映兄弟节点之间的左右次序，可唯一确定一颗二叉树。
	public BinaryTree(E[] prelist){
		this.root = create(prelist);
	}
	//先根+中根构造二叉树
	public BinaryTree(E[] prelist, E[] inlist){
		this.root = create(prelist,inlist,0,0,prelist.length);
	}
	/**
	 * 
	 * 记不牢
	 */
	private BinaryNode<E> create(E[] prelist){
		BinaryNode<E> p = null;
		if(i < prelist.length){
			E elem = prelist[i];
			i++;
			if(elem != null){
				p = new BinaryNode<E>(elem);
				p.left = create(prelist);
				p.right = create(prelist);
			}
		}
		return p;
	}
	
	private BinaryNode<E> create(E[] prelist, E[] inlist, int preStart, int inStart, int n){
		if(n <= 0)return null;
		E elem = prelist[preStart];
		BinaryNode<E> p = new BinaryNode<E>(elem);
		int i = 0;
		while(i < n && !elem.equals(inlist[inStart + i])){
			i++;
		}
		if(i==n)
			throw new IllegalArgumentException("prelist & inlist are wrong");
		p.left = create(prelist, inlist, preStart + 1, inStart, i);
		p.right = create(prelist, inlist, preStart + i + 1, inStart + i + 1, n-1-i);
		return p;
	}
	
	//节点个数：
	public int count(){
		return count(root);
	}
	public int count(BinaryNode<E> p){
		if(p == null)return 0;
		return count(p.left) + count(p.right) + 1;
	}
	
	//树高度
	public int height(){
		return height(root);
	}
	public int height(BinaryNode<E> p){
		if(p != null){
			int ld = height(p.left);
			int rd = height(p.right);
			return ld > rd? ld + 1: rd + 1;
		}
		return 0;
	}
	//查找
	public BinaryNode<E> search(E element){
		return search(root,element);
	}
	public BinaryNode<E> search(BinaryNode<E> p, E element){
		if(p == null || element == null)return null;
		if(p.data.equals(element))return p;
		BinaryNode<E> find = search(p.left,element);
		if(find == null){
			find = search(p.right,element);
		}
		return find;
	}
	public boolean contains(BinaryNode<E> p,E element){
		return search(p,element) !=	null;
	}
	//父母节点
	public BinaryNode<E> getParent(BinaryNode<E> node){
		if(root == null || node == null || node == root)return null;
		return getParent(root,node);
	}
	public BinaryNode<E> getParent(BinaryNode<E> p, BinaryNode<E> node){
		if(p == null)return null;
		if(p.left == node || p.right == node)return p;
		BinaryNode<E> find = getParent(p.left, node);
		if(find == null){
			find = getParent(p.right, node);
		}
		return find;
	}
	public boolean isEmpty(){
		return this.root == null;
	}
	//得到全部的父节点
	public void getParents(E p){
		if(p==null)return;
		BinaryNode<E> temp = root;
		if(p.equals(temp.data))return;
		while(temp!=null){
			if(this.contains(temp.left,p)){
				System.out.print(temp.data+"--");
				temp = temp.left;
				if(p.equals(temp.data))return;
			}else if(this.contains(temp.right,p)){
				System.out.print(temp.data+"=");
				temp = temp.right;
				if(p.equals(temp.data))return;
			}
		}
	}
	//插入
	public boolean insert(BinaryNode<E> p, E element, boolean leftChild){
		if(p == null || element == null)return false;
		//得先查找p是否在树中。
		if(leftChild){
			p.left = new BinaryNode<E>(p.left, element, null);
		}else{
			p.right = new BinaryNode<E>(null, element, p.right);
		}
		return true;
	}
	public void clear(BinaryNode<E> node){
		BinaryNode<E> left = null;
		BinaryNode<E> right = null;
		if(node != null){
			left = node.left;
			node.left = null;
			clear(left);
			right = node.right;
			node.right = null;
			clear(right);
		}
	}
	//Preorder traversal 先根遍历,递归
	public void preOrder(){
		System.out.println("先根次序遍历树：");
		preOrder(root);
		System.out.println();
	}
	public void preOrder(BinaryNode<E> p){
		if(p != null){
			System.out.print(p.data.toString()+" ");
			preOrder(p.left);
			preOrder(p.right);
		}
	}
	
	//Inorder traversal 中序遍历,递归
	public void inOrder(){
		System.out.println("中根次序遍历树：");
		inOrder(root);
		System.out.println();
	}
	public void inOrder(BinaryNode<E> p){
		if(p != null){
			inOrder(p.left);
			System.out.print(p.data.toString()+" ");
			inOrder(p.right);
		}
	}
	
	//Postorder traversal  后序遍历,递归
	public void postOrder(){
		System.out.println("后根次序遍历树：");
		postOrder(root);
		System.out.println();
	}
	public void postOrder(BinaryNode<E> p){
		if(p != null){
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data.toString()+" ");
		}
	}
	
	//非递归 先根遍历
	public void preOrder2(){
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();
		BinaryNode<E> p = root;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				System.out.print(p.data);
				p = p.left;
			}else{
				p = stack.pop();
				p = p.right;
			}
		}
	}
	//非递归 中根遍历
	public void inOrder2(){
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();
		BinaryNode<E> p = root;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				System.out.print(p.data);
				p = p.right;
			}
		}
	}
	//非递归 后根遍历
	public void postOrder2(){
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();
		BinaryNode<E> p = root;
		//标记最近出栈的节点，用于判断是不是p节点的右孩子，如果是的话，就可以访问p节点
		BinaryNode<E> prev = root;
		while(p != null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.peek();
				if(p.right != null && p.right != prev){
					p = p.right;
				}else{
					p = stack.pop();
					System.out.print(p.data);
					prev = p;
					p = null;
				}
			}
			
		}
	}
	public void levelOrder2(){
		Queue<BinaryNode<E>> queue = new LinkedList<BinaryNode<E>>();
		BinaryNode<E> p = root;
		while(p != null){
			System.out.print(p.data + " ");
			if(p.left != null){
				queue.add(p.left);
			}
			if(p.right != null){
				queue.add(p.right);
			}
			p = queue.poll();
		}
		
	}
	//一层一层输出，用两个列表
	public void levelOrder(){
		Queue<BinaryNode<E>> queue1 = new LinkedList<BinaryNode<E>>();
		Queue<BinaryNode<E>> queue2 = new LinkedList<BinaryNode<E>>();
		BinaryNode<E> t =root;
		queue1.add(root);
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			if(queue1.isEmpty()){
				int len = queue2.size();
				for(int i=0;i<len;i++){
					t = queue2.poll();
					if(t.left!=null)queue1.add(t.left);
					if(t.right!=null)queue1.add(t.right);
					System.out.print(t.data+" ");
				}
				System.out.println();
			}
			if(queue2.isEmpty()){
				int len = queue1.size();
				for(int i=0;i<len;i++){
					t = queue1.poll();
					if(t.left!=null)queue2.add(t.left);
					if(t.right!=null)queue2.add(t.right);
					System.out.print(t.data+" ");
				}
				System.out.println();
			}
//			System.out.println("queue1:"+queue1.size());
//			System.out.println("queue2:"+queue2.size());
		}
	}
	public String toString(){
		return null;
	}
}

//对一颗二叉树继续遍历操作，所访问的节点构成一个线性序列，根据线性序列，可以获得一个节点的前驱和后继节点。


//原有的非空的链保持不变，仍然指向该节点的左右孩子节点，2n/n-1,使空的left域指向前驱节点，空的right域指向后继节点。
//线索化：对二叉树以某种次序进行遍历并加上线索的过程叫线索化。
class ThreadNode<E>{
	E data;
	ThreadNode<E> left,right;
	int ltag,rtag;
	
	public ThreadNode(E data){
		this(0,null,data,null,0);
	}
	public ThreadNode(int ltag, ThreadNode<E> left, E data, ThreadNode<E> right, int rtag){
		this.data = data;
		this.left = left;
		this.right = right;
		this.ltag = ltag;
		this.rtag = rtag;
	}
}

class ThreadBinaryTree<E>{
	ThreadNode<E> root;
	int i;
	private ThreadNode<E> front=null;
	public ThreadBinaryTree(){
		this.root = null;
	}
	public ThreadBinaryTree(E[] preorder){
		this.root = create(preorder);
		
	}
	public ThreadNode<E> create(E[] preorder){
		ThreadNode<E> p=null;
		if(i<preorder.length){
			E elem = preorder[i];
			i++;
			if(elem!=null){
				p=new ThreadNode<E>(elem);
				p.left=create(preorder);
				p.right=create(preorder);
			}
		}
		return p;
	}
	public void inorderThread(ThreadNode<E> p){
		if(p != null){
			inorderThread(p.left);
			if(p.left == null){
				p.ltag = 1;
				p.left = front;//拉起左边的线
			}
			if(p.right == null){
				p.rtag = 1;
			}
			if(front != null && front.rtag == 1){
				front.right = p;//拉起右边的线
			}
			front = p;
			inorderThread(p.right);
		}
	}
	public boolean isEmpty(){
		return root == null;
	}
	
}




class HaffmanNode{
	int weight;
	int parent,left,right;
	public HaffmanNode(int weight){
		this(weight, -1, -1 ,-1);
	}
	public HaffmanNode(int weight, int parent, int left, int right){
		this.right = right;
		this.left = left;
		this.weight = weight;
		this.parent = parent;
	}
	public HaffmanNode(){
		this(0);
	}
	public String toString(){
		return this.weight+","+this.parent+","+this.left+","+this.right;
	}
}
//Huffman编码
class HaffmanTree{
	private int leafNum;
	private HaffmanNode[] h;
	public HaffmanTree(int[] weight){
		int n = weight.length;
		leafNum=n;
		h = new HaffmanNode[2*leafNum-1];
		
		for(int i=0;i<n;i++){
			h[i] = new HaffmanNode(weight[i]);//初始化数组前n个
		}
		for(int i = 0; i < n-1; i++){
			int min1 =Integer.MAX_VALUE;
			int min2 = Integer.MAX_VALUE;//相当于一个二维数组，第一个放最小min1，第二个放min2;
			int x1 = -1, x2 = -1;
			for(int j = 0; j < n + i; j++){
				if(h[j].weight < min1 && h[j].parent == -1){
					min2 = min1;
					x2 = x1;
					x1 = h[j].weight;
					x1 = j;
				}else if(h[j].weight < min2 && h[j].parent == -1){
					min2 = h[j].weight;
					x2 = j;
				}
				h[x1].parent = n + i;
				h[x2].parent = n +i;
				h[n + i] = new HaffmanNode(h[x1].weight + h[x2].weight, -1, x1, x2);
			}
		}
		
		
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<h.length;i++){
			sb.append(i+","+h[i].weight+","+h[i].left+","+h[i].right+'\n');
		}
		return sb.toString();
	}
	
	public String[] haffmanCode(){
		String[] code = new String[leafNum]; 
		for(int i = 0;i < leafNum;i++){
			code[i] = "";
			int child = i;
			int parent = h[child].parent;
			while(parent!=-1){
				if(h[parent].left==child){
					code[i]="0"+code[i];
				}else{
					code[i]="1"+code[i];
				}
				child=parent;
				parent=h[child].parent;
			}
		}
		return code;
	}
}
class BinarySortTree{
	BinaryNode<Integer> root ;
	public BinaryNode<Integer> search(Integer integer){
		if(integer ==null)return null;
		BinaryNode<Integer> p = root;
		while(p!=null){
			if(p.data==integer)return p;
			if(p.data> integer){
				p = p.left;
			}else{
				p = p.right;
			}
		}
		return p;
	}
	public void insert(Integer integer){
		if(integer == null)return;
		if(root == null){
			root = new BinaryNode<Integer>(integer);
		}else{
			BinaryNode<Integer> p = root;
			BinaryNode<Integer> parent = root;
			while(p!=null){
				if(p.data == integer)return;
				parent = p;
				if(integer >p.data){
					p = p.right;
				}else{
					p = p.left;
				}
			}
			p = new BinaryNode<Integer>(integer);
			if(p.data<parent.data){
				parent.left = p;
			}else{
				parent.right = p;
			}
		}
	}
	public BinaryNode<Integer> remove(Integer integer){
		if(integer == null||root ==null)return null;
		
		return remove(integer,root,null);
	}
	public BinaryNode<Integer> remove(Integer integer, BinaryNode<Integer> p ,BinaryNode<Integer> parent){
		if(p==null)return null;
		if(p.left.data<integer)return remove(integer,p.right,p);
		if(p.left.data>integer)return remove(integer,p.left,p);
		if(p.left!=null&&p.right!=null){//找后继结点
			BinaryNode<Integer> in = p.right;
			while(in.left!=null){
				in = in.left;
			}
			p.data = in.data;
			return remove(p.data,p.right,p);
		}
		if(parent==null){
			if(p.left!=null)
				root = p.left;
			else
				root = p.right;
			return p;
		}
		if(p==parent.left){
			if(p.left!=null)
				parent.left = p.left;
			else
				parent.left = p.right;
		}else{
			if(p.left!=null)
				parent.right = p.left;
			else
				parent.right = p.right;
		}
		return p;
	}
	public BinaryNode<Integer> getDoubleLinked(BinaryNode<Integer> root){
		
		return root;
	}
}