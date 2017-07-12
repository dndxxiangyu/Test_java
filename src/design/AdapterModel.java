package design;

public class AdapterModel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Duck{
	public void move(){
		System.out.println("Duck move");
	}
}
interface TurkyInt{
	public void move();
}
class Adapter implements TurkyInt{
	Duck duck;//现有的类
	public Adapter(Duck duck){
		this.duck = duck;
	}
	public void move() {
		duck.move();
	}
}