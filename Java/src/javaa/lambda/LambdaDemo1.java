package javaa.lambda;

interface I {
	void draw();
}

public class LambdaDemo1 {

	public static void main(String[] args) {
		I i1 = new I() {
			public void draw() {
				System.out.println("draw() of I called inside anonymous inner class");
			}
		};

		i1.draw();

		I i2 = () -> {
			System.out.println("draw() of I called using Lambda expression");
		};

		i2.draw();
	}

}
