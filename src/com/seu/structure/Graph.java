package com.seu.structure;

import java.util.ArrayList;

public class Graph {

	public static void main(String[] args) {
		
	}

}
class Edge implements Comparable<Edge>{
	public int start;
	public int dest;
	public int weight;
	public Edge(int tart,int dest,int weight){
		this.start=start;
		this.dest=dest;
		this.weight=weight;
	}
	public String toString(){
		return "("+start+","+dest+","+weight+")";
	}
	public int compareTo(Edge e) {
		if(this.start!=e.start){
			return this.start-e.start;
		}else
			return this.dest-e.dest;
	}
	
}
class MatrixGraph<E> {
	private ArrayList<E> vertexlist;
	private int[][] matrix;
	private final int MAX_WEIGHT=Integer.MAX_VALUE;
	public MatrixGraph(int n){
		this.vertexlist = new ArrayList<E>(n);//顶点
		this.matrix = new int[n][n];//邻接矩阵
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=(i==j)?0:MAX_WEIGHT;
			}
		}
	}
	
	
	public MatrixGraph(E[] vertices, Edge[] edges){
		this(vertices.length);
		for(int i=0;i<vertices.length;i++){
			insertVertex(vertices[i]);
		}
		for(int j=0;j<edges.length;j++){
			insertEdge(edges[j]);
		}
	}
	
	public MatrixGraph(ArrayList<E> list,Edge[] edges){
		this(list.size());
		this.vertexlist=list;
		for(int i=0;i<edges.length;i++){
			insertEdge(edges[i]);
		}
	}
	public int vertexCount(){
		return this.vertexlist.size();
	}
	public E get(int i){
		return this.vertexlist.get(i);
	}
	public boolean insertVertex(E  vertex){
		return this.vertexlist.add(vertex);
	}
	public boolean insertEdge(int i,int j,int weight){
		if(i>=0&&i<vertexCount()&&j>=0&&j<vertexCount()&&i!=j&&matrix[i][j]==MAX_WEIGHT){
			//如果这个边存在了，则不插入
			matrix[i][j]=weight;
			return true;
		}
		return false;
	}
	
	public boolean insertEdge(Edge edge){
		if(edge!=null){
			return insertEdge(edge.start,edge.dest,edge.weight);
		}
		return false;
	}
	
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("顶点集合："+vertexlist.toString()+'\n');
		sb.append("邻接矩阵：\n");
		int n=vertexCount();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==MAX_WEIGHT){
					sb.append(" ∞");
				}else{
					sb.append(" "+matrix[i][j]);
				}
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	//删除边
	public boolean removeEdge(int i, int j){
		if(i>=0&&i<vertexCount()&&j>=0&&j<vertexCount()&&i!=j&&matrix[i][j]!=MAX_WEIGHT){
			//如果这个边存在了，则不插入
			matrix[i][j]=MAX_WEIGHT;
			return true;
		}
		return false;
	}
	//删除顶点
	public boolean removeVertex(int v){
		int n=vertexCount();
		if(v>=0&&v<n){
			vertexlist.remove(v);
			for(int i=v;i<n-1;i++){
				for(int j=0;j<n;j++)
					matrix[i][j]=matrix[i+1][j];
			}
			for(int i=v;i<n-1;i++){
				for(int j=0;j<n;j++){
					matrix[i][j]=matrix[i][j+1];
				}
			}
			return true;
		}
		return false;
	}
	public int getFirsNeighbor(int v){
		return getNextNeighbor(v,-1);
	}
	public int getNextNeighbor(int v,int w){
		//返回v在w后的下一个邻接顶点
		if(v>=0&&v<vertexCount()&&w>=-1&&w<vertexCount()&&v!=w){
			for(int j=w+1;j<vertexCount();j++){//表示从第一列开始查找，如果找到则为第一个。
				if(matrix[v][j]>0&&matrix[v][j]<MAX_WEIGHT){
					return j;
				}
			}
		}
		return -1;
	}
	
	public void minTree(){
		Edge[] e = new Edge[vertexCount()-1];
		for(int i=0;i<e.length;i++){
			e[i] = new Edge(0,i+1,matrix[0][i+1]);
		}
		
		for(int i=0;i<e.length;i++){
			int minweight=Integer.MAX_VALUE;
			int min=i;
			for(int j=i;j<e.length;j++){
				if(e[j].weight<minweight){
					minweight=e[j].weight;
					min=j;
				}
			}
			Edge temp = e[i];
			e[i]=e[min];
			e[min]=temp;
			
			int u=e[i].dest;
			for(int j=i+1;j<e.length;j++){
				int v=e[j].dest;
				if(matrix[u][v]<e[j].weight){
					e[j].weight=matrix[u][v];
					e[j].start=u;
				}
			}
		}
	}
	
	public void shrtestPath(int v){
		int n = this.vertexCount();
		int[] s = new int[n];
		int[] path = new int[n];
		int[] dist = new int[n];
		
		s[v]=1;
		
		for(int i=0;i<n;i++){
			dist[i]=matrix[v][i];
			if(i!=v&&dist[i]<MAX_WEIGHT){
				path[i]=v;
			}else{
				path[i]=-1;
			}
		}
		
		for(int i=1;i<n;i++){
			int mindist = MAX_WEIGHT;
			int u=0;
			for(int j=0;j<n;j++){
				if(s[j]==0&&dist[j]<MAX_WEIGHT){
					mindist = dist[j];
					u=j;
				}
			}
			if(mindist == MAX_WEIGHT){
				return ;
			}
			s[u]=1;
			for(int j=0;j<MAX_WEIGHT;j++){
					if(s[j]==0&&matrix[u][j]<MAX_WEIGHT&&dist[u]+matrix[u][j]<dist[j]){
						dist[j]=dist[u]+matrix[u][j];
						path[j]=u;
					}
			}
		}
		System.out.println("从顶点"+get(v)+"到其他顶点的路径如下：");
		int i=v+1;
		while(i!=v){
			int j=i;
			String pathstr = "";
			while(path[j]!=-1){
				pathstr=","+get(j)+pathstr;
				j = path[j];
			}
			pathstr="("+get(v)+pathstr+"),路径长度为"+dist[i];
			System.out.println(pathstr);
			i=(i+1)%n;
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	
	}
	
}