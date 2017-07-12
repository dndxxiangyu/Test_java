package com.seu.cc;
/**
 * 线程局部变量
 * 就是为每一个使用该变量的线程都提供一个变量值的副本
 * 每个线程中保存不同的值
 */
public class ThreadLocala {

	public static void main(String[] args) throws InterruptedException {
		Account a = new Account("firstName");
		Testz t = new Testz(a,"线程甲");
		Thread x1 = new Thread(t);
		Thread x2 = new Thread(t);
		x1.start();
		x2.start();
		Thread.sleep(1000);
		System.out.println(a.getName());
	}

}
class Account{
	private ThreadLocal<String> name = new ThreadLocal<String>();
	public Account(String str){
		this.name.set(str);
	}
	public String getName(){
		return this.name.get();
	}
	public void setName(String str){
		this.name.set(str);
	}
}
class Testz implements Runnable{
	private Account account;
	public Testz(Account a,String name){
		this.account = a;
	}
	public void run(){
		for(int i=0;i<10;i++){
			if(i==6){
				account.setName(Thread.currentThread().getName());
			}
			System.out.println(account.getName()+"账户的i值： "+i);
		}
	}
}