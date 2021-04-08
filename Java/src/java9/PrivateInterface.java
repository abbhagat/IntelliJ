package java9;

interface Sayable {
	
	default void say() {
		saySomething();
	}

	private void saySomething() {
		System.out.println("Hello... I'm private method");
	}
}

public class PrivateInterface implements Sayable {
	public static void main(String[] args) {
		Sayable s = new PrivateInterface();
		s.say();
	}
}
