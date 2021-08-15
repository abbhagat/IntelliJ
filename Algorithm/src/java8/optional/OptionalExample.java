package java8.optional;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		String[] str = new String[10];
		str[5] = "JAVA OPTIONAL CLASS EXAMPLE";          // Setting value for 5th index
		Optional<String> empty = Optional.empty();      // It returns an empty instance of Optional class
		System.out.println(empty);                     // It returns a non-empty Optional
		Optional<String> value = Optional.of(str[5]); // If value is present, it returns an Optional otherwise throws NPE
		System.out.println("Filtered value: " + value.filter((s) -> s.equals("Abc")));
		System.out.println("Filtered value: " + value.filter((s) -> s.equals("JAVA OPTIONAL CLASS EXAMPLE")));

		System.out.println("Getting value: " + value.get()); // It returns value of an Optional. if value is not present, throws NoSuchElementException

		System.out.println("Getting hashCode: " + value.hashCode());// It returns hashCode of the value

		System.out.println("Is value present: " + value.isPresent()); // It returns true if value is present, otherwise false

		System.out.println("Nullable Optional: " + Optional.ofNullable(str[5])); // It returns non-empty Optional if value is present, otherwise returns an empty Optional

		System.out.println("orElse: " + value.orElse("Value is not present")); // It returns value if available otherwise returns specified value
		System.out.println("orElse: " + empty.orElse("Value is not present"));
		value.ifPresent(System.out::println); // printing value by using method reference
	}
}
