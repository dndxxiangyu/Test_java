package design;

public class FactoryModel {

	/**
	 * 工厂模式
	 */
	public static void main(String[] args) {
		Factory factory = Benz.factory;
		factory.getCar().drive();
		factory.getCar().getName();
	}

}
//抽象产品
interface Car{
	void drive();
	void getName();
}
//抽象工厂
interface Factory{
	public Car getCar();
}
//具体实现产品
class Benz implements Car{
	public void drive() {
		System.out.println("开奔驰车");
	}
	public void getName() {
		System.out.println("我叫奔驰");
	}
	//可以用下面的具体工厂类来代替
	public static Factory factory = new Factory(){
		public Car getCar() {
			return new Benz();
		}
	};
}
class Audi implements Car{
	public void drive() {
		System.out.println("开奥迪车");
	}
	public void getName() {
		System.out.println("我叫奥迪");
	}
	public static Factory factory = new Factory(){
		public Car getCar() {
			return new Audi();
		}
	};
}
//可以把具体的工厂写在每个具体实现类的里面作为一个静态方法，或者单独的作为每个静态方法类。
//具体工厂
class BenzFactory implements Factory{
	public Car getCar() {
		return new Benz();
	}
}
class AudiFactory implements Factory{
	public Car getCar() {
		return new Audi();
	}
}