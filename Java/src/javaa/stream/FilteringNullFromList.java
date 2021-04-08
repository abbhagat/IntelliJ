package javaa.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilteringNullFromList {

    public static void main(String[] args) {
        List<String> language = Arrays.asList("English", null, "Hindi", null);
        List<String> result = language.stream().filter(Objects::nonNull).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
