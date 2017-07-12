package huawei;

import java.util.ArrayList;

public class QuestionFrom {
	static char c;
	public static void main(String[] args) {
		System.out.println("question --> 1:");
//		Apple apple = new Apple();
//		Banana banana = (Banana)apple;//不能强制转换
//		if(banana instanceof Banana){
//			System.out.println("banana is of Banana");
//		}else if(banana instanceof Apple){
//			System.out.println("banana is of Apple");
//		}
		System.out.println("question --> 3:");
		System.out.println(c);
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		ArrayList<String> array = new ArrayList<String>();
		array.add("cc1");
		array.add("cc2");
		arr.add(array);
		System.out.println(arr);
		Object[] object = new Object[0];
		System.out.println(object.length);
	}
	
}
class Apple{
	
}
class Banana extends Apple{
	
}