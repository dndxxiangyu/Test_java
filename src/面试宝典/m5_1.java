package 面试宝典;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class m5_1 {

	int i=1;
	public static void main(String[] args) {
		System.out.println(get(10));
		Test2 te = new Test2();
		te.print();
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put(null, 1);
		System.out.println(hash);
		ConcurrentHashMap<String, Integer> con = new ConcurrentHashMap<String, Integer>();
		con.put("a", 1);
		System.out.println(con);
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		table.put("a", 1);
		System.out.println(table);
		Random r = new Random();
		hash.put("a", r.nextInt(10));
		System.out.println(hash);
		Single.getInstance();
		Testt t = new Testt();
		t.start();
//		t.start();
		T3 t3 = new T3(10);
		System.out.println(t3.getData());
		System.out.println(t3.doGetData());
		t3.get();
	}
	public static int addBy(int a, int b){
		if(a==0)return b;
		int a1 = a^b;
		int a2 = (a&b)<<1;
		return addBy(a2,a1);
	}
	public static int get(int i){
		return ++i;
	}
	public static boolean isMirror(char[] in){
		int i=0;
		int j=in.length-1;
		while(i<j){
			if(in[i]==in[j]){
				i++;j--;
			}else{
				return false;
			}
		}
		return true;
	}
}
class Test1{
	int a;
	public Test1() {
		a=1;
	}
	void print(){
		System.out.println(a);
	}
}
class Test2 extends Test1{
	int a;
	public Test2() {
		a=2;
	}
	
}
class Single{
	private static Single u;
	private Single(){
	}
	public static Single getInstance(){
		if(u==null){
			synchronized (Single.class) {
				if(u==null){
					u = new Single();
				}
			}
		}
		return u;
	}
	@Override
	protected Single clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Single)super.clone();
	}
}
class Testt extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("test");
	}
}
class T1{
	int data;
	public T1(int data){
		this.data = data;
	}
	int getData(){
		return doGetData();
	}
	int doGetData(){
		return data;
	}
}
class T2 extends T1{
	int data;
	public T2(int data){
		super(0);
		this.data = data;
	}
	int doGetData(){
		return data;
	}
}
class T3 extends T2{
	int data;
	protected void get(){}
	public T3(int data) {
		super(1);
		this.data = data;
	}
}