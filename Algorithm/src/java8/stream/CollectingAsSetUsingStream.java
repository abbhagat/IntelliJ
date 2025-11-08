package java8.stream;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectingAsSetUsingStream {

    public static void main(String[] args) {
        String whiteListedOrgId = "1,2,3, ,4, ,5,1,2";
        Set<String> set = Arrays.stream(whiteListedOrgId.split(","))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(set);
        set = Arrays.stream(whiteListedOrgId.split(","))
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(set);
    }
}
