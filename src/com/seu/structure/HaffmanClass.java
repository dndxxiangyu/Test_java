package com.seu.structure;

public class HaffmanClass {
	
	public static void main(String[] args){
		int[] weight = {5,29,7,8,14,23,3,11};
		HaffmanTree h = new HaffmanTree(weight);
		System.out.println(h);
		String[] string = h.haffmanCode();
		for(int i = 0;i< weight.length;i++){
			System.out.println(string[i]);
		}
		
		AA[] a ={new AA(),new AA(),new AA()};
		System.out.println(a);
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
	}
}
class HaffmanNode{
	int weight;
	int parent,left,right;
	public HaffmanNode(int weight){
		this.weight=weight;
		this.parent=this.left=this.right=-1;
	}
	public HaffmanNode(){
		this(0);
	}
	public String toString(){
		return this.weight+","+this.parent+","+this.left+","+this.right;
	}
}

class HaffmanTree{
	private int leafNum;
	private HaffmanNode[] h;
	public HaffmanTree(int[] weight){
		int n = weight.length;
		leafNum=n;
		h = new HaffmanNode[2*leafNum-1];
		
		for(int i=0;i<n;i++){
			h[i] = new HaffmanNode(weight[i]);
		}
		for(int i=0;i<n-1;i++){
			int min1,min2,x1,x2;
			min1=min2=Integer.MAX_VALUE;
			x1=x2=-1;
			for(int j=0;j<n+i;j++){
				if(h[j].weight<min1&&h[j].parent==-1){
					min2=min1;
					x2=x1;
					min1=h[j].weight;
					x1=j;
				}else if(h[j].weight<min2&&h[j].parent==-1){
					min2=h[j].weight;
					x2=j;
				}
			}
			h[x1].parent=n+i;
			h[x2].parent=n+i;
			h[n+i] = new HaffmanNode();
			h[n+i].weight=h[x1].weight+h[x2].weight;
			h[n+i].left=x1;
			h[n+i].right=x2;//左小右大
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
class AA{
	
	@Override
	public String toString() {
		System.out.println("dd");
		return super.toString();
	}
	
	
	
}