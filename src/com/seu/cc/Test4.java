package com.seu.cc;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test4 {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("http://www.sohu.com");
		System.out.println("baidu "+ip.isReachable(20000));
		System.out.println(ip.getHostAddress());
		
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("localhost "+local.isReachable(20000));
		System.out.println(local.getHostAddress());
	}

}
