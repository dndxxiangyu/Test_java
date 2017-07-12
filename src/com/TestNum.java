package com;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestNum {

	
	public static void main(String[] args) {
//		float x = 3.14f;
//		int y=0;
//		float z=x/y;
//		System.out.println("the result is :"+z);
//		System.out.println(Double.POSITIVE_INFINITY);
//        System.out.println(Float.POSITIVE_INFINITY);
//        System.out.println(x/2.0);//
//        System.out.println(1.1-1.0);//

        double a=25.8;
        double b=6.4;
        double x= -a%-b;
        double y= a/-b;
        double z= -a%b;
        double r= a%b;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(r);
        System.out.println(100.33f/2.0);
        System.out.println(100.33/2.0);
        BigDecimal bd = new BigDecimal(Float.toString(100.33f));
        BigDecimal bd1 = new BigDecimal(Double.toString(2.0));
        System.out.println(bd.divide(bd1).doubleValue());
//        int cc=1111111111111111111111111111111;
//        System.out.println(cc);
        String string = "我想ded";
        System.out.println(string.length());
        System.out.println(string.getBytes().length);
        System.out.println((int)('1'));
        BigInteger bi = new BigInteger("111111111111111111111111");
        BigInteger bi1 = new BigInteger("111111111111111111111111");
        System.out.println(bi.multiply(bi1));
        int com = "a".compareTo("a");
        System.out.println(com);
	}

}
