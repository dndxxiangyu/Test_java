package yeheya;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
	static int a=2;
	public static void main(String[] args) {
		for(int i = 1; i<10;i++){
			if(i%2 == 0){
				break;
			}
			System.out.println(i);
		}
		get();
		java.util.Queue<String> queue = new LinkedList<String>();
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		queue.add("e");
		System.out.println(queue.size());
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		System.out.println(queue.size());
		System.out.println("********************************************");
		int[] table={1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(table));
		cc(table);
		System.out.println(Arrays.toString(table));
	}
	public static void cc(int[] table){
		int[] temp={4,4,4,4};
		for(int i=0;i<4;i++){
			table[i]=temp[i];
		}
		table = temp;
	}
	public static int get(){
		if(a<0)return -1;
		a--;
		System.out.println("a:"+a);
		get();
		
		return 10;
	}
	public static void put(){
		System.out.println("wrong");
		throw new RuntimeException();
	}
}
