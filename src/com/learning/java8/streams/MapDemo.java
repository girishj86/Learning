package com.learning.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapDemo {
	
	// map takes Function<T,R> with T as argument 
	// and R as return value

	public static void main(String[] args) {
		Function<String,String> stringFunction = (x) -> x.toUpperCase();
		List<String> stringList = Arrays.asList("Ajay","Akshay","Hrithik");
		stringList.stream()
				  //.map(x -> x.toUpperCase())
				  .map(stringFunction)
				  .peek(x -> System.out.println(x))
				  .collect(Collectors.toList());


	}

}


