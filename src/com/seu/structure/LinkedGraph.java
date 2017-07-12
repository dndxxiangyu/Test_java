package com.seu.structure;

import java.util.LinkedList;

public class LinkedGraph {

	
	public static void main(String[] args) {

	}

}
class Vertex<E>{
	public E data;
	public LinkedList<Edge> edge;
	public Vertex(E data,LinkedList<Edge> edge){
		this.data=data;
		this.edge=edge;
	}
	public Vertex(E data){
		this(data,new LinkedList<Edge>());
	} 
	public String toString(){
		return this.data.toString();
	}
	
	
}
class LinkGraph{
	
}