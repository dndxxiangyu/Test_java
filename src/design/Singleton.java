package design;
import java.util.ArrayList;
import java.util.Vector;


public class Singleton {
	public static void main(String[] args) throws Exception{
//		SingleClass s1 = SingleClass.getInstance();
//		SingleClass s2 = SingleClass.getInstance();
		TestRun a = new TestRun();
		TestRun b = new TestRun();
		Thread s = new Thread(a);
		s.start();
		Thread s1 = new Thread(b);
		s1.start();
		Single.getInstance();
	}
}
class SingleClass{
    private static SingleClass uniqueInstance = null;
 
    private SingleClass() {
       System.out.println("constructor");
    }
 
    public synchronized static SingleClass getInstance(){
       if (uniqueInstance == null) {
           uniqueInstance = new SingleClass();
       }
       return uniqueInstance;
    }
}
class TestRun implements Runnable{
	public void run() {
		try {
			SingleTwo.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class SingleTwo{
	private SingleTwo(){
		System.out.println("constructor");
	}
	private static SingleTwo single = null;
	public static synchronized SingleTwo getInstance(){
		if(single == null){
			single = new SingleTwo();
		}
		return single;
	}
}
class SingleOne{
	private final static SingleOne unique = new SingleOne();
	private  SingleOne(){
		System.out.println("constructor");
	}
	public static SingleOne getInstance(){
		return unique;
	}
}
class Single{
	private static Single  single = null;
	private Single(){
		System.out.println("constructor");
	}
	public static Single getInstance(){
		if(single==null){
			synchronized (Single.class) {
				if(single==null){
					single = new Single();
				}
			}
		}
		return single;
	}
}
