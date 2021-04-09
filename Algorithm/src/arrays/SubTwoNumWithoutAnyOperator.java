package arrays;

public class SubTwoNumWithoutAnyOperator {

	static int sub(int x, int y) {
        while (y != 0) {
            int carry = (x & y) >> 1;
            x = x ^ y;
            y = carry;
        }
        return x;
    }
	
	public static void main(String[] args) {
		System.out.println(sub(13, 5));

	}

}
