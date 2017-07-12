package com.seu.cc;

public class Drawa {

	
	public static void main(String[] args) {
		Data data = new Data();
		Get get = new Get(data);
		Draw draw = new Draw(data);
		get.start();
		draw.start();
	}

}
class Get extends Thread{
	Data data;
	public Get(Data data){
		this.data = data;
	}
	public void run() {
		for(int i=0;i<10;i++){
			data.x=i;
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			synchronized (data) {
				data.notify();
			}
		}
	}
}
class Draw extends Thread{
	Data data;
	public Draw(Data data){
		this.data = data;
	}
	public void run() {
		while(true){
			synchronized (data) {
				System.out.println(data.x);
				try {
					data.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class Data{
	int x;
}