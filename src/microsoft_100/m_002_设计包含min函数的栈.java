package microsoft_100;

import java.util.Arrays;

public class m_002_设计包含min函数的栈 {

	/**
	 *  设计包含min函数的栈。
	 *	定义栈的数据结构，要求添加一个min函数，能够得到栈的最小元素。
	 *	要求函数min、push以及pop的时间复杂度都是O(1)。
	 */
	public static void main(String[] args) {
		S s = new S();
		s.push(1);
		s.pop();
		s.push(10);
		s.push(4);
		s.push(6);
		s.push(7);
		s.push(5);
		s.push(1);
		System.out.println(s.len);
		System.out.println(s.i);
		System.out.println(s.temp[s.i]);
		System.out.println(Arrays.toString(s.data));
		System.out.println(Arrays.toString(s.temp));
	}

}
class S{
	int[] data = new int[100];//存放数据的数组
	int len=0;
	int[] temp = new int[10];//存放最小值的列表
	int i=-1;
	public S(){
		for(int i=0;i<temp.length;i++){
			temp[i] = -1;
		}
	}
	public void push(int in){
		data[len] = in;
		len++;
		if(i==-1){
			i=0;
			temp[i] = in;
		}else{
			if(temp[i] >= in){//一定要是这样的
				i++;
				temp[i]=in;
			}
		}
	}
	public int pop(){
		if(len==0)return -1;
		int l = len;
		len--;
		if(data[l-1]==temp[i]){
			temp[i] = -1;
			i--;
		}
		return data[len];
	}
	public int min(){
		if(i==-1)return -1;
		return temp[i];
	}
}