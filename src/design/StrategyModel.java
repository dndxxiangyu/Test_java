package design;

public class StrategyModel {

	/**
	 * 策略模式
	 */
	public static void main(String[] args) {
		Context context;
		//刚到吴国的时候拆开第一个  
        System.out.println("----------刚刚到吴国的时候拆开第一个---------------");  
        context = new Context(new BackDoor());  
        context.operate();//拆开执行  
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");  
          
        //当刘备乐不思蜀时，拆开第二个  
        System.out.println("----------刘备乐不思蜀，拆第二个了---------------");  
        context = new Context(new GivenGreenLight());  
        context.operate();//拆开执行  
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");  
          
        //孙权的小追兵了，咋办？拆开第三个锦囊  
        System.out.println("----------孙权的小追兵了，咋办？拆开第三个锦囊---------------");  
        context = new Context(new BlackEnemy());  
        context.operate();//拆开执行  
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
}
class Context {  
    
    private Strategy strategy;  
    //构造函数，要你使用哪个妙计  
    public Context(Strategy strategy){  
        this.strategy = strategy;  
    }  
    
    public void operate(){  
        this.strategy.operate();  
    }  

}
interface Strategy {  
    //每个锦囊妙计都是一个可执行的算法。  
    public void operate();  
}

class BackDoor implements Strategy {  
	  
    public void operate() {  
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备...");  
    }  
}  
class GivenGreenLight implements Strategy {  
	  
    public void operate() {  
        System.out.println("求吴国太开个绿灯，放行！");  
    }  
}
class BlackEnemy implements Strategy {  
	  
    public void operate() {  
        System.out.println("孙夫人断后，挡住追兵...");  
    }  
} 
