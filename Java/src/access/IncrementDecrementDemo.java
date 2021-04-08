package access;

public class IncrementDecrementDemo {

	public void display(int x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		IncrementDecrementDemo d = new IncrementDecrementDemo();
		int x = 10;
		d.display(x++);
		System.out.println(x);
		d.display(--x);
		System.out.println(x);
	}

}
