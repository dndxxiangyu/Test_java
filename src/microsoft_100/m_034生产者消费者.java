package microsoft_100;


public class m_034生产者消费者 {

	/**
	 * 34.实现一个队列。
	 * 队列的应用场景为：
	 * 一个生产者线程将int类型的数入列，一个消费者线程将int类型的数出列
	 */
	public static void main(String[] args) {
		Queue queue = new Queue();
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		p.start();
		c.start();
	}
}
//生产者和消费者共用一个queue，就是只有一个队列对象
class Producer extends Thread{
	Queue queue;
	Producer(Queue queue){
		this.queue = queue;
	}
	public void run() {
		for(int i=0;i<10;i++){
			queue.put(i);
			System.out.println("producer put "+i);
		}
	}
}
class Consumer extends Thread{
	Queue queue;
	Consumer(Queue queue){
		this.queue = queue;
	}
	public void run() {
		while(true){
			System.out.println("Consumer get "+queue.get());
		}
	}
}
class Queue{
	int value;
	boolean full = false;
	//同步方法用的是this同步
	public synchronized void put(int i){
		if(!full){
			value = i;
			full = true;
			this.notify();
		}
		try {
			//如果full=true，则阻止自己的线程再继续put，直到把数据取走
			this.wait();//会把this的锁释放掉，不然怎么都不能get到值。
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized int get(){
		if(!full){
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		full = false;
		this.notify();//唤醒一个线程
		return value;
	}
}