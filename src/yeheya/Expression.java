package yeheya;

import java.util.Stack;

public class Expression {

	/**
	 * 计算表达式的值
	 */
	public static void main(String[] args) {
		

	}
	public static int caculate(String expre){
		Stack<String> stack = new Stack<String>();
		StringBuilder back = new StringBuilder();
		int i = 0;
		while(i < expre.length()){
			char ch = expre.charAt(i);
			switch (ch) {
			case '+':
			case '-':
				while(!stack.isEmpty()&&!stack.peek().equals("(")){
					back.append(stack.pop());
				}
				stack.push(ch+"");
				i++;
				break;
			case '*':
			case '/':
				while(!stack.isEmpty()&&(stack.peek().equals("*")||stack.peek().equals("/"))){
					back.append(stack.pop());
				}
				stack.push(ch+"");
				i++;
				break;
			case '(':
				stack.push(ch+"");
				i++;
				break;
			case ')':
				while(!stack.peek().equals("(")){
					back.append(stack.pop());
				}
				i++;
				break;
			default:
				while(ch > '0'&& ch <'9'){
					back.append(ch+"");
					i++;
					if(i < expre.length()){
						ch = expre.charAt(i);
					}else{
						break;
					}
				}
				back.append(" ");
				break;
			}
		}
		return 0;
	}
}
