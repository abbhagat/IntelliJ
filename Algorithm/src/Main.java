import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    Set<Character> set = "ABC".chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    char[] c = set.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
  }
}
