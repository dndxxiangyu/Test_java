package design;

public class DecoratorModel {

	/**
	 * 装饰者模式
	 */
	public static void main(String[] args) {
		
		Beverage b = new HouseBlend();
		b = new Mocha(b);
		b = new Mocha(b);
		b = new Mocha(b);
		b = new Mocha(b);
		System.out.println(b.cost());
		System.out.println(b.getDescription());
	}

}

//被装饰者抽象类,也可以是接口
abstract class Beverage {
	String description = "Unknown Beverage";
	
	public String getDescription(){
		return description;
	}
	public abstract double cost();
}

//被装饰者具体类
class HouseBlend extends Beverage{
	public HouseBlend(){
		description = "House Blend Coffee";
	}
	@Override
	public double cost() {
		return 0.89;
	}
}

//装饰者抽象类
abstract class CondimentDecorator extends Beverage{
	public abstract String getDescription();
}
 
//装饰者的具体类
class Mocha extends CondimentDecorator{
	Beverage beverage;//需要有一个被装饰者
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return 0.20 + beverage.cost();
	}

}


