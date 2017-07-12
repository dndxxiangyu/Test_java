package com.seu.cc;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Internet {

	/**
	 * java网络
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("119.75.218.77");
		System.out.println("百度是否可达： "+ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
	}

}
