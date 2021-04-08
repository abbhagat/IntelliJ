package javaa.lambda;

interface Operation {
	int arithmeticOps(int x, int y);
}

public class LambdaExpWithMultipleParams {

	public static void main(String[] args) {
		Operation add = (x, y) -> (x + y);
		System.out.println(add.arithmeticOps(10, 5));
		Operation sub = (x, y) -> (x - y);
		System.out.println(sub.arithmeticOps(10, 5));
		Operation mul = (x, y) -> (x * y);
		System.out.println(mul.arithmeticOps(10, 5));
		Operation div = (x, y) -> (x / y);
		System.out.println(div.arithmeticOps(10, 5));

		Operation add1 = (int x, int y) -> {
			return (x + y);
		};
		System.out.println(add1.arithmeticOps(10, 5));

		Operation sub1 = (int x, int y) -> {
			return (x - y);
		};
		System.out.println(sub1.arithmeticOps(10, 5));

		Operation mul1 = (int x, int y) -> {
			return (x * y);
		};
		System.out.println(mul1.arithmeticOps(10, 5));

		Operation div1 = (int x, int y) -> {
			return (x / y);
		};
		System.out.println(div1.arithmeticOps(10, 5));
	}

}
