package jpmorgan;

/**
 * I/P :- int[] a = { 4, 3, 2, 0, 1 }; char[] c = { 'e', 'd', 'c', 'a', 'b' };
 * 
 * O/P :- int[] a = { 0, 1, 2, 3, 4 }; char[] c = { 'a', 'b', 'c', 'd', 'e' };
 * 
 * Both the array has to be sorted in O(n).
 */
public class SortinginBigO_n {

	static void swap(int i, int j, int[] a) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static void swap(int i, int j, char[] c) {
		char x = c[i];
		c[i] = c[j];
		c[j] = x;
	}

	static void permutate(int[] pos, char[] chars) {
		for (int i = 0; i < chars.length;) {
			if (i != pos[i]) {
				swap(i, pos[i], chars);
				swap(i, pos[i], pos);
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 0, 1 };
		char[] c = { 'e', 'd', 'c', 'a', 'b' };
		permutate(a, c);
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
		for (char x : c) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

}
