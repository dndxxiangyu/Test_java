package microsoft_100;

import java.util.LinkedList;
import java.util.Queue;

public class Hanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> q3 = new LinkedList<Integer>();
		q1.offer(4);
		q1.offer(3);
		q1.offer(2);
		q1.offer(1);
//		q2.offer(3);
//		q3.offer(2);
		System.out.println(Math.pow(2, 3));
		System.out.println(new Hanoi().step(4, q1, q2, q3));
	}
	//三根柱子，盘子个数，n表示盘子最大，在最下面
	public int step(int n, Queue<Integer> q1, Queue<Integer> q2, Queue<Integer> q3){
		if(n>q1.size()+q2.size()+q3.size())throw new RuntimeException("hanoi number is wrong");
		if(n<=0)return 0;
		if(q1==null&&q2==null&&q3==null)return 0;
		if(q1.contains(n)){
			//如果是最大的数在第一列，则删除，递归返回
			//相当于第一列就剩最大的数，第二列为剩下n-1个，第三列为空
			//本来目标是第三根柱子，现在目标是第二个柱子
			q1.poll();//把最大的数删除
			Queue<Integer> temp = q2;
			q2 = q3;
			q3 = temp;
			return step(n-1,q1,q2,q3) + (int)Math.pow(2, n-1);
		}else if(q2.contains(n)){
			//交换1、2柱子，变更到上面的情况
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
			//删除最大
			q1.poll();
			//目标变成第二根
			temp = q2;
			q2 = q3;
			q3 = temp;
			return step(n-1,q1,q2,q3) + (int)Math.pow(2, n-1);
		}
		else if(q3.contains(n)){
			q3.poll();
			return step(n-1,q1,q2,q3);
		}
		return -1;
	}
}
