package com.test.cc;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-4 下午2:32:58
 */
public class MacTest {

	
	public static void main(String[] args) throws Exception {
		String mac = getMac();
		String mac1 = getMacAddress();
//		System.out.println(mac);
		System.out.println(mac1);

//		InetAddress ia = InetAddress.getLocalHost();
//		System.out.println(ia);
//		getLocalMac(ia);
	}
	private static void getLocalMac(InetAddress ia) throws SocketException {
		// TODO Auto-generated method stub
		//获取网卡，获取地址
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			System.out.println("每8位:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
	}
	public static String getMacAddress() throws Exception{  
        Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();  
          
        while(ni.hasMoreElements()){  
            NetworkInterface netI = ni.nextElement();  

            byte[] bytes = netI.getHardwareAddress();  
            if(netI != null && netI.isUp() && bytes != null && bytes.length == 6){  
                StringBuffer sb = new StringBuffer();  
                for(byte b:bytes){  
                     //与11110000作按位与运算以便读取当前字节高4位  
                     sb.append(Integer.toHexString((b&240)>>4));  
                     //与00001111作按位与运算以便读取当前字节低4位  
                     sb.append(Integer.toHexString(b&15));  
                     sb.append(":");  
                 }  
                 sb.deleteCharAt(sb.length()-1);  
                 return sb.toString().toUpperCase();   
            }  
        }  
        return null;  
    }  
	private static String parseByte(byte b) {  
        String s = "00" + Integer.toHexString(b)+":";  
        return s.substring(s.length() - 3);  
	}  

    /** 
     * 获取当前系统连接网络的网卡的mac地址 
     * @return 
     */  
    public static final String getMac() {  
        byte[] mac = null;  
        StringBuffer sb = new StringBuffer();  
        try {  
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();  
            while (netInterfaces.hasMoreElements()) {  
                NetworkInterface ni = netInterfaces.nextElement();  
                Enumeration<InetAddress> address = ni.getInetAddresses();  
                  
                while (address.hasMoreElements()) {  
                    InetAddress ip = address.nextElement();  
                    if (ip.isAnyLocalAddress() || !(ip instanceof Inet4Address) || ip.isLoopbackAddress())  
                        continue;  
                    if (ip.isSiteLocalAddress())  
                        mac = ni.getHardwareAddress();  
                    else if (!ip.isLinkLocalAddress()) {  
                        mac = ni.getHardwareAddress();  
                        break;  
                    }  
                }  
            }  
        } catch (SocketException e) {  
            e.printStackTrace();  
        }  
          
        if(mac != null){  
            for(int i=0 ;i<mac.length ;i++){  
                sb.append(parseByte(mac[i]));  
            }  
            return sb.substring(0, sb.length()-1);  
        }else{  
            return "";  
        }  
    }  
}
