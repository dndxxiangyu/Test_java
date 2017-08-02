package netease;

public class StaticMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father father = new Father();
		father.testMethod();
		father.testStaticMethod();
		Father child1 = new Child1();
		child1.testMethod();
		child1.testStaticMethod();
		Child1 child = (Child1) child1;
		child.testStaticMethod();
	}

}

class Father {
	public void testMethod() {
		System.out.println("father testMethod");
	}

	public static void testStaticMethod() {
		System.out.println("father testStaticMethod");
	}
}

class Child1 extends Father {

	public void testMethod() {
		System.out.println("Child1 testMethod");
	}

	public static void testStaticMethod() {
		System.out.println("Child1 testStaticMethod");
	}
}
class Child2 extends Father {

	public void testMethod() {
		System.out.println("Child2 testMethod");
	}

	public static void testStaticMethod() {
		System.out.println("Child2 testStaticMethod");
	}
}