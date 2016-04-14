package designer;

public class Singleton {
	private Singleton(){}
	public static Singleton getInstance(){
		return SinigletonHolder.singleton;
	}
	
	private static class SinigletonHolder{
		private static final Singleton singleton = new Singleton();
	}
}
