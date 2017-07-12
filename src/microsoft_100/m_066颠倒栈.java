package microsoft_100;

import java.util.Stack;

public class m_066颠倒栈 {

	/**
	 * 66.颠倒栈。
	题目：用递归颠倒一个栈。例如输入栈{1, 2, 3, 4, 5}，1 在栈顶。
	颠倒之后的栈为{5, 4, 3, 2, 1}，5 处在栈顶。
	 */
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		m_066颠倒栈 m = new m_066颠倒栈();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		System.out.println(s);
		m.recurse(s);
		System.out.println(s);

	}
	public void recurse(Stack<Integer> stack){
		if(stack.isEmpty())return;
		int a = stack.pop();
		recurse(stack);
		addToBottom(stack,a);
	}
	public void addToBottom(Stack<Integer> stack,Integer a){
		if(stack.isEmpty()){
			stack.push(a);
		}else{
			int top = stack.pop();
			addToBottom(stack, a);
			stack.push(top);
		}
	}
}
