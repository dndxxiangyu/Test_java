package design;

public class ProxyModel {

	
	public static void main(String[] args) {
		Proxy p = new Proxy();
		p.method();
		
	}

}
interface Sourceable {
	public void method();
}
class Source implements Sourceable{
	public void method() {
		System.out.println("the original method!");
	}
}
class Proxy implements Sourceable{
	private Source source;
	public Proxy(){
		this.source = new Source();
	}
	public void method() {
		before();
		source.method();
		after();
	}
	public void before(){
		System.out.println("before");
	}
	public void after(){
		System.out.println("after");
	}
	
}