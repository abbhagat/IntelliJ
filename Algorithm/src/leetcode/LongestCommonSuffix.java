package leetcode;

public class LongestCommonSuffix {

	public static void main(String[] args) {
		String[] str = "ABCDEBUILD,OUCTBUILD".split(",");
		String s1 = str[0];
		String s2 = str[1];
		String s = "";
		int i = s1.length() - 1, j = s2.length() - 1;
		while (i >= 0 && j >= 0) {
			if (s1.charAt(i) == s2.charAt(j)) {
				s += s1.charAt(i);
			} else {
				break;
			}
			i--;
			j--;
		}
		StringBuilder sb = new StringBuilder(s);
    	System.out.println(sb.length() == 0 ? "NULL" : sb.reverse());
	}

}
