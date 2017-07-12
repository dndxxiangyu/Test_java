package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ǧ���������ص�!
 *
 */
public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		InputStream inputStream =null;
		Socket socket =null;
		try {
			serverSocket = new ServerSocket(9999);
			socket = serverSocket.accept();
			inputStream = socket.getInputStream();
			byte buffer [] = new byte[1024];
			int temp=0;
			//��InputStream���ж�ȡ�ͻ��������͵�����
			System.out.println("�������ȴ�����-------");
			temp = inputStream.read(buffer);
			System.out.println("��������������-------");
			System.out.println(new String(buffer,0,temp));
			
			System.out.println("get the message from client");
			new SReceive(socket).start();
			new SSend(socket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				//���ܹرգ���Ȼ��û��������
//				serverSocket.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			System.out.println(socket.isClosed());
		}

	}

}
class SReceive extends Thread{
	Socket socket;
	public SReceive(Socket socket){
		this.socket = socket;
	}
	public void run() {
		System.out.println("SReceive--->run");
		while(true){
			//��ͣ�Ķ�ȡ�ӿͻ��˷�������Ϣ
			InputStream is=null;
			try {
				is=socket.getInputStream();
				int len=0;
				byte[] b = new byte[1024];
				len = is.read(b);
				System.out.println("�ͻ���������Ϣ:"+new String(b,0,len));
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
class SSend extends Thread{
	Socket socket;
	public SSend(Socket socket){
		this.socket = socket;
	}
	public void run() {
		System.out.println("SSend--->run");
		for(int i=0;i<10;i++){
			//��ͣ�Ķ�ȡ�ӿͻ��˷�������Ϣ
			OutputStream os=null;
			try {
				os=socket.getOutputStream();
				Thread.sleep(10);
				os.write(("i am server +"+i).getBytes());
			} catch (Exception e) {
				
			}finally{
				System.out.println("socket is closed:"+socket.isClosed());
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
