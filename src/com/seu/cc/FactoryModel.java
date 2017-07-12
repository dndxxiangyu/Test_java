package com.seu.cc;

import java.math.BigInteger;
import java.util.Random;

public class FactoryModel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Car car = Driver.drverCar("benz");
//		car.drive();
		System.out.println(Math.floor(-3.5));
		System.out.println(Math.floor(3.5));
		System.out.println(Math.round(-3.5));
		System.out.println(Math.round(3.5));
		double a=0.13f;
		System.out.println(a);
		BigInteger b1 = new BigInteger("1111");
		BigInteger b2 = new BigInteger("2222");
		b1.add(b2);
		System.out.println(b1);
		Random random = new Random();
		System.out.println(random);
		
	}

}
//interface Car{
//	public void drive();
//}
//class Benz implements Car{
//	public void drive() {
//		System.out.println("Driving Benz");
//	}
//}
//class Bmw implements Car{
//	public void drive() {
//		System.out.println("Driving Bmw");
//	}
//}
////工厂类角色
//class Driver{
//	public static Car drverCar(String s){
//		if(s.equalsIgnoreCase("Benz")){
//			return new Benz();
//		}else if(s.equalsIgnoreCase("Bmw")){
//			return new Bmw();
//		}
//		return null;
//	}
//}
interface Car{
	public void drive();
}
class Benz implements Car{
	public void drive() {
		System.out.println("Driving Benz");
	}
}
class Bmw implements Car{
	public void drive() {
		System.out.println("Driving Bmw");
	}
}
interface Factory{
	public Car getCar();
}