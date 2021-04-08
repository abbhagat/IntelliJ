package oracle;

public class ReplaceAllSpacesinAStringWithPercentage20 {

    static private char[] replaceAllSpace(char[] a) {
        int c = 0;
        for (char x : a) {
            if (x == ' ') {
                c++;
            }
        }
        char[] ch = new char[a.length + (2 * c)];
        int i = 0, j = 0;
        while (i < a.length) {
            if (a[i] != ' ') {
                ch[j] = a[i];
                i++;
                j++;
            } else {
                ch[j++] = '%';
                ch[j++] = '2';
                ch[j++] = '0';
                i++;
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        String str = "Java is an OOP . ";
        String s = "";
        for (char x : str.toCharArray()) {
            s += (x != ' ') ? x : "%20";
        }
        System.out.println(s);
        System.out.println();
        System.out.println(replaceAllSpace(str.toCharArray()));
    }

}
