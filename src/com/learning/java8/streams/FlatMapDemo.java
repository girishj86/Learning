package com.learning.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {

	public static void main(String[] args) {
		Function<Integer, Stream<Integer>> myStreamFunction = x -> Stream.of(x * x, x * x * x);
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		integerList.stream()
				// .flatMap((x) -> Stream.of(x*x,x*x*x))
				.flatMap(myStreamFunction)
				.distinct()
				.peek(x -> System.out.println(x))
				.collect(Collectors.toList());

	}

}
