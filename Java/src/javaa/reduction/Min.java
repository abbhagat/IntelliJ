package javaa.reduction;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Min {

	public static void main(String[] args) {

		String s1 = null;
		Optional<String> s2 = null;

		s1 = Stream.of("C", "D", "A", "B", "A", "E").min(String::compareTo).orElse("None");
		System.out.println(s1);

		s2 = Stream.of("C", "D", "A", "B", "A", "E").reduce((x, y) -> x.compareTo(y) <= 0 ? x : y);
		System.out.println(s2.get());

		s1 = Stream.of("C", "D", "A", "B", "A", "E").max(String::compareTo).orElse("None");
		System.out.println(s1);

		s2 = Stream.of("C", "D", "A", "B", "A", "E").reduce((x, y) -> x.compareTo(y) >= 0 ? x : y);
		System.out.println(s2.get());

		double sum = DoubleStream.of(1.1, 1.5, 2.5, 5.4).sum();
		System.out.println(sum);

		sum = DoubleStream.of(1.1, 1.5, 2.5, 5.4).reduce(0, Double::sum);
		System.out.println(sum);
		
	}

}
