package amazon;

import java.util.Arrays;

public class NBonacciNumber {

	public static void main(String[] args) {
		final int m = 7;
		final int n = 3;
		int[] a = new int[m];
		a[n - 1] = 1;
		a[n] = 1;
		for (int i = n + 1; i < m; i++) {
			a[i] = 2 * a[i - 1] - a[i - n - 1];           // a[i] = 2*a[i-1] - a[i-n-1];
		}

		System.out.println(Arrays.toString(a));
	}

}
