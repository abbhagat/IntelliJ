package string;

import java.util.StringTokenizer;

public class SplitAndTokenizer {
    public static void main(String[] args) {
        String s = "Java,is;an.OOP,~!@#$hello,is,how*are(u)";
        StringTokenizer st = new StringTokenizer(s, ",", false);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            // break;
        }
        String[] str = s.split(",");
        for (String s1 : str) {
            System.out.println(s1);
        }
    }
}
