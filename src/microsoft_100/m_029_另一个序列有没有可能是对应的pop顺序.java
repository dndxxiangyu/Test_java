package microsoft_100;

import java.util.Stack;

public class m_029_另一个序列有没有可能是对应的pop顺序 {

	/**
	 * 29.栈的push、pop序列
	 * 题目：输入两个整数序列。其中一个序列表示栈的push顺序，
	 * 判断另一个序列有没有可能是对应的pop顺序。
	 */
	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
		int[] pop = {1,2,5,4,3};
		System.out.println(new m_029_另一个序列有没有可能是对应的pop顺序().isPop2(push, pop));
		new m_029_另一个序列有没有可能是对应的pop顺序().isPop2(push, pop);
	}
	//0 2 n-1
//	public boolean isPop(int[] push, int[] pop, Stack<Integer> stack){
//		//first make sure pop's quicksort is the same of push
//		int len = push.length;
//		int i=0,j=0;//i表示push下标,j表示pop下标
//		while(i<len){
//			stack.push(push[i]);
//			i++;
//			while(!stack.isEmpty() && stack.peek()==pop[j]){
//				stack.pop();
//				j++;
//			}
//		}
//		
//		if(stack.isEmpty()&&j==len){
//			return true;
//		}
//		return false;
//	}
	public boolean isPop2(int[] push, int[] pop){
		Stack<Integer> stack = new Stack<Integer>();
		int i=0;//push的下标
		int j=0;
		int len = push.length;
		int len2 = pop.length;
		if(len!=len2)return false;
		while(i<len){
			stack.push(push[i]);
			i++;
			while(!stack.isEmpty() && stack.peek()==pop[j]){
				stack.pop();
				j++;
			}
		}
		if(stack.isEmpty()&&j==len){
			return true;
		}
		return false;
	}
//	public boolean isPop(int[] push, int[] pop){
//		Stack<Integer> stack = new Stack<Integer>();
//		int i=0,pushNum=0;//i表示pop下标
//		int len = push.length;
//		while(i<len){
//			while(stack.isEmpty() || stack.peek()!=pop[i]){
//				if(pushNum < len){
//					stack.push(push[i]);
//					pushNum ++;
//				}else{
//					return false;
//				}
//			}
//			if(!stack.isEmpty() && stack.peek()==pop[i]){
//				stack.pop();
//				i++;
//			}
//		}
//		return true;
//	}


}
