package com.learning.java8.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterDemo {

	public static void main(String[] args) {
		String[] arrayStream = {"Ajay","Akshay","Hrithik"};
		Stream<String> stringStream = Stream.of(arrayStream);
		stringStream
			//.filter(new MyPredicate())
			.filter(x -> x.startsWith("A"))
			.peek(System.out::println)
			.count();
	}
}

class MyPredicate implements Predicate<String>{

	@Override
	public boolean test(String t) {
		return t.startsWith("H");
	}
	
}