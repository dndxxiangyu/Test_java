package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket socket=null;
		OutputStream os=null;
		try {
			socket=new Socket("127.0.0.1",9999);
			os = socket.getOutputStream();
			os.write("i am xiangyu".getBytes());
			new CReceive(socket).start();//接收消息的线程
			new CSend(socket).start();//发送消息的线程
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(os!=null){
//			try {
//				os.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			System.out.println(socket.isClosed());
		}
	}

}
class CReceive extends Thread{
	Socket socket;
	public CReceive(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("CReceive--->run");
		while(true){
			//不停的读取从服务器端发来的消息
			InputStream is=null;
			try {
				is=socket.getInputStream();
				int len=0;
				byte[] b = new byte[1024];
				System.out.println("等待连接-------");
				len = is.read(b);
				System.out.println("接收数据-------");
				System.out.println("服务器发来的消息:"+new String(b,0,len));
			} catch (Exception e) {
				
			}finally{
				if(is!=null){
//					try {
//						is.close();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
				}
			}
		}
	}
}
class CSend extends Thread{
	Socket socket;
	public CSend(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("CSend--->run");
			//send message to server
		for(int i=0;i<10;i++){	
			OutputStream os=null;
			try {
			os=socket.getOutputStream();
			Thread.sleep(10);
			os.write(("i am server sending +"+i+"\n").getBytes());
			} catch (Exception e) {
				
			}finally{
				if(os!=null){
//					try {
//						os.close();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
				}
			}
		}
	}
}