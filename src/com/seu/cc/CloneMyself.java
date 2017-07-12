package com.seu.cc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Tank implements Cloneable{
    int color;
    int age;
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	
    	return super.clone();
    }
}

public class CloneMyself{
	int i;
	char cc;
	public static void main(String[] args) throws CloneNotSupportedException{
//		CloneChild a = new CloneChild();
//		System.out.println(a.getName());
//		CloneFather b = new CloneChild();
//		System.out.println(b.getName());
//		E e = new E("xxxxx");
//		System.out.println(e.name);
//		e.getS();
//		String s = "hello";
//		String t = "hello";
//		String str = "hello";
//		char c[] = {'h','e','l','l','o'};
//		char ch[] = str.toCharCloneFatherrray();
//		System.out.println("ch==c:"+(ch==c));
//		if(ch.equals(c)){
//			System.out.println("true");
//		}	
//		Integer a =  new Integer(11);
//		Integer b = new Integer(11);
//		System.out.println("a==b:"+(a==b));
//		int c = new Integer(11);
//		int d = new Integer(11);
//		System.out.println("c==d:"+(c==d));
//		String s = "a"+"b"+"c";
//		String s1= new String("777");
//		String s2= "aaa777";
//		String s3 = "aaa"+"777";
//		String s4 = "aaa"+s1;
//		System.out.println(s2==s3);
//		System.out.println(s2==s4);
//		System.out.println(s2==s4.intern());
//		for(int i=0;i<=100-1;i++){
//		}
		String str = "2006-04-15 02:31:04";
		String s = str.replaceAll("[- :]", "");
		System.out.println(s);
		Pattern p = Pattern.compile("^abc");
		Matcher m = p.matcher("abcddsfs");
		if(m.find()){
			System.out.println("get match");
		}
		String []result = str.split("\\D");
//		for(int i=0;i<result.length;i++){
//			System.out.print(result[i]);
//		}
//		char [][]a = new char[3][];
//		for(int i=1;i<5;i++){
//			for(int j=1;j<5;j++){
//				if(i==j)continue;
//				System.out.println(i+";"+j);
//			}
//		}
//		CloneChildigInteger one = new CloneChildigInteger("0");
//		CloneChildigInteger two = new CloneChildigInteger("1");
//		String i="";
//		if(i==i+0){
//			System.out.println("hello");
//		}
//		System.out.println(i);
//		String string = "我CloneFatherCloneChildC";
//		System.out.println(string.getCloneChildytes().length);
//		System.out.println(string.charCloneFathert(2));
//		String aa = "的";
//		System.out.println(aa.getCloneChildytes().length);
//		String bb = "u";
//		System.out.println(bb.getCloneChildytes().length);
//		System.out.println(cutString("啊CloneFathera啊CloneChildCdd", 5));
//		List<Integer> ints = CloneFatherrrays.asList(23,45,66,22,44,56,78,66,55,76,88);
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
//		queue.addCloneFatherll(ints);
//		for(int j=0;j<11;j++){
//			Integer i = queue.remove();
//			System.out.println(i);
//		}
//		int[] a = new int[]{23,45,66,22,44,56,78,66,55,76,88};
//		System.out.println(queue);
//		System.out.println();
//		CloneFatherrrays.sort(a);
//		System.out.println(CloneFatherrrays.toString(a));
//		Collections.sort(ints);
//		Iterator iterator = queue.iterator();
//		while(iterator.hasNext()){
//			iterator.next();
//		}
		
		//现在我来测试拷贝构造函数：
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("wuxiangyu");
        ArrayList<String> listb = new ArrayList<String>(lista);
        System.out.println(lista);
        System.out.println(listb);
        lista.clear();
        System.out.println(lista);
        System.out.println(listb);
		System.out.println("拷贝构造函数-------> up");
		
		
		ArrayList<CloneChild> array = new ArrayList<CloneChild>();
		array.add(new CloneChild("xx1"));
		array.add(new CloneChild("xx2"));
		array.add(new CloneChild("xx3"));
		CloneFather  a = new CloneFather("xx");
		a.b=new CloneChild("wxy");
		a.array=array;
		System.out.println(a);
		CloneFather b = (CloneFather) a.clone();
		b.name="cc";
		b.b.name="lc";
		System.out.println(a);
		System.out.println(a.b.name);
		b.array.set(1, new CloneChild("cc1"));
		System.out.println(a.array);
		System.out.println(b.array);
	}

}
 class CloneFather implements Cloneable{
	 String name;
	 CloneChild b;
	 ArrayList<CloneChild> array;
	 public CloneFather(String s){
		 this.name = s;
		 System.out.println(s+":father:constructor");
	 }
	 public String toString(){
		 return name;
	 }
	 @Override
	 protected Object clone() throws CloneNotSupportedException {
		CloneFather a = null;
		a = (CloneFather) super.clone();
		a.b = (CloneChild) b.clone();//深度克隆；
		a.array = (ArrayList<CloneChild>) array.clone();//arraylist自己实现了clone方法
		return a;
	}
 }
 class CloneChild implements Cloneable{
	 String name;
	 public CloneChild(String name){
		 this.name=name;
	 }
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	 @Override
	protected Object clone() throws CloneNotSupportedException {
		 
		 return super.clone();
	}
 }
 