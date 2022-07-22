package java8.stream;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectingAsSetUsingStream {

    public static void main(String[] args) {
        String whiteListedOrgId = "0fb524a1-15b7-4cb2-88f1-2981474954b0,a4bda066-c5fc-4247-9f00-0bfab1922ac8,199758c1-96ca-4e95-b139-0bbbcfa6252b, ,10ce4dd3-8aa8-4385-8dff-b24b044357fe";
        Set<String> set = Arrays.stream(whiteListedOrgId.split(",")).filter(s -> !s.isBlank()).collect(Collectors.toUnmodifiableSet());
        System.out.println(set);
        set = Arrays.stream(whiteListedOrgId.split(",")).filter(Predicate.not(String::isBlank)).collect(Collectors.toUnmodifiableSet());
        System.out.println(set);
    }
}
