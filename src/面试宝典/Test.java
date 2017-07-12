package 面试宝典;

import java.util.Arrays;
import java.util.Random;

public class Test {
	public static void main(String[] args){
		int Testnum=12;
		int[] pic_arr = new int[Testnum];
		for(int i=0;i<Testnum;i++){
			if(i%4==0){
				pic_arr[i]=1;
			}else if(i%4==2){
				pic_arr[i]=2;
			}else{
				int a = new Random().nextInt(21)%2;
				pic_arr[i] = 1 + a;
				System.out.println(a);
			}
		}
		System.out.println(Arrays.toString(pic_arr));
	}

	 
}
class T extends Thread{
	@Override
	public void run() {
		System.out.println("start-----");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
//			this.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end-----");
	}
}