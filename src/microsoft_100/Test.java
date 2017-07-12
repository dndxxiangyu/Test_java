package microsoft_100;

import java.util.Arrays;

public class Test {

	/**
	 * @param args
	 */
	static int id=10;
	public static void main(String[] args) {
		int[][] x = new int[2][];
		System.out.println(x[1]);
		System.out.println("ab".length());
		System.out.println(Arrays.toString("  x  x".split(" ")));
		System.out.println("  x  x".split(" ").length);
	}
	
}
class T extends Thread{
	@Override
	public void run() {
		System.out.println("T");
	}
}
abstract class cc{
	public cc(){
		System.out.println("cc");
	}
}
class xx extends cc{
	public xx(){
		System.out.println("xx");
	}
}
class T1 extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			
			System.out.println(Thread.holdsLock(this));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int a=10/0;
		System.out.println("over");
		
		
	}
}
class St{
	String st;
	public static void get(St s){
		System.out.println(s.st);
	}
}