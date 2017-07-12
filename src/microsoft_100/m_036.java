package microsoft_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class m_036 {

	/**
	 * 36.引用自网友：longzuo
	谷歌笔试：
	n支队伍比赛，分别编号为0,1,2...n-1，已知它们之间的实力对比关系，
	存储在一个二维数组w[n][n]中，w[i][j] 的值代表编号为i，j的队伍中更强的一支。
	所以w[i][j]=i 或者j，现在给出它们的出场顺序，并存储在数组order[n]中，
	比如order[n] = {4,3,5,8,1......}，那么第一轮比赛就是 4对3, 5对8........
	胜者晋级，败者淘汰，同一轮淘汰的所有队伍排名不再细分，即可以随便排，
	下一轮由上一轮的胜者按照顺序，再依次两两比，比如可能是4对5,直至出现第一名
	编程实现，给出二维数组w,一维数组order 和 用于输出比赛名次的数组result[n]，求出result。
	 */
	public static void main(String[] args) {
		int[][] w = {   
		        {0,1,2,3,0,0},   
		        {1,1,2,1,1,1},   
		        {2,2,2,2,2,2},   
		        {3,1,2,3,3,3},   
		        {0,1,2,3,4,5} 
		    }; 
		int[] order={1,3,4,2,0,5};
		new m_036().raceResult(w, order);
		
	}
	public int[] raceResult(int[][]w,int[] order){
		int len = order.length;
		int index = len-1;//填充result的下标
		int[] result = new int[len];
		List<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<len;i++){
			list.add(order[i]);
		}
		while(list.size()>1){
			int l = list.size();
			for(int i=0;i<l/2;i++){
				int a=list.get(i);
				int b=list.get(i+1);
				if(w[a][b]==a){
					result[index] = list.remove(i+1);
					index--;
					System.out.println(a+" kick "+b);
					
				}else{
					result[index] = list.remove(i);
					index--;
					System.out.println(b+" kick "+a);
				}
			}
		}
		result[0] = list.get(0);
		System.out.println(Arrays.toString(result));
		return result;
	}
}
