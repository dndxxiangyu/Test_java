package microsoft_100;

import java.util.Stack;

public class m_057用俩个栈实现队列 {

	/**
	 * 57.用俩个栈实现队列。 
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

	}

}
class Q{
	Stack<Integer> a;//in
	Stack<Integer> b;//out
	public Q(){
		this.a = new Stack<Integer>();
		this.b = new Stack<Integer>();
	}
	public void push(int i){
		a.push(i);
	}
	public int pop(){
		if(a.isEmpty()&&b.isEmpty())throw new RuntimeException();
		if(b.isEmpty()){
			while(!a.isEmpty()){
				b.push(a.pop());
			}
			return b.pop();
		}else{
			return b.pop();
		}
	}
	public boolean isEmpty(){
		return a.isEmpty()&&b.isEmpty();
	}
}