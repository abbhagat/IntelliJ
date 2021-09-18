package cisco;

public class CountWordsInASentence {

    public static int howMany(String sentence) {
        String[] str = sentence.split(" ");
        int count = 0;
        for (String s : str) {
            if (!s.isEmpty()) {
                char[] a = s.trim().toCharArray();
                boolean flag = true;
                for (char c : a) {
                    if (!(c >= 65 && c <= 90 || c >= 97 && c <= 122 || c == '-' || c == ',' || c == '?' || c == '.' || c == '!')) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String sentence = "jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj.";
        System.out.println(howMany(sentence));
    }
}
